package org.kb.bookpedia

import androidx.compose.ui.window.ComposeUIViewController
import io.ktor.client.engine.darwin.Darwin
import org.kb.bookpedia.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() })
{ App() }