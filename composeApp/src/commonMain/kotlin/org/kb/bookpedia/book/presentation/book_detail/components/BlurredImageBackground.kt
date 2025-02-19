package org.kb.bookpedia.book.presentation.book_detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import bookpedia.composeapp.generated.resources.Res
import bookpedia.composeapp.generated.resources.book_cover
import coil3.compose.rememberAsyncImagePainter
import org.jetbrains.compose.resources.stringResource
import org.kb.bookpedia.core.presentation.DarkBlue
import org.kb.bookpedia.core.presentation.DesertWhite

@Composable
fun BlurredImageBackground(
    imageUrl: String?,
    isFavorite: Boolean,
    onFavoriteClicked: () -> Unit,
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier,
    content: () -> Unit
) {
    var imageLoadResult by remember {
        mutableStateOf<Result<Painter>?>(null)
    }

    val painter = rememberAsyncImagePainter(
        model = imageUrl,
        onSuccess = {
            val size = it.painter.intrinsicSize
            imageLoadResult = if (size.width > 1 && size.height > 1) {
                Result.success(it.painter)
            } else {
                Result.failure(Exception("Invalid Image dimensions"))
            }
        }
    )

    Box {
        Column(
            modifier = modifier
                .fillMaxSize()
        ){
            Box(modifier = modifier
                .weight(0.3f)
                .fillMaxWidth()
                .background(DarkBlue)
            ) {
                imageLoadResult?.getOrNull()?.let { painter ->
                    Image(
                        painter = painter,
                        contentDescription = stringResource(Res.string.book_cover),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            . fillMaxSize()
                            .blur(20.dp)
                    )
                }
            }

            Box(modifier = Modifier
                .weight(0.7f)
                .fillMaxWidth()
                .background(DesertWhite)) {
            }
        }
    }
}