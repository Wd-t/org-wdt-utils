package org.wdt.utils.gson

import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonObject

fun JsonObject.getString(key: String): String {
    if (checkKey(key)) {
        return this.get(key).asString
    }
    throwIllegalStateException(key)
}

fun JsonObject.getInt(key: String): Int {
    if (checkKey(key)) {
        return this.get(key).asInt
    }
    throwIllegalStateException(key)

}

fun JsonObject.getBoolean(key: String): Boolean {
    if (checkKey(key)) {
        return this.get(key).asBoolean
    }
    throwIllegalStateException(key)}

fun JsonObject.getDouble(key: String): Double {
    if (checkKey(key)) {
        return this.get(key).asDouble
    }
    throwIllegalStateException(key)}

fun JsonObject.getJsonObject(key: String): JsonObject {
    if (checkKey(key)) {
        return this.get(key).asJsonObject
    }
    throwIllegalStateException(key)}

fun JsonObject.getJsonArray(key: String): JsonArray {
    if (checkKey(key)) {
        return this.get(key).asJsonArray
    }
    throwIllegalStateException(key)}

fun JsonObject.checkKey(key: String): Boolean {
    return this.has(key) && !this.get(key).isJsonNull
}

private fun throwIllegalStateException(key: String): Nothing {
    throw IllegalStateException("$key invalid")
}

inline fun <reified T> JsonObject.parseObject(builder: GsonBuilder = Json.getBuilder()): T {
    return JsonObjectUtils.parseObject(this, T::class.java, builder)
}

inline fun <reified T> String.parseObject(builder: GsonBuilder = Json.getBuilder()): T {
    return JsonObjectUtils.parseObject(this, T::class.java, builder)
}

fun String.parseJsonObject(): JsonObject {
    return JsonObjectUtils.parseJsonObject(this)
}
