package com.severett.thymeleafcomparison.common.service

import com.severett.thymeleafcomparison.common.model.Author
import com.severett.thymeleafcomparison.common.repo.AuthorRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class AuthorService(private val authorRepo: AuthorRepo) {
    open fun getAll() = authorRepo.getAll()

    open fun get(id: Int) = authorRepo.get(id)

    @Transactional
    open fun save(author: Author) = authorRepo.save(author)

    @Transactional
    open fun delete(id: Int) = authorRepo.delete(id)
}
