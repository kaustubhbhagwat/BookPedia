package org.kb.bookpedia

import android.app.Application
import org.kb.bookpedia.di.initKoin
import org.koin.android.ext.koin.androidContext

class BookApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BookApplication)
        }

    }

}