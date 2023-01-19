package com.severett.thymeleafcomparison.thymeleaf

import org.springframework.boot.SpringApplication
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(value = ["com.severett.thymeleafcomparison.common", "com.severett.thymeleafcomparison.thymeleaf"])
open class ThymeleafApplication

fun main(args: Array<String>) {
    SpringApplication.run(ThymeleafApplication::class.java, *args)
}
