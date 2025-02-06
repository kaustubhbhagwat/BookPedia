package org.kb.bookpedia.book.presentation.books_list

import org.kb.bookpedia.book.domain.Book

// Intent
sealed interface BookListAction {
    data class OnSearchQueryChanged(val query: String): BookListAction
    data class OnBookClick(val book: Book): BookListAction
    data class OnTabSelected(val index: Int): BookListAction
}
