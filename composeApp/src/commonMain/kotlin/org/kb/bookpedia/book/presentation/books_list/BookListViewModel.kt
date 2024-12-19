package org.kb.bookpedia.book.presentation.books_list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class BookListViewModel : ViewModel() {

    private val _state = MutableStateFlow(BooksListState())
    val state = _state.asStateFlow()




}