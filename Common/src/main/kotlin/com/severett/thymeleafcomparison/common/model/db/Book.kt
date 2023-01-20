package com.severett.thymeleafcomparison.common.model.db

import com.severett.thymeleafcomparison.common.model.db.Author

data class Book(val id: Int = 0, val title: String, val author: Author)
