package com.severett.thymeleafcomparison.common.model.form

import jakarta.validation.constraints.NotBlank

data class AuthorForm(@field:NotBlank(message = "Name is mandatory") var name: String = "")
