package com.severett.thymeleafcomparison.kotlinxhtml.render.home

import com.severett.thymeleafcomparison.kotlinxhtml.render.footer
import com.severett.thymeleafcomparison.kotlinxhtml.render.header
import kotlinx.html.a
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.dom.createHTMLDocument
import kotlinx.html.dom.serialize
import kotlinx.html.h2
import kotlinx.html.h3
import kotlinx.html.head
import kotlinx.html.html
import kotlinx.html.li
import kotlinx.html.link
import kotlinx.html.main
import kotlinx.html.script
import kotlinx.html.title
import kotlinx.html.ul
import org.springframework.stereotype.Service

@Service
class HomepageRenderer {
    fun render(): String {
        return createHTMLDocument().html {
            head {
                title("Bookstore - Home")
                link(href = "/css/bootstrap.min.css", rel = "stylesheet")
                script(src = "/js/bootstrap.min.js") {}
            }
            body {
                main(classes = "flex-shrink-0") {
                    header("Home")
                    div {
                        h2 { +"Welcome to the Test Bookstore" }
                        h3 { +"Our Pages" }
                        ul {
                            li { a(href = "/authors") { +"Authors" } }
                            li { a(href = "/books") { +"Books" } }
                        }
                    }
                }
                footer()
            }
        }.serialize()
    }
}
