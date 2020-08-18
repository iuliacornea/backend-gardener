import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenLocal()
    }
    dependencies {
        classpath("org.openapitools:openapi-generator-gradle-plugin:4.3.1")
        classpath("org.springframework:spring-jdbc:5.2.4.RELEASE")
    }
}

plugins {
    id("org.springframework.boot") version "2.3.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"
    kotlin("plugin.jpa") version "1.3.72"
    id("org.openapi.generator") version "4.3.0"
    id("org.flywaydb.flyway") version "6.5.4"
}

group = "com.iulia"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.postgresql:postgresql")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.flywaydb:flyway-core")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

openApiGenerate {
    generatorName.set("kotlin-spring")
    inputSpec.set("$rootDir/src/main/resources/api.yaml".toString())
    outputDir.set("$rootDir/kotlin".toString())
    apiPackage.set("org.openapitools.example.api")
    invokerPackage.set("org.openapitools.example.invoker")
    modelPackage.set("org.openapitools.example.model")

    // https://openapi-generator.tech/docs/generators/kotlin-spring
    configOptions.set(mapOf(
            Pair("dateLibrary", "java8"),
            Pair("interfaceOnly", "true"),
            Pair("library", "spring"),
            Pair("gradleBuildFile", "false"),
            Pair("exceptionHandler", "false"),
            Pair("enumPropertyNaming", "UPPERCASE")
    ))
}

tasks {
    flywayMigrate {
        dependsOn("classes")
    }
    compileKotlin {
        dependsOn("openApiGenerate")
    }
}

