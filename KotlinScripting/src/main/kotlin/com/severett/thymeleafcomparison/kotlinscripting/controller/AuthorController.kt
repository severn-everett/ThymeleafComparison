package com.severett.thymeleafcomparison.kotlinscripting.controller

import com.severett.thymeleafcomparison.common.model.form.AuthorForm
import com.severett.thymeleafcomparison.common.service.AuthorService
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
@RequestMapping("/authors")
class AuthorController(private val authorService: AuthorService, private val scriptExecutor: ScriptExecutor) {
    @GetMapping(produces = [TEXT_HTML])
    @ResponseBody
    fun getAll(): String {
        return scriptExecutor.executeScript(
            "$SCRIPT_LOCATION/viewauthors.html.kts",
            mapOf("authors" to authorService.getAll())
        )
    }

    @GetMapping(value = ["/{id}"], produces = [TEXT_HTML])
    @ResponseBody
    fun get(@PathVariable id: Int): String {
        return scriptExecutor.executeScript(
            "$SCRIPT_LOCATION/viewauthor.html.kts",
            mapOf("author" to authorService.get(id))
        )
    }

    @GetMapping(value = ["/add"], produces = [TEXT_HTML])
    @ResponseBody
    fun add() = scriptExecutor.executeScript("$SCRIPT_LOCATION/addauthor.html.kts")

    @PostMapping(value = ["/save"], produces = [TEXT_HTML])
    @ResponseBody
    fun save(@Valid authorForm: AuthorForm, bindingResult: BindingResult, httpServletResponse: HttpServletResponse): String {
        return if (!bindingResult.hasErrors()) {
            authorService.save(authorForm)
            httpServletResponse.sendRedirect("/authors")
            ""
        } else {
            scriptExecutor.executeScript(
                "$SCRIPT_LOCATION/addauthor.html.kts",
                mapOf("errors" to bindingResult.allErrors.toFieldErrorsMap())
            )
        }
    }

    @PostMapping(value = ["/{id}/delete"])
    fun delete(@PathVariable id: Int, httpServletResponse: HttpServletResponse) {
        authorService.delete(id)
        httpServletResponse.sendRedirect("/authors")
    }
}
