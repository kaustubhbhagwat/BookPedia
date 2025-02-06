package org.kb.bookpedia.book.data.network

import io.ktor.client.HttpClient
import org.kb.bookpedia.book.domain.Book
import org.kb.bookpedia.core.domain.DataError

class KtorRemoteBookDataSource(
    val httpClient: HttpClient
) {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int
    ): Result<List<Book>>, DataError.Remote> {


    }
}