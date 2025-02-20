package org.kb.bookpedia.book.data.repository

import org.kb.bookpedia.book.data.mappers.toBook
import org.kb.bookpedia.book.data.network.RemoteBookDataSource
import org.kb.bookpedia.book.domain.Book
import org.kb.bookpedia.book.domain.BookRepository
import org.kb.bookpedia.core.domain.DataError
import org.kb.bookpedia.core.domain.Result
import org.kb.bookpedia.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource
) : BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map {
                    it.toBook()
                }
            }
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        return remoteBookDataSource
            .getBookDetails(bookId)
            .map { it.description }
    }
}