package com.severett.thymeleafcomparison.kotlinxhtml.controller

import com.severett.thymeleafcomparison.kotlinxhtml.render.error.ErrorPageRenderer
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.boot.web.servlet.error.ErrorController

@Controller
class BookstoreErrorController(private val errorPageRenderer: ErrorPageRenderer) : ErrorController {
    @RequestMapping("/error", produces = [TEXT_HTML])
    @ResponseBody
    fun handleError(request: HttpServletRequest): String {
        val statusCode = request.getAttribute("jakarta.servlet.error.status_code") as Int
        return errorPageRenderer.renderPage(statusCode)
    }
}
