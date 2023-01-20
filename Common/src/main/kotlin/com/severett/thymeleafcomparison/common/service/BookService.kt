package com.severett.thymeleafcomparison.common.service

import com.severett.thymeleafcomparison.common.model.db.Book
import com.severett.thymeleafcomparison.common.model.form.BookForm
import com.severett.thymeleafcomparison.common.repo.AuthorRepo
import com.severett.thymeleafcomparison.common.repo.BookRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class BookService(
    private val authorRepo: AuthorRepo,
    private val bookRepo: BookRepo
) {
    open fun getAll() = bookRepo.getAll()

    open fun get(id: Int) = bookRepo.get(id)

    @Transactional
    open fun save(bookForm: BookForm) {
        val author = authorRepo.get(bookForm.authorId)
        bookRepo.save(Book(title = bookForm.title, author = author))
    }

    @Transactional
    open fun delete(id: Int) = bookRepo.delete(id)
}
