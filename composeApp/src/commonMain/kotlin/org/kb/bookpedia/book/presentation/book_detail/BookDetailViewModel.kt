package org.kb.bookpedia.book.presentation.book_detail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.kb.bookpedia.book.presentation.book_detail.components.BookDetailState

class BookDetailViewModel : ViewModel() {

    private val _state = MutableStateFlow(BookDetailState())

    val state = _state.asStateFlow()

}