package com.severett.thymeleafcomparison.kotlinscripting.controller

import com.severett.thymeleafcomparison.kotlinscripting.scripting.ScriptExecutor
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController(private val scriptExecutor: ScriptExecutor) {
    @GetMapping(value = ["/", "/home"], produces = [TEXT_HTML])
    @ResponseBody
    fun home() = scriptExecutor.executeScript("$SCRIPT_LOCATION/home.html.kts")
}
