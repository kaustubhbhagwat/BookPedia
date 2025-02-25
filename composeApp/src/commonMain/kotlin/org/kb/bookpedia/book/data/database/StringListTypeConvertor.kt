package org.kb.bookpedia.book.data.database

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object StringListTypeConvertor {
//    @TypeConverter
//    fun fromString(value: String){
//        return Json.decodeFromString(value)
//    }
//
    @TypeConverter
    fun fromString(value: String): List<String> {
        return Json.decodeFromString(value)
    }

//    @TypeConverter
//    fun fromList(list: List<String>): String{
//        return Json.encodeToString(list)
//    }


    @TypeConverter
    fun fromList(list: List<String>): String {
        return Json.encodeToString(list)
    }
}