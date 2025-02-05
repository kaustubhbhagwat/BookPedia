package org.kb.bookpedia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.kb.bookpedia.book.domain.Book
import org.kb.bookpedia.book.presentation.books_list.BookListScreen
import org.kb.bookpedia.book.presentation.books_list.BooksListState
import org.kb.bookpedia.book.presentation.books_list.components.BookSearchBar

@Preview
@Composable
fun BookSearchBarPreview(){
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)) {
            BookSearchBar(
                searchQuery = "",
                onSearchQueryChanged = {},
                onImeSearch = {},
                modifier = Modifier.fillMaxWidth()
            )
            BookListScreenPreview()
        }
    }
}

private val books =(1..10).map {
    Book(
        id = it.toString(),
        title = "Book $it",
        authors = listOf("Kaustubh Bhagwat"),
        description = "Description $it",
        languages = emptyList(),
        firstPublishYear = null,
        avgRating = 4.6,
        numPages = 100,
        imageUrl = "https://text.com",
        numEditions = 3,
        ratingCount = 5
    )
}

@org.jetbrains.compose.ui.tooling.preview.Preview
@Composable
fun BookListScreenPreview(){
    BookListScreen(
        state = BooksListState(
            searchResults = books
        ),
        onAction = {
        }
    )
}