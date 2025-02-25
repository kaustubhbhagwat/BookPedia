package org.kb.bookpedia.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import org.kb.bookpedia.book.data.database.DatabaseFactory
import org.kb.bookpedia.book.data.database.FavoriteBookDatabase
import org.kb.bookpedia.book.data.network.KtorRemoteBookDataSource
import org.kb.bookpedia.book.data.network.RemoteBookDataSource
import org.kb.bookpedia.book.data.repository.DefaultBookRepository
import org.kb.bookpedia.book.domain.BookRepository
import org.kb.bookpedia.book.presentation.books_list.BookListViewModel
import org.kb.bookpedia.book.presentation.SelectedBookViewModel
import org.kb.bookpedia.book.presentation.book_detail.BookDetailViewModel
import org.kb.bookpedia.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()
    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }

    single { get<FavoriteBookDatabase>().favoriteBookDao }
    viewModelOf(::BookListViewModel)
    viewModelOf(::SelectedBookViewModel)
    viewModelOf(::BookDetailViewModel)
}