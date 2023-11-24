@file:Suppress("NOTHING_TO_INLINE")

package org.wdt.utils.gson

import com.google.gson.JsonArray
import com.google.gson.JsonObject

inline fun JsonObject.getString(key: String): String {
    return this.get(key).asString
}

inline fun JsonObject.getInt(key: String): Int {
    return this.get(key).asInt
}

inline fun JsonObject.getBoolean(key: String): Boolean {
    return this.get(key).asBoolean
}

inline fun JsonObject.getDouble(key: String): Double {
    return this.get(key).asDouble
}

inline fun JsonObject.getJsonObject(key: String): JsonObject {
    return this.get(key).asJsonObject
}

inline fun JsonObject.getJsonArray(key: String): JsonArray {
    return this.get(key).asJsonArray
}

inline fun <reified T> JsonObject.parseObject(): T {
    return JsonObjectUtils.parseObject(this, T::class.java)
}

inline fun <reified T> String.parseObject(): T {
    return JsonObjectUtils.parseObject(this, T::class.java)
}

fun String.parseJsonObject(): JsonObject {
    return JsonObjectUtils.parseJsonObject(this)
}
