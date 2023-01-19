package com.severett.thymeleafcomparison.common.model

data class Author(val id: Int, val name: String) {
    internal companion object {
        const val ID_FIELD = "id"
        const val NAME_FIELD = "name"
    }
}
