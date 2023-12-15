package org.wdt.utils.gson

import com.google.gson.JsonArray
import com.google.gson.JsonObject

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

fun JsonArray.getJsonObject(index: Int): JsonObject {
	return this.get(index).asJsonObject;
}

fun JsonArray.getJsonArray(index: Int): JsonArray {
	return this.get(index).asJsonArray;
}

fun String.parseJsonArray(): JsonArray {
	return JsonArrayUtils.parseJsonArray(this)
}

inline fun <reified T> String.parseArray(): T {
	return JsonArrayUtils.parseArray(this, T::class.java);
}

inline fun <reified T> JsonArray.parseArray(): T {
	return JsonArrayUtils.parseArray(this, T::class.java);
}

