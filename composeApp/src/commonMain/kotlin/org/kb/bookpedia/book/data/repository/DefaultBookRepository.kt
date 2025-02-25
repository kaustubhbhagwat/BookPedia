package org.kb.bookpedia.book.data.repository

import androidx.sqlite.SQLiteException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.kb.bookpedia.book.data.database.FavoriteBookDao
import org.kb.bookpedia.book.data.mappers.toBook
import org.kb.bookpedia.book.data.mappers.toBookEntity
import org.kb.bookpedia.book.data.network.RemoteBookDataSource
import org.kb.bookpedia.book.domain.Book
import org.kb.bookpedia.book.domain.BookRepository
import org.kb.bookpedia.core.domain.DataError
import org.kb.bookpedia.core.domain.EmptyResult
import org.kb.bookpedia.core.domain.Result
import org.kb.bookpedia.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
    private val favBookDao: FavoriteBookDao
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
        val localResult = favBookDao.getFavoriteBookById(bookId)

        if (localResult == null) {
            return remoteBookDataSource
                .getBookDetails(bookId)
                .map { it.description }
        } else {
            return Result.Success(localResult.description)
        }
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        return favBookDao.getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.map {
                    it.toBook()
                }
            }
    }

    override fun isBookFavorite(id: String): Flow<Boolean> {
        return favBookDao.getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.any {
                    it.id == id
                }
            }
    }

    override suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local> {
        return try {
            favBookDao.upsert(book.toBookEntity())
            Result.Success(Unit)
        } catch (e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFromFavorite(id: String) {
        favBookDao.deleteBookById(id)
    }
}