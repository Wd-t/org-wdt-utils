package org.wdt.utils.gson

import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonObject

fun JsonArray.getString(index: Int): String {
  if (ckeckIndex(index)) {
    return this.get(index).asString
  }
  throwIllegalStateException(index)
}

fun JsonArray.getInt(index: Int): Int {
  if (ckeckIndex(index)) {
    return this.get(index).asInt
  }
  throwIllegalStateException(index)
}

fun JsonArray.getDouble(index: Int): Double {
  if (ckeckIndex(index)) {
    return this.get(index).asDouble
  }
  throwIllegalStateException(index)
}

fun JsonArray.getBoolean(index: Int): Boolean {
  if (ckeckIndex(index)) {
    return this.get(index).asBoolean
  }
  throwIllegalStateException(index)
}

fun JsonArray.getLong(index: Int): Long {
  if (ckeckIndex(index)) {
    return this.get(index).asLong
  }
  throwIllegalStateException(index)
}

fun JsonArray.getJsonObject(index: Int): JsonObject {
  if (ckeckIndex(index)) {
    return this.get(index).asJsonObject
  }
  throwIllegalStateException(index)
}

fun JsonArray.getJsonArray(index: Int): JsonArray {
  if (ckeckIndex(index)) {
    return this.get(index).asJsonArray
  }
  throwIllegalStateException(index)
}

fun <T> Iterable<T>.asJsonArray(gsonBuilder: GsonBuilder = Json.getBuilder()): JsonArray {
  return JsonArray().apply {
    this@asJsonArray.iterator().forEach {
      add(gsonBuilder.create().toJsonTree(it))
    }
  }
}

inline fun <reified T> JsonArray.asParseObjectList(builder: GsonBuilder): List<T> {
  return asList().map { it.parseObject<T>(builder) }
}

private fun throwIllegalStateException(index: Int): Nothing {
  throw IllegalStateException("$index in array is invalid")
}

fun JsonArray.ckeckIndex(index: Int): Boolean {
  return !this.get(index).isJsonNull
}

fun String.parseJsonArray(): JsonArray {
  return JsonArrayUtils.parseJsonArray(this)
}

inline fun <reified T> JsonArray.parseObject(builder: GsonBuilder = Json.getBuilder()): T {
  return JsonUtils.parseObject(this, T::class.java, builder)
}

