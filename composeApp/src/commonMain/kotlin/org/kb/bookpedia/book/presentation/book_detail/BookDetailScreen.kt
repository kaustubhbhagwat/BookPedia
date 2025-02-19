package org.kb.bookpedia.book.presentation.book_detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.kb.bookpedia.book.presentation.book_detail.components.BlurredImageBackground
import org.kb.bookpedia.book.presentation.book_detail.components.BookDetailState

@Composable
fun BookDetailScreenRoot(
    viewModel: BookDetailViewModel,
    onBackClick: () -> Unit
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    BookDetailScreen(state = state,
        onAction = { bookDetailAction ->

            when (bookDetailAction) {

                is BookDetailAction.onBackClick -> onBackClick()
                else -> Unit
            }
        })
}

@Composable
private fun BookDetailScreen(
    state: BookDetailState,
    onAction: (BookDetailAction) -> Unit
) {
    BlurredImageBackground(
        imageUrl = state.book?.imageUrl,
        isFavorite = state.isFavorite,
        onFavoriteClicked = {
            onAction(BookDetailAction.onFavouriteClick)
        },
        onBackClicked = {
            onAction(BookDetailAction.onBackClick)
        },
        modifier = Modifier.fillMaxSize(),
    ) {

    }
}