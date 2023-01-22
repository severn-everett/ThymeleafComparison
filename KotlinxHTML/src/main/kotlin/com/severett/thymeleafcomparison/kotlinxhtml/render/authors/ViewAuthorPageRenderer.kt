package com.severett.thymeleafcomparison.kotlinxhtml.render.authors

import com.severett.thymeleafcomparison.common.service.AuthorService
import com.severett.thymeleafcomparison.kotlinxhtml.render.common.footer
import com.severett.thymeleafcomparison.kotlinxhtml.render.common.header
import com.severett.thymeleafcomparison.kotlinxhtml.render.common.writePage
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.h2
import kotlinx.html.head
import kotlinx.html.id
import kotlinx.html.link
import kotlinx.html.script
import kotlinx.html.title
import org.springframework.stereotype.Service

@Service
class ViewAuthorPageRenderer(private val authorService: AuthorService) {
    fun renderPage(authorId: Int): String {
        val author = authorService.get(authorId)
        return writePage {
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
    }
}
