package org.kb.bookpedia.book.presentation.books_list.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.kb.bookpedia.book.domain.Book
import org.kb.bookpedia.core.presentation.LightBlue

@Composable
fun BookListItem(
    book: Book,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){

    Surface(
        shape = RoundedCornerShape(32.dp),
        modifier = modifier,
        onClick = onClick,
        color = LightBlue.copy(alpha = 0.2f)
    ) {

    }

}