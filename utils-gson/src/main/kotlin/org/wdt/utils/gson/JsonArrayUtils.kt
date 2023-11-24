@file:Suppress("NOTHING_TO_INLINE")

package org.wdt.utils.gson

import com.google.gson.JsonArray
import com.google.gson.JsonObject

inline fun JsonArray.getString(index: Int): String {
	return this.get(index).asString
}

inline fun JsonArray.getInt(index: Int): Int {
	return this.get(index).asInt
}

inline fun JsonArray.getDouble(index: Int): Double {
	return this.get(index).asDouble
}

inline fun JsonArray.getBoolean(index: Int): Boolean {
	return this.get(index).asBoolean
}

inline fun JsonArray.getLong(index: Int): Long {
	return this.get(index).asLong
}

inline fun JsonArray.getJsonObject(index: Int): JsonObject {
	return this.get(index).asJsonObject;
}

inline fun JsonArray.getJsonArray(index: Int): JsonArray {
	return this.get(index).asJsonArray;
}

fun String.parseJsonArray(): JsonArray {
	return JsonArrayUtils.parseJsonArray(this)
}

inline fun <reified T : Iterable<T>> String.parseArray(): T {
	return JsonArrayUtils.parseArray(this, T::class.java);
}

inline fun <reified T : Iterable<T>> JsonArray.parseArray(): T {
	return JsonArrayUtils.parseArray(this, T::class.java);
}

