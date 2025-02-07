package org.kb.bookpedia.book.data.repository

import bookpedia.composeapp.generated.resources.Res
import org.kb.bookpedia.book.data.network.RemoteBookDataSource
import org.kb.bookpedia.book.domain.Book
import org.kb.bookpedia.core.domain.DataError
import org.kb.bookpedia.core.domain.Result

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource
) {
    suspend fun searchBooks(query : String): Result<List<Book>,DataError.Remote>{
        return remoteBookDataSource.searchBooks(query)
    }
}