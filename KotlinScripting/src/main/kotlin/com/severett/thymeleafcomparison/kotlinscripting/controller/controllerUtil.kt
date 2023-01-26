package com.severett.thymeleafcomparison.kotlinscripting.controller

import org.springframework.http.MediaType
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError

const val TEXT_HTML = MediaType.TEXT_HTML_VALUE

fun List<ObjectError>.toFieldErrorsMap() = mapNotNull { objectError ->
    (objectError as? FieldError)?.let {
        val defaultMessage = it.defaultMessage
        if (defaultMessage != null) it.field to defaultMessage else null
    }
}.toMap()
