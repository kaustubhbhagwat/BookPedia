package org.kb.bookpedia.book.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [BookEntity::class],
    version = 1
)

@TypeConverters(
    StringListTypeConvertor::class
)
abstract class FavoriteBookDatabase : RoomDatabase() {

    abstract val favoriteBookDao: FavoriteBookDao

    companion object {
        const val DB_NAME = "book.db"
    }

}