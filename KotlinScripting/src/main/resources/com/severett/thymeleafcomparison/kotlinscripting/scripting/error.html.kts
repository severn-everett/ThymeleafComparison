package com.severett.thymeleafcomparison.kotlinscripting.scripting

import kotlinx.html.body
import kotlinx.html.h2
import kotlinx.html.head
import kotlinx.html.link
import kotlinx.html.p
import kotlinx.html.script
import kotlinx.html.title

val status = model["status"] ?: "N/A"

writePage {
    head {
        title("Bookstore - Add Author")
        link(href = "/css/bootstrap.min.css", rel = "stylesheet")
        script(src = "/js/bootstrap.min.js") {}
    }
    body {
        header("Error")
        h2 { +"Oops!" }
        p { +"An error occurred and provided the status $status" }
        footer()
    }
}
