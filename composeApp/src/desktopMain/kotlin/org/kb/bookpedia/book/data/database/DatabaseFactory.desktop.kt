package org.kb.bookpedia.book.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File

actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<FavoriteBookDatabase> {
        val os = System.getProperty("os.name").lowercase()
        val userHome = System.getProperty("user.home")
        val appDir = when {
            os.contains("win") -> File(System.getenv("APPDATA"), ("Bookpedia"))
            os.contains("mac") -> File(userHome, "Librar/Application Support/Bookpedia")
            else -> File(userHome, ".local/share/Bookpedia")
        }
        if (!appDir.exists()) {
            appDir.mkdirs()
        }

        val dbFile = File(appDir, FavoriteBookDatabase.DB_NAME)
        return Room.databaseBuilder(dbFile.absolutePath)
    }
}