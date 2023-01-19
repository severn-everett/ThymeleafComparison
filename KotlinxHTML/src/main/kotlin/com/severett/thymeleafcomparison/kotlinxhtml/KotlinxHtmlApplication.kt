package com.severett.thymeleafcomparison.kotlinxhtml

import org.springframework.boot.SpringApplication
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(value = ["com.severett.thymeleafcomparison.common", "com.severett.thymeleafcomparison.kotlinxhtml"])
open class KotlinxHtmlApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinxHtmlApplication::class.java, *args)
}
