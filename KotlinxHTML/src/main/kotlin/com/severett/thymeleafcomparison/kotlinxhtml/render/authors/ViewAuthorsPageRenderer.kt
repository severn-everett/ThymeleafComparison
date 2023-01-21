package com.severett.thymeleafcomparison.kotlinxhtml.render.authors

import com.severett.thymeleafcomparison.common.service.AuthorService
import com.severett.thymeleafcomparison.kotlinxhtml.render.footer
import com.severett.thymeleafcomparison.kotlinxhtml.render.header
import kotlinx.html.ButtonType
import kotlinx.html.FormMethod
import kotlinx.html.a
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
import kotlinx.html.li
import kotlinx.html.link
import kotlinx.html.onSubmit
import kotlinx.html.script
import kotlinx.html.title
import kotlinx.html.ul
import org.springframework.stereotype.Service

@Service
class ViewAuthorsPageRenderer(private val authorService: AuthorService) {
    fun renderPage(): String {
        val authors = authorService.getAll()
        return createHTMLDocument().html {
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
                                    onSubmit = "return confirmDelete('author', \"${author.name}\")"
                                    a(href = "/authors/${author.id}") { +author.name }
                                    button(type = ButtonType.submit, classes = "btn btn-danger") { +"Delete" }
                                }
                            }
                        }
                    }
                    a(classes = "btn btn-primary", href = "/authors/add") { +"Add Author" }
                }
                footer()
            }
        }.serialize()
    }
}
