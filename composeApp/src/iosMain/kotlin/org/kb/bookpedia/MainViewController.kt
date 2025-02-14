package org.kb.bookpedia

import androidx.compose.ui.window.ComposeUIViewController
import org.kb.bookpedia.app.App
import org.kb.bookpedia.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() })
{ App() }