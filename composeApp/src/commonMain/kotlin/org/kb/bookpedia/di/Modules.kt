package org.kb.bookpedia.di

import io.ktor.client.HttpClient
import org.kb.bookpedia.book.data.network.KtorRemoteBookDataSource
import org.kb.bookpedia.core.data.HttpClientFactory
import org.koin.dsl.module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    single {
        KtorRemoteBookDataSource(get())
    }
}