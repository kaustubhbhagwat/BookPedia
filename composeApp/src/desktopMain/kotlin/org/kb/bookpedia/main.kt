package org.kb.bookpedia

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.kb.bookpedia.app.App
import org.kb.bookpedia.di.initKoin

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