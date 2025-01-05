package org.kb.bookpedia.book.presentation.books_list.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import bookpedia.composeapp.generated.resources.Res
import bookpedia.composeapp.generated.resources.search_hint
import org.jetbrains.compose.resources.stringResource
import org.kb.bookpedia.core.presentation.DarkBlue
import org.kb.bookpedia.core.presentation.SandYellow

@Composable
fun BookSearchBar(
    searchQuery : String,
    onSearchQueryChanged : (String) -> Unit,
    onImeSearch : () -> Unit,
    modifier: Modifier = Modifier
){

    OutlinedTextField(
        value = searchQuery,
        onValueChange = onSearchQueryChanged,
        shape = RoundedCornerShape(100),
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = DarkBlue,
            focusedLabelColor = SandYellow
        ),
        placeholder = {
            Text(
                text = stringResource(Res.string.search_hint)
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.66f))
        }
    )

}