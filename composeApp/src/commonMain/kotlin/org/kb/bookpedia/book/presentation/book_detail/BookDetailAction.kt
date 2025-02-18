package org.kb.bookpedia.book.presentation.book_detail

import org.kb.bookpedia.book.domain.Book

interface BookDetailAction {
    data object onBackClick: BookDetailAction
    data object onFavouriteClick: BookDetailAction
    data class OnSelectedBookChange(val book: Book): BookDetailAction
}