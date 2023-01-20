package com.severett.thymeleafcomparison.thymeleaf.controller

import com.severett.thymeleafcomparison.common.service.AuthorService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/authors")
class AuthorController(private val authorService: AuthorService) {
    @GetMapping
    fun getAll(model: Model): String {
        model["authors"] = authorService.getAll()
        return "view_authors"
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int, model: Model): String {
        model["author"] = authorService.get(id)
        return "view_author"
    }

    @PostMapping("/{id}/delete")
    fun delete(@PathVariable id: Int): String {
        authorService.delete(id)
        return "redirect:/authors"
    }
}
