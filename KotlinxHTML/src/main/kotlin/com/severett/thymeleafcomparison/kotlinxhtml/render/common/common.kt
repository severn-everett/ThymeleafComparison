package com.severett.thymeleafcomparison.kotlinxhtml.render.common

import kotlinx.html.ButtonType
import kotlinx.html.FlowContent
import kotlinx.html.HTML
import kotlinx.html.a
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.dom.createHTMLDocument
import kotlinx.html.dom.serialize
import kotlinx.html.footer
import kotlinx.html.html
import kotlinx.html.id
import kotlinx.html.lang
import kotlinx.html.li
import kotlinx.html.nav
import kotlinx.html.p
import kotlinx.html.span
import kotlinx.html.ul
import kotlinx.html.visit

inline fun writePage(crossinline block : HTML.() -> Unit): String {
    return createHTMLDocument().html {
        lang = "en"
        visit(block)
    }.serialize()
}

fun FlowContent.header(pageName: String) {
    nav(classes = "navbar navbar-expand-lg navbar-dark bg-dark") {
        div(classes = "container-fluid") {
            a(href = "/", classes="navbar-brand") { +"Test Bookstore" }
            button(classes = "navbar-toggler", type = ButtonType.button) {
                attributes["data-bs-toggle"] = "collapse"
                attributes["data-bs-target"] = "#navbarHeader"
                span(classes="navbar-toggler-icon")
            }
            div(classes="collapse navbar-collapse") {
                id = "navbarHeader"

                ul(classes = "navbar-nav me-auto mb-2 mb-lg-0") {
                    li(classes = "nav-item") {
                        a(classes = "nav-link${if (pageName == "Home") " active" else ""}", href = "/") { +"Home" }
                    }
                    li(classes = "nav-item") {
                        a(classes = "nav-link${if (pageName == "Authors") " active" else ""}", href = "/authors") { +"Authors" }
                    }
                    li(classes = "nav-item") {
                        a(classes = "nav-link${if (pageName == "Books") " active" else ""}", href = "/books") { +"Books" }
                    }
                }
            }
        }
    }
}

fun FlowContent.footer() {
    footer(classes = "footer mt-auto py-3 bg-light fixed-bottom") {
        p(classes = "text-center") { +"Copyright 20XX Bookstore Productions - All Rights Reserved" }
    }
}
