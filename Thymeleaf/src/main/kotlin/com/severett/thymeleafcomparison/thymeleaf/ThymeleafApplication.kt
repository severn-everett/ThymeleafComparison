package com.severett.thymeleafcomparison.thymeleaf

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ThymeleafApplication

fun main(args: Array<String>) {
    SpringApplication.run(ThymeleafApplication::class.java, *args)
}
