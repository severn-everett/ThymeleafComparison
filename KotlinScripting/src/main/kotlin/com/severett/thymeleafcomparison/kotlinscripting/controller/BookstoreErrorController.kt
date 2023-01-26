package com.severett.thymeleafcomparison.kotlinscripting.controller

import com.severett.thymeleafcomparison.kotlinscripting.scripting.ScriptExecutor
import jakarta.servlet.http.HttpServletRequest
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class BookstoreErrorController(private val scriptExecutor: ScriptExecutor) : ErrorController {
    @RequestMapping("/error", produces = [TEXT_HTML])
    @ResponseBody
    fun handleError(request: HttpServletRequest): String {
        val statusCode = request.getAttribute("jakarta.servlet.error.status_code") as Int
        return scriptExecutor.executeScript(
            "com/severett/thymeleafcomparison/kotlinscripting/scripting/home.html.kts",
            mapOf("status" to statusCode)
        )
    }
}
