package com.severett.thymeleafcomparison.kotlinxhtml.controller

import com.severett.thymeleafcomparison.kotlinxhtml.render.home.HomepageRenderer
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController(private val homepageRenderer: HomepageRenderer) {
    @GetMapping(value = ["/", "/home"], produces = [MediaType.TEXT_HTML_VALUE])
    @ResponseBody
    fun home() = homepageRenderer.render()
}
