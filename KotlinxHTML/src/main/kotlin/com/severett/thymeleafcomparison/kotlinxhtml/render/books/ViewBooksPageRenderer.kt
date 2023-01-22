package com.severett.thymeleafcomparison.kotlinxhtml.render.books

import com.severett.thymeleafcomparison.common.service.BookService
import com.severett.thymeleafcomparison.kotlinxhtml.render.common.footer
import com.severett.thymeleafcomparison.kotlinxhtml.render.common.header
import com.severett.thymeleafcomparison.kotlinxhtml.render.common.writePage
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
import kotlinx.html.link
import kotlinx.html.onSubmit
import kotlinx.html.script
import kotlinx.html.table
import kotlinx.html.tbody
import kotlinx.html.td
import kotlinx.html.th
import kotlinx.html.thead
import kotlinx.html.title
import kotlinx.html.tr
import org.springframework.stereotype.Service

@Service
class ViewBooksPageRenderer(private val bookService: BookService) {
    fun renderPage(): String {
        val books = bookService.getAll()
        return writePage {
            head {
                title("Bookstore - View Books")
                link(href = "/css/bootstrap.min.css", rel = "stylesheet")
                script(src = "/js/bootstrap.min.js") {}
                script(src = "/js/util.js") {}
            }
            body {
                header("Books")
                div {
                    id = "content"
                    h2 { +"Our Books" }
                    books.forEach { book ->
                        form(method = FormMethod.post, action = "/books/${book.id}/delete") {
                            id = "delete_${book.id}"
                            onSubmit = "return confirmDelete('book', \"${book.title}\")"
                        }
                    }
                    table(classes = "table table-striped") {
                        thead {
                            tr {
                                th { +"Title" }
                                th { +"Author" }
                                th {}
                            }
                        }
                        tbody {
                            books.forEach { book ->
                                tr {
                                    td { a(href = "/books/${book.id}") { +book.title } }
                                    td { +book.author.name }
                                    td {
                                        button(type = ButtonType.submit, classes = "btn btn-danger") {
                                            form = "delete_${book.id}"
                                            +"Delete"
                                        }
                                    }
                                }
                            }
                        }
                    }
                    a(href = "/books/add", classes = "btn btn-primary") { +"Add Book" }
                }
                footer()
            }
        }
    }
}
