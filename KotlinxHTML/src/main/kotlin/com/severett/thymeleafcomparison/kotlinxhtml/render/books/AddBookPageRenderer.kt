package com.severett.thymeleafcomparison.kotlinxhtml.render.books

import com.severett.thymeleafcomparison.common.service.AuthorService
import com.severett.thymeleafcomparison.kotlinxhtml.render.footer
import com.severett.thymeleafcomparison.kotlinxhtml.render.header
import kotlinx.html.ButtonType
import kotlinx.html.FormMethod
import kotlinx.html.InputType
import kotlinx.html.body
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.dom.createHTMLDocument
import kotlinx.html.dom.serialize
import kotlinx.html.form
import kotlinx.html.h2
import kotlinx.html.head
import kotlinx.html.html
import kotlinx.html.id
import kotlinx.html.input
import kotlinx.html.label
import kotlinx.html.link
import kotlinx.html.option
import kotlinx.html.script
import kotlinx.html.select
import kotlinx.html.small
import kotlinx.html.strong
import kotlinx.html.title
import org.springframework.stereotype.Service

@Service
class AddBookPageRenderer(private val authorService: AuthorService) {
    fun renderPage(errors: Map<String, String>? = null): String {
        val authors = authorService.getAll()
        return createHTMLDocument().html {
            head {
                title("Bookstore - View Book")
                link(href = "/css/bootstrap.min.css", rel = "stylesheet")
                script(src = "/js/bootstrap.min.js") {}
            }
            body {
                header("Add Book")
                h2 { +"Add A Book" }
                form(action = "/books/save", method = FormMethod.post) {
                    div(classes = "form-group") {
                        label { +"Book Title"; htmlFor = "inputTitle" }
                        input(type = InputType.text, classes = "form-control") {
                            id = "inputTitle"
                            name = "title"
                            placeholder = "Enter title"
                        }
                        small(classes = "form-text text-muted") {
                            id = "inputTitleHelp"
                            +"Must not be left blank"
                        }
                        errors?.get("title")?.let {  titleError -> strong(classes = "text-danger") { +titleError } }
                        label { +"Author"; htmlFor = "inputAuthor" }
                        select {
                            id = "inputAuthor"
                            name = "authorId"
                            authors.forEach { author ->
                                option { value = author.id.toString(); +author.name }
                            }
                        }
                    }
                    button(type = ButtonType.submit, classes = "btn btn-primary") { +"Submit" }
                }
                footer()
            }
        }.serialize()
    }
}
