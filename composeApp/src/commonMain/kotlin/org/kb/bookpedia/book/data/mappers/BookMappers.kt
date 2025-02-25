package org.kb.bookpedia.book.data.mappers

import org.kb.bookpedia.book.data.database.BookEntity
import org.kb.bookpedia.book.data.dto.SearchBookDto
import org.kb.bookpedia.book.domain.Book


fun SearchBookDto.toBook(): Book {
    return Book(
        id = id.substringAfterLast("/"),
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

fun Book.toBookEntity(): BookEntity {
    return BookEntity(
        id = id,
        languages = languages,
        authors = authors,
        description = description,
        imageUrl = imageUrl,
        ratingsCount = ratingCount,
        ratingsAverage = avgRating,
        numEditions = numEditions,
        numOfPagesMedian = numPages,
        title = title,
        firstPublishYear = firstPublishYear
    )
}