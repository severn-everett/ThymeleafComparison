package com.severett.thymeleafcomparison.kotlinxhtml.controller

import com.severett.thymeleafcomparison.common.model.form.BookForm
import com.severett.thymeleafcomparison.common.service.BookService
import com.severett.thymeleafcomparison.kotlinxhtml.render.books.ViewBooksPageRenderer
import jakarta.servlet.http.HttpServletResponse
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/books")
class BookController(
    private val viewBooksPageRenderer: ViewBooksPageRenderer,
    private val bookService: BookService
) {
    @GetMapping(produces = [TEXT_HTML])
    @ResponseBody
    fun getAll() = viewBooksPageRenderer.renderPage()

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
    fun save(@Valid bookForm: BookForm, bindingResult: BindingResult, httpServletResponse: HttpServletResponse): String {
        TODO()
    }

    @PostMapping(value = ["/{id}/delete"])
    fun delete(@PathVariable id: Int, httpServletResponse: HttpServletResponse) {
        bookService.delete(id)
        httpServletResponse.sendRedirect("/books")
    }
}
