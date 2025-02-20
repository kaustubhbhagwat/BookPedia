package org.kb.bookpedia.book.domain

import org.kb.bookpedia.core.domain.DataError
import org.kb.bookpedia.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
    suspend fun getBookDescription(bookId: String): Result<String?, DataError>
}