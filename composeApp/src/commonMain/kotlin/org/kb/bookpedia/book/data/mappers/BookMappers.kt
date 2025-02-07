package org.kb.bookpedia.book.data.mappers

import org.kb.bookpedia.book.data.dto.SearchBookDto
import org.kb.bookpedia.book.domain.Book


fun SearchBookDto.toBook(): Book {
    return Book(
        id = id,
        title = title,
        imageUrl = if (coverKey != null) {
            "https://covers.openlibrary.org/b/olid/${coverKey}-L.jpg"
        } else {
            "https://covers.openlibrary.org/b/olid/${coverAlternativeKey}-L.jpg"
        },
        authors = authorNames ?: emptyList(),
        description = null,
        languages = languages ?: emptyList(),
        firstPublishYear = firstPublishYear?.toString(),
        avgRating = ratingsAverage,
        ratingCount = ratingsCount,
        numPages = numPagesMedian,
        numEditions = numEditions ?: 0
    )

}