package org.kb.bookpedia

import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.kb.bookpedia.book.data.network.KtorRemoteBookDataSource
import org.kb.bookpedia.book.data.repository.DefaultBookRepository
import org.kb.bookpedia.book.presentation.books_list.BookListScreenRoot
import org.kb.bookpedia.book.presentation.books_list.BookListViewModel

@Composable
@Preview
fun App() {
    BookListScreenRoot(
        viewModel = remember { BookListViewModel(
            bookRepository = DefaultBookRepository(
                remoteBookDataSource = KtorRemoteBookDataSource(

                )
            )
        ) },
        onBookClick = {
        }
    )
}