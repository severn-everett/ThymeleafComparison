package com.severett.thymeleafcomparison.kotlinscripting.scripting

import com.severett.thymeleafcomparison.common.model.db.Author
import kotlinx.html.ButtonType
import kotlinx.html.FormMethod
import kotlinx.html.a
import kotlinx.html.body
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.form
import kotlinx.html.h2
import kotlinx.html.head
import kotlinx.html.id
import kotlinx.html.li
import kotlinx.html.link
import kotlinx.html.onSubmit
import kotlinx.html.script
import kotlinx.html.style
import kotlinx.html.title
import kotlinx.html.ul

val authors = arguments["authors"] as List<Author>

writePage {
    head {
        title("Bookstore - View Authors")
        link(href = "/css/bootstrap.min.css", rel = "stylesheet")
        script(src = "/js/bootstrap.min.js") {}
        script(src = "/js/util.js") {}
    }
    body {
        header("Authors")
        div {
            id = "content"
            h2 { +"Our Books' Authors" }
            ul {
                authors.forEach { author ->
                    li {
                        form(method = FormMethod.post, action = "/authors/${author.id}/delete") {
                            style = "margin-block-end: 1em;"
                            onSubmit = "return confirmDelete('author', \"${author.name}\")"
                            a(href = "/authors/${author.id}") {
                                +author.name
                                style = "margin-right: 0.25em;"
                            }
                            button(type = ButtonType.submit, classes = "btn btn-danger") { +"Delete" }
                        }
                    }
                }
            }
            a(classes = "btn btn-primary", href = "/authors/add") { +"Add Author" }
        }
        footer()
    }
}
