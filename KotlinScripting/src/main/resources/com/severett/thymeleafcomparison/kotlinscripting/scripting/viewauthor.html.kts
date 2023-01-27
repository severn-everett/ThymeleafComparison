package com.severett.thymeleafcomparison.kotlinscripting.scripting

import com.severett.thymeleafcomparison.common.model.db.Author
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.h2
import kotlinx.html.head
import kotlinx.html.id
import kotlinx.html.link
import kotlinx.html.script
import kotlinx.html.title

val author = model["author"] as Author

writePage {
    head {
        title("Bookstore - View Author")
        link(href = "/css/bootstrap.min.css", rel = "stylesheet")
        script(src = "/js/bootstrap.min.js") {}
    }
    body {
        header("View Author")
        div {
            id = "content"
            h2 { +author.name }
        }
        footer()
    }
}
