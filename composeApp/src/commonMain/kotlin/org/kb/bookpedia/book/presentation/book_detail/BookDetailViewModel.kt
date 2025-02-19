package org.kb.bookpedia.book.presentation.book_detail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.kb.bookpedia.book.presentation.book_detail.components.BookDetailState

class BookDetailViewModel : ViewModel() {

    private val _state = MutableStateFlow(BookDetailState())

    val state = _state.asStateFlow()

    fun onAction(action: BookDetailAction) {
        when (action) {
            is BookDetailAction.OnSelectedBookChange -> {
                _state.update { it.copy(
                        book = action.book
                    )
                }
            }
//            is BookDetailAction.onFavouriteClick -> {
//                _state.update {
//                    it.copy(
//                        isFavorite = it.isFavorite
//                    )
//                }
//            }

            else -> {

            }
        }
    }

}