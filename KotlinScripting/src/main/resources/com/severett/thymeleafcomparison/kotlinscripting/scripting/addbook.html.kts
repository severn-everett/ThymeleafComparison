package com.severett.thymeleafcomparison.kotlinscripting.scripting

import com.severett.thymeleafcomparison.common.model.db.Author
import kotlinx.html.ButtonType
import kotlinx.html.FormMethod
import kotlinx.html.InputType
import kotlinx.html.body
import kotlinx.html.br
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.form
import kotlinx.html.h2
import kotlinx.html.head
import kotlinx.html.id
import kotlinx.html.input
import kotlinx.html.label
import kotlinx.html.link
import kotlinx.html.option
import kotlinx.html.script
import kotlinx.html.select
import kotlinx.html.small
import kotlinx.html.strong
import kotlinx.html.style
import kotlinx.html.title

val authors = model["authors"] as List<Author>
val errors = model["errors"] as? Map<String, String>

writePage {
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
                br
                label { +"Author"; htmlFor = "inputAuthor" }
                select {
                    id = "inputAuthor"
                    name = "authorId"
                    style = "margin-left: 0.25em;"
                    authors.forEach { author ->
                        option { value = author.id.toString(); +author.name }
                    }
                }
            }
            button(type = ButtonType.submit, classes = "btn btn-primary") { +"Submit" }
        }
        footer()
    }
}
