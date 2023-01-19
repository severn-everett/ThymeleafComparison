package com.severett.thymeleafcomparison.thymeleaf.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {
    @GetMapping(value= ["/", "/home"])
    fun home() = "home"
}
