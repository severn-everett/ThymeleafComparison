package com.severett.thymeleafcomparison.kotlinxhtml.controller

import com.severett.thymeleafcomparison.common.model.form.AuthorForm
import com.severett.thymeleafcomparison.common.service.AuthorService
import com.severett.thymeleafcomparison.kotlinxhtml.render.authors.AddAuthorPageRenderer
import com.severett.thymeleafcomparison.kotlinxhtml.render.authors.ViewAuthorPageRenderer
import com.severett.thymeleafcomparison.kotlinxhtml.render.authors.ViewAuthorsPageRenderer
import jakarta.servlet.http.HttpServletResponse
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
    private val viewAuthorsPageRenderer: ViewAuthorsPageRenderer,
    private val viewAuthorPageRenderer: ViewAuthorPageRenderer,
    private val addAuthorPageRenderer: AddAuthorPageRenderer,
    private val authorService: AuthorService
) {
    @GetMapping(produces = [TEXT_HTML])
    @ResponseBody
    fun getAll() = viewAuthorsPageRenderer.renderPage()

    @GetMapping(value = ["/{id}"], produces = [TEXT_HTML])
    @ResponseBody
    fun get(@PathVariable id: Int) = viewAuthorPageRenderer.renderPage(id)

    @GetMapping(value = ["/add"], produces = [TEXT_HTML])
    @ResponseBody
    fun add(): String = addAuthorPageRenderer.renderPage()

    @PostMapping(value = ["/save"], produces = [TEXT_HTML])
    @ResponseBody
    fun save(@Valid authorForm: AuthorForm, bindingResult: BindingResult, httpServletResponse: HttpServletResponse): String {
        return if (!bindingResult.hasErrors()) {
            authorService.save(authorForm)
            httpServletResponse.sendRedirect("/authors")
            ""
        } else {
            val errors = bindingResult.allErrors.toFieldErrorsMap()
            addAuthorPageRenderer.renderPage(errors)
        }
    }

    @PostMapping(value = ["/{id}/delete"])
    fun delete(@PathVariable id: Int, httpServletResponse: HttpServletResponse) {
        authorService.delete(id)
        httpServletResponse.sendRedirect("/authors")
    }
}
