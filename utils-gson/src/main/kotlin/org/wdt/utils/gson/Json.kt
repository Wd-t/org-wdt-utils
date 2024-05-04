package org.wdt.utils.gson

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonSerializer

fun Any.toJsonString(builder: GsonBuilder = Json.getBuilder()): String {
  return Json.toJsonString(this, builder)
}

fun String.parseJsonElement(): JsonElement {
  return JsonUtils.parseJsonElement(this)
}

fun GsonBuilder.toJson(any: Any): String {
  return create().toJson(any)
}

fun GsonBuilder.toJsonTree(any: Any): JsonElement {
  return create().toJsonTree(any)
}

inline fun <reified T> JsonElement.parseObject(builder: GsonBuilder = Json.getBuilder()): T {
  return JsonUtils.parseObject(this, T::class.java, builder)
}

inline fun <reified T> String.parseObject(builder: GsonBuilder = Json.getBuilder()): T {
  return JsonUtils.parseObject(this, T::class.java, builder)
}

interface TypeAdapters<T> : JsonSerializer<T>, JsonDeserializer<T>

fun <T : TypeAdapters<*>> GsonBuilder.registerTypeAdapters(any: T): GsonBuilder {
  val clazz = any.javaClass.interfaces.filter {
    it.canonicalName==TypeAdapters::class.java.canonicalName
  }
  return also { builder ->
    clazz.forEach {
      builder.registerTypeAdapter(it, any)
    }
  }
}