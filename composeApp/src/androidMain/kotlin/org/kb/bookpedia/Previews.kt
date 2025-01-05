package org.kb.bookpedia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
                searchQuery = "Kotlin",
                onSearchQueryChanged = {},
                onImeSearch = {},
                modifier = Modifier.fillMaxWidth()
            )

        }

    }
}