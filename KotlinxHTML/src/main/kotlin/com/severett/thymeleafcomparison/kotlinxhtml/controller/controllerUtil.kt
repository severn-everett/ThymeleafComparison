package com.severett.thymeleafcomparison.kotlinxhtml.controller

import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError

fun List<ObjectError>.toFieldErrorsMap() = mapNotNull { objectError ->
    (objectError as? FieldError)?.let {
        val defaultMessage = it.defaultMessage
        if (defaultMessage != null) it.field to defaultMessage else null
    }
}.toMap()
