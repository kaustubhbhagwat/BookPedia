package org.kb.bookpedia.book.presentation.books_list

import org.kb.bookpedia.book.domain.Book
import org.kb.bookpedia.core.presentation.UiText

data class BooksListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = books,
    val favBook: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)

val books = (1..10).map {
    Book(
        id = it.toString(),
        title = "Book $it",
        authors = listOf("Kaustubh Bhagwat"),
        description = "Description $it",
        languages = emptyList(),
        firstPublishYear = null,
        avgRating = 4.6,
        numPages = 100,
        imageUrl = "https://text.com",
        numEditions = 3,
        ratingCount = 5
    )
}