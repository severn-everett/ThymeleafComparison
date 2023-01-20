package com.severett.thymeleafcomparison.common.model.db

data class Author(val id: Int = 0, val name: String) {
    internal companion object {
        const val ID_FIELD = "id"
        const val NAME_FIELD = "name"
    }
}
