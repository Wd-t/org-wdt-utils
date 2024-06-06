package org.wdt.utils.gson

import com.google.gson.GsonBuilder
import com.google.gson.JsonElement

fun Any.toJsonString(builder: GsonBuilder = Json.getBuilder()): String {
  return Json.toJsonString(this, builder)
}

fun String.parseJsonElement(): JsonElement {
  return JsonUtils.parseJsonElement(this)
}

fun <T> GsonBuilder.toJson(any: T): String {
  return create().toJson(any)
}

fun <T> GsonBuilder.toJson(block: () -> T): String {
  return toJson(block())
}


inline fun <reified T> GsonBuilder.fromJson(jsonElement: JsonElement): T {
  return create().fromJson(jsonElement, T::class.java)
}

fun <T> GsonBuilder.toJsonTree(block: () -> T): JsonElement {
  return toJsonTree(block())
}


fun <T> GsonBuilder.toJsonTree(any: T): JsonElement {
  return create().toJsonTree(any)
}

inline fun <reified T> String.parseObject(builder: GsonBuilder = Json.getBuilder()): T {
  return JsonUtils.parseObject(this, T::class.java, builder)
}

inline fun <reified T> JsonElement.parseObject(builder: GsonBuilder = Json.getBuilder()): T {
  return JsonUtils.parseObject(this, T::class.java, builder)
}