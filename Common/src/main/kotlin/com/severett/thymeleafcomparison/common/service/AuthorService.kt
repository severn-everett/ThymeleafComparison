package com.severett.thymeleafcomparison.common.service

import com.severett.thymeleafcomparison.common.model.db.Author
import com.severett.thymeleafcomparison.common.model.form.AuthorForm
import com.severett.thymeleafcomparison.common.repo.AuthorRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class AuthorService(private val authorRepo: AuthorRepo) {
    open fun getAll() = authorRepo.getAll()

    open fun get(id: Int) = authorRepo.get(id)

    @Transactional
    open fun save(authorForm: AuthorForm) {
        authorRepo.save(Author(name = authorForm.name))
    }

    @Transactional
    open fun delete(id: Int) = authorRepo.delete(id)
}
