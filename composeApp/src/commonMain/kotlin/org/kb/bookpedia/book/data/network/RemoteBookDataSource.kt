package org.kb.bookpedia.book.data.network

import org.kb.bookpedia.book.data.dto.BookWorkDto
import org.kb.bookpedia.book.data.dto.SearchResponseDto
import org.kb.bookpedia.core.domain.DataError
import org.kb.bookpedia.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto,DataError.Remote>

    suspend fun getBookDetails(bookWorkId: String) : Result<BookWorkDto, DataError.Remote>
}