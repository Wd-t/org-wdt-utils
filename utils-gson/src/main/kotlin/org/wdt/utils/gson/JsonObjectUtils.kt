package org.wdt.utils.gson

import com.google.gson.JsonObject
import com.google.gson.JsonParser

fun JsonObject.getString(key: String): String {
    return this.get(key).asString
}

fun JsonObject.getInt(key: String): Int {
    return this.get(key).asInt
}

fun JsonObject.getBoolean(key: String): Boolean {
    return this.get(key).asBoolean
}

fun JsonObject.getDouble(key: String): Double {
    return this.get(key).asDouble
}

object JsonObjectUtils {
    fun parseObject(jsonString: String): JsonObject {
        return JsonParser.parseString(jsonString).asJsonObject
    }

}
