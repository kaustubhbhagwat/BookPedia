package org.kb.bookpedia.book.presentation.books_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.kb.bookpedia.book.domain.Book
import org.kb.bookpedia.book.domain.BookRepository
import org.kb.bookpedia.core.domain.onError
import org.kb.bookpedia.core.domain.onSuccess
import org.kb.bookpedia.core.presentation.UiText
import org.kb.bookpedia.core.presentation.toUiText


// Presentation -> Domain <- Data
class BookListViewModel(
    private val bookRepository: BookRepository
) : ViewModel() {

    private val _state = MutableStateFlow(BooksListState())
    val state = _state
        .onStart {
            if(cachedBooks.isEmpty()){
                observeSearchQuery()
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(500L),
            _state.value
        )

    private val cachedBooks = emptyList<Book>()
    private var searchJob : Job? = null

    fun onAction(action: BookListAction) {
        when (action) {
            is BookListAction.OnBookClick -> {

            }

            is BookListAction.OnSearchQueryChanged -> {
                _state.update {
                    it.copy(searchQuery = action.query)
                }
            }

            is BookListAction.OnTabSelected -> {
                _state.update {
                    it.copy(selectedTabIndex = action.index)
                }
            }
        }
    }

    @OptIn(FlowPreview::class)
    private fun observeSearchQuery() {
        state
            .map { it.searchQuery }
            .distinctUntilChanged()
            .debounce(500L)
            .onEach { query ->
                when {
                    query.isBlank() -> {
                        _state.update {
                            it.copy(
                                errorMessage = null,
                                searchResults = cachedBooks
                            )
                        }
                    }

                    query.length >= 2 -> {
                        searchJob?.cancel()
                        searchJob = searchBooks(query)

                    }
                }
            }.launchIn(viewModelScope)
    }

    private fun searchBooks(query: String) =
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }

            bookRepository
                .searchBooks(query)
                .onSuccess { searchResults ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = null,
                            searchResults = searchResults
                        )
                    }

                }
                .onError { error ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            searchResults = emptyList(),
                            errorMessage = error.toUiText()
                        )
                    }
                }

        }
}