package com.iulia.gardener

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class GardenerApplication

fun main(args: Array<String>) {
	runApplication<GardenerApplication>(*args)
}
