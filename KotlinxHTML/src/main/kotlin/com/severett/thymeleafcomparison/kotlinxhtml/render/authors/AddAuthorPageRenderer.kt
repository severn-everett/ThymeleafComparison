package com.severett.thymeleafcomparison.kotlinxhtml.render.authors

import com.severett.thymeleafcomparison.kotlinxhtml.render.common.footer
import com.severett.thymeleafcomparison.kotlinxhtml.render.common.header
import com.severett.thymeleafcomparison.kotlinxhtml.render.common.writePage
import kotlinx.html.ButtonType
import kotlinx.html.FormMethod
import kotlinx.html.InputType
import kotlinx.html.body
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.form
import kotlinx.html.h2
import kotlinx.html.head
import kotlinx.html.id
import kotlinx.html.input
import kotlinx.html.label
import kotlinx.html.link
import kotlinx.html.script
import kotlinx.html.small
import kotlinx.html.strong
import kotlinx.html.title
import org.springframework.stereotype.Service

@Service
class AddAuthorPageRenderer {
    fun renderPage(errors: Map<String, String>? = null): String {
        return writePage {
            head {
                title("Bookstore - Add Author")
                link(href = "/css/bootstrap.min.css", rel = "stylesheet")
                script(src = "/js/bootstrap.min.js") {}
            }
            body {
                header("Add Author")
                h2 { +"Add An Author" }
                form(action = "/authors/save", method = FormMethod.post) {
                    div(classes = "form-group") {
                        label { +"Author Name"; htmlFor = "inputName" }
                        input(type = InputType.text, classes = "form-control") {
                            id = "inputName"
                            name = "name"
                            placeholder = "Enter name"
                        }
                        small(classes="form-text text-muted") {
                            id = "inputNameHelp"
                            +"Must not be left blank"
                        }
                        errors?.get("name")?.let {  nameError -> strong(classes = "text-danger") { +nameError } }
                    }
                    button(type = ButtonType.submit, classes = "btn btn-primary") { +"Submit" }
                }
                footer()
            }
        }
    }
}