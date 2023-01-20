package com.severett.thymeleafcomparison.common.repo

import com.severett.thymeleafcomparison.common.model.db.Book
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
open class BookRepo(private val jdbcTemplate: NamedParameterJdbcTemplate) {
    open fun get(): List<Book> {
        TODO()
    }

    open fun get(id: Int): Book {
        TODO()
    }

    open fun save(book: Book) {
    }

    open fun delete(id: Int) {

    }
}
