package com.severett.thymeleafcomparison.common.repo

import com.severett.thymeleafcomparison.common.model.db.Author
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
open class AuthorRepo(private val jdbcTemplate: NamedParameterJdbcTemplate) {
    private val authorMapper = RowMapper { rs, _ ->
        Author(id = rs.getInt(Author.ID_FIELD), name = rs.getString(Author.NAME_FIELD))
    }

    open fun getAll(): List<Author> = jdbcTemplate.query("SELECT * FROM author", authorMapper)

    open fun get(id: Int): Author {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM author WHERE author.id = :id",
            mapOf(Author.ID_FIELD to id),
            authorMapper
        )!!
    }

    open fun save(author: Author) {
        jdbcTemplate.update("INSERT INTO author (name) VALUES :name", mapOf(Author.NAME_FIELD to author.name))
    }

    open fun delete(id: Int) {
        jdbcTemplate.update("DELETE FROM author WHERE author.id = :id", mapOf(Author.ID_FIELD to id))
    }
}
