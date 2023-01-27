package com.severett.thymeleafcomparison.kotlinscripting

import org.springframework.boot.SpringApplication
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(value = ["com.severett.thymeleafcomparison.common", "com.severett.thymeleafcomparison.kotlinscripting"])
open class KotlinScriptingApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinScriptingApplication::class.java, *args)
}
