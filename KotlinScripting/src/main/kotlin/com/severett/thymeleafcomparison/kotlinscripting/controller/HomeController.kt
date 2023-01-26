package com.severett.thymeleafcomparison.kotlinscripting.controller

import com.severett.thymeleafcomparison.kotlinscripting.scripting.ScriptExecutor
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController(private val scriptExecutor: ScriptExecutor) {
    @GetMapping(value = ["/", "/home"], produces = [MediaType.TEXT_HTML_VALUE])
    @ResponseBody
    fun home() = scriptExecutor.executeScript("com/severett/thymeleafcomparison/kotlinscripting/scripting/home.html.kts")
}
