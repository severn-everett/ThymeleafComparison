package com.severett.thymeleafcomparison.kotlinscripting.scripting

import com.severett.thymeleafcomparison.common.model.db.Book
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.h2
import kotlinx.html.h4
import kotlinx.html.head
import kotlinx.html.id
import kotlinx.html.link
import kotlinx.html.script
import kotlinx.html.title

val book = model[BOOK] as Book

writePage {
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
}
