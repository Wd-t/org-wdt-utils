package org.wdt.utils.gson

import com.google.gson.*
import java.lang.reflect.Type

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

inline fun <reified T> GsonBuilder.registerSimpleObjectSerializer(crossinline block: (T) -> JsonElement): GsonBuilder {
  return registerTypeAdapter(T::class.java, object : JsonSerializer<T> {
    override fun serialize(src: T, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
      return block(src)
    }
  })
}

inline fun <reified T> GsonBuilder.registerSimpleObjectDeserializer(crossinline block: (JsonElement) -> T): GsonBuilder {
  return registerTypeAdapter(T::class.java, object : JsonDeserializer<T> {
    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): T {
      return block(json)
    }
  })
}

inline fun <reified T> GsonBuilder.registerTypeAdapter(pair: Pair<T, TypeAdapters<T>>): GsonBuilder {
  return registerTypeAdapter(pair.first!!::class.java, pair.second)
}