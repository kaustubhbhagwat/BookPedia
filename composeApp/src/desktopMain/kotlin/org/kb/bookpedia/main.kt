package org.kb.bookpedia

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.ktor.client.engine.okhttp.OkHttp
import org.kb.bookpedia.di.initKoin
import org.koin.core.context.startKoin

fun main() = {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "BookPedia",
        ) {
            App()
        }
    }
}