package org.kb.bookpedia.book.presentation.books_list

import org.kb.bookpedia.book.domain.Book
import org.kb.bookpedia.core.presentation.UiText

data class BooksListState(
    val searchString: String = "Kotlin",
    val searchResults: List<Book> = emptyList(),
    val favBook: List<Book> = emptyList(),
    val isLoading : Boolean = false,
    val selectedTabIndex : Int = 0,
    val errorMessage: UiText
)
