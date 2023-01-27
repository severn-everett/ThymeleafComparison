package com.severett.thymeleafcomparison.kotlinscripting.controller

import com.severett.thymeleafcomparison.common.model.form.BookForm
import com.severett.thymeleafcomparison.common.service.AuthorService
import com.severett.thymeleafcomparison.common.service.BookService
import com.severett.thymeleafcomparison.kotlinscripting.scripting.AUTHORS
import com.severett.thymeleafcomparison.kotlinscripting.scripting.BOOK
import com.severett.thymeleafcomparison.kotlinscripting.scripting.BOOKS
import com.severett.thymeleafcomparison.kotlinscripting.scripting.ERRORS
import com.severett.thymeleafcomparison.kotlinscripting.scripting.ScriptExecutor
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
    private val authorService: AuthorService,
    private val bookService: BookService,
    private val scriptExecutor: ScriptExecutor
) {
    @GetMapping(produces = [TEXT_HTML])
    @ResponseBody
    fun getAll(): String {
        return scriptExecutor.executeScript(
            "$SCRIPT_LOCATION/viewbooks.html.kts",
            mapOf(BOOKS to bookService.getAll())
        )
    }

    @GetMapping(value = ["/{id}"], produces = [TEXT_HTML])
    @ResponseBody
    fun get(@PathVariable id: Int): String {
        return scriptExecutor.executeScript(
            "$SCRIPT_LOCATION/viewbook.html.kts",
            mapOf(BOOK to bookService.get(id))
        )
    }

    @GetMapping(value = ["/add"], produces = [TEXT_HTML])
    @ResponseBody
    fun add(): String {
        return scriptExecutor.executeScript(
            "$SCRIPT_LOCATION/addbook.html.kts",
            mapOf(AUTHORS to authorService.getAll())
        )
    }

    @PostMapping(value = ["/save"], produces = [TEXT_HTML])
    @ResponseBody
    fun save(
        @Valid bookForm: BookForm,
        bindingResult: BindingResult,
        httpServletResponse: HttpServletResponse
    ): String {
        return if (!bindingResult.hasErrors()) {
            bookService.save(bookForm)
            httpServletResponse.sendRedirect("/books")
            ""
        } else {
            val errors = bindingResult.allErrors.toFieldErrorsMap()
            scriptExecutor.executeScript(
                "$SCRIPT_LOCATION/addbook.html.kts",
                mapOf(AUTHORS to authorService.getAll(), ERRORS to errors)
            )
        }
    }

    @PostMapping(value = ["/{id}/delete"])
    fun delete(@PathVariable id: Int, httpServletResponse: HttpServletResponse) {
        bookService.delete(id)
        httpServletResponse.sendRedirect("/books")
    }
}
