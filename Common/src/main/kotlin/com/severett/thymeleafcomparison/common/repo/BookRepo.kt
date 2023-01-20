package com.severett.thymeleafcomparison.common.repo

import com.severett.thymeleafcomparison.common.model.db.Author
import com.severett.thymeleafcomparison.common.model.db.Book
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

private const val SELECT_ALL_QUERY = """
    SELECT b.id, b.title, a.id AS author_id, a.name AS author_name 
        FROM book AS b
        JOIN author AS a ON b.author_id = a.id
"""

private const val SELECT_ONE_QUERY = "$SELECT_ALL_QUERY WHERE b.id = :id"

@Repository
open class BookRepo(private val jdbcTemplate: NamedParameterJdbcTemplate) {
    private val bookMapper = RowMapper { rs, _ ->
        Book(
            id = rs.getInt(Book.ID_FIELD),
            title = rs.getString(Book.TITLE_FIELD),
            author = Author(
                id = rs.getInt(Book.AUTHOR_ID_FIELD),
                name = rs.getString(Book.AUTHOR_NAME_FIELD)
            )
        )
    }

    open fun getAll(): List<Book> = jdbcTemplate.query(SELECT_ALL_QUERY, bookMapper)

    open fun get(id: Int): Book {
        return jdbcTemplate.queryForObject(SELECT_ONE_QUERY, mapOf(Book.ID_FIELD to id), bookMapper)!!
    }

    open fun save(book: Book) {
        jdbcTemplate.update(
            "INSERT INTO book(title, author_id) VALUES (:title, :author_id)",
            mapOf(
                Book.TITLE_FIELD to book.title,
                Book.AUTHOR_ID_FIELD to book.author.id
            )
        )
    }

    open fun delete(id: Int) {
        jdbcTemplate.update("DELETE FROM book WHERE book.id = :id", mapOf(Book.ID_FIELD to id))
    }
}
