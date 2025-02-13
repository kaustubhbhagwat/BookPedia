package org.kb.bookpedia

import androidx.compose.runtime.*
import io.ktor.client.engine.HttpClientEngine
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.kb.bookpedia.book.data.network.KtorRemoteBookDataSource
import org.kb.bookpedia.book.data.repository.DefaultBookRepository
import org.kb.bookpedia.book.presentation.books_list.BookListScreenRoot
import org.kb.bookpedia.book.presentation.books_list.BookListViewModel
import org.kb.bookpedia.core.data.HttpClientFactory
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    val viewModel = koinViewModel<BookListViewModel>()
    BookListScreenRoot(
        viewModel = viewModel,
        onBookClick = {
        }
    )
}