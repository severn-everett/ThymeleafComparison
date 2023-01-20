package com.severett.thymeleafcomparison.common.model.db

data class Book(val id: Int = 0, val title: String, val author: Author) {
    internal companion object {
        const val ID_FIELD = "id"
        const val TITLE_FIELD = "title"
        const val AUTHOR_ID_FIELD = "author_id"
        const val AUTHOR_NAME_FIELD = "author_name"
    }
}
