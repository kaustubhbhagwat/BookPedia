package org.kb.bookpedia

import androidx.compose.runtime.*
import io.ktor.client.engine.HttpClientEngine
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.kb.bookpedia.book.data.network.KtorRemoteBookDataSource
import org.kb.bookpedia.book.data.repository.DefaultBookRepository
import org.kb.bookpedia.book.presentation.books_list.BookListScreenRoot
import org.kb.bookpedia.book.presentation.books_list.BookListViewModel
import org.kb.bookpedia.core.data.HttpClientFactory

@Composable
@Preview
fun App(engine: HttpClientEngine) {
    BookListScreenRoot(
        viewModel = remember {
            BookListViewModel(
                bookRepository = DefaultBookRepository(
                    remoteBookDataSource = KtorRemoteBookDataSource(
                        httpClient = HttpClientFactory.create(
                            engine = engine
                        )
                    )
                )
            )
        },
        onBookClick = {
        }
    )
}