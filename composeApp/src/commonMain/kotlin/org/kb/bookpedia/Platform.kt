package org.kb.bookpedia

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform