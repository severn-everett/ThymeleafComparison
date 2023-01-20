package com.severett.thymeleafcomparison.thymeleaf.controller

import com.severett.thymeleafcomparison.common.model.form.BookForm
import com.severett.thymeleafcomparison.common.service.AuthorService
import com.severett.thymeleafcomparison.common.service.BookService
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/books")
class BookController(
    private val authorService: AuthorService,
    private val bookService: BookService
) {
    @GetMapping
    fun getAll(model: Model): String {
        model["books"] = bookService.getAll()
        return "view_books"
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int, model: Model): String {
        model["book"] = bookService.get(id)
        return "view_book"
    }

    @GetMapping("/add")
    fun add(model: Model): String {
        model["authors"] = authorService.getAll()
        model["bookForm"] = BookForm()
        return "add_book"
    }

    @PostMapping("/save")
    fun save(@Valid bookForm: BookForm, bindingResult: BindingResult): String {
        return if (!bindingResult.hasErrors()) {
            bookService.save(bookForm)
            "redirect:/books"
        } else {
            "add_book"
        }
    }

    @PostMapping("/{id}/delete")
    fun delete(@PathVariable id: Int): String {
        bookService.delete(id)
        return "redirect:/books"
    }
}
