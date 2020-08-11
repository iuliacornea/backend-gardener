package com.iulia.gardener

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GardenerApplication

fun main(args: Array<String>) {
	runApplication<GardenerApplication>(*args)
}
