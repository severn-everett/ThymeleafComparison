package com.severett.thymeleafcomparison.kotlinscripting

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class KotlinScriptingApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinScriptingApplication::class.java, *args)
}
