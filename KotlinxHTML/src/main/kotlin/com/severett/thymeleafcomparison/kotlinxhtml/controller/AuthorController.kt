package com.severett.thymeleafcomparison.kotlinxhtml.controller

import com.severett.thymeleafcomparison.common.model.form.AuthorForm
import com.severett.thymeleafcomparison.kotlinxhtml.render.authors.GetAllPageRenderer
import jakarta.validation.Valid
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

private const val TEXT_HTML = MediaType.TEXT_HTML_VALUE

@Controller
@RequestMapping("/authors")
class AuthorController(
    private val getAllPageRenderer: GetAllPageRenderer
) {
    @GetMapping(produces = [TEXT_HTML])
    @ResponseBody
    fun getAll() = getAllPageRenderer.renderPage()

    @GetMapping(value = ["/{id}"], produces = [TEXT_HTML])
    @ResponseBody
    fun get(@PathVariable id: Int): String {
        TODO()
    }

    @GetMapping(value = ["/add"], produces = [TEXT_HTML])
    @ResponseBody
    fun add(): String {
        TODO()
    }

    @PostMapping(value = ["/save"], produces = [TEXT_HTML])
    @ResponseBody
    fun save(@Valid authorForm: AuthorForm, bindingResult: BindingResult): String {
        TODO()
    }

    @PostMapping(value = ["/{id}/delete"])
    @ResponseBody
    fun delete(@PathVariable id: Int): String {
        TODO()
    }
}
