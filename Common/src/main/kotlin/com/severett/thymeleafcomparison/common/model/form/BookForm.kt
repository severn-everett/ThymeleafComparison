package com.severett.thymeleafcomparison.common.model.form

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class BookForm(
    @field:NotBlank(message = "Title is mandatory")
    var title: String = "",
    @field:Min(1, message = "Author is mandatory")
    var authorId: Int = 0
)
