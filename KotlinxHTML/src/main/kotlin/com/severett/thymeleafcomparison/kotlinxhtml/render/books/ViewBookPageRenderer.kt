package com.severett.thymeleafcomparison.kotlinxhtml.render.books

import com.severett.thymeleafcomparison.common.service.BookService
import com.severett.thymeleafcomparison.kotlinxhtml.render.footer
import com.severett.thymeleafcomparison.kotlinxhtml.render.header
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.dom.createHTMLDocument
import kotlinx.html.dom.serialize
import kotlinx.html.h2
import kotlinx.html.h4
import kotlinx.html.head
import kotlinx.html.html
import kotlinx.html.id
import kotlinx.html.link
import kotlinx.html.script
import kotlinx.html.title
import org.springframework.stereotype.Service

@Service
class ViewBookPageRenderer(private val bookService: BookService) {
    fun renderPage(bookId: Int): String {
        val book = bookService.get(bookId)
        return createHTMLDocument().html {
            head {
                title("Bookstore - View Book")
                link(href = "/css/bootstrap.min.css", rel = "stylesheet")
                script(src = "/js/bootstrap.min.js") {}
            }
            body {
                header("View Book")
                div {
                    id = "content"
                    h2 { +book.title }
                    h4 { +"By: ${book.author.name}" }
                }
                footer()
            }
        }.serialize()
    }
}
