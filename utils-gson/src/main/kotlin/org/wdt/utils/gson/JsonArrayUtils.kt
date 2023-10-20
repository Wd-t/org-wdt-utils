package org.wdt.utils.gson

import com.google.gson.JsonArray
import com.google.gson.JsonParser

fun JsonArray.getString(index: Int): String {
    return this.get(index).asString
}

fun JsonArray.getInt(index: Int): Int {
    return this.get(index).asInt
}

fun JsonArray.getDouble(index: Int): Double {
    return this.get(index).asDouble
}

fun JsonArray.getBoolean(index: Int): Boolean {
    return this.get(index).asBoolean
}

fun JsonArray.getLong(index: Int): Long {
    return this.get(index).asLong
}

object JsonArrayUtils {
    fun parseArray(jsonString: String): JsonArray {
        return JsonParser.parseString(jsonString).asJsonArray
    }
}
