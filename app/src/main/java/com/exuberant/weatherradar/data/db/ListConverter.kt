package com.exuberant.weatherradar.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ListConverter {

    @TypeConverter
    fun stringListToJson(list: List<String>): String? {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun jsonToStringList(string: String): List<String> {
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.getType()
        return Gson().fromJson(string, listType)
    }
}