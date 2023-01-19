package com.severett.thymeleafcomparison.common.repo

import com.severett.thymeleafcomparison.common.model.Author
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
open class AuthorRepo(private val jdbcTemplate: NamedParameterJdbcTemplate) {
    open fun get(): List<Author> {
        TODO()
    }

    open fun get(id: Int): Author {
        TODO()
    }

    open fun save(author: Author) {

    }

    open fun delete(id: Int) {

    }
}
