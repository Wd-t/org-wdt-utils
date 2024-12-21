package org.wdt.utils.gson

import com.google.gson.*
import java.math.BigDecimal
import java.util.*

fun JsonArray.getJsonObjectOrNull(index: Int): JsonObject? {
  return this.get(index)?.asJsonObject
}

fun JsonArray.getJsonArrayOrNull(index: Int): JsonArray? {
  return this.get(index)?.asJsonArray
}

fun JsonArray.getStringOrNull(index: Int): String? {
  return this.get(index)?.asString
}

fun JsonArray.getIntOrNull(index: Int): Int? {
  return this.get(index)?.asInt
}

fun JsonArray.getBooleanOrNull(index: Int): Boolean? {
  return this.get(index)?.asBoolean
}

fun JsonArray.getDoubleOrNull(index: Int): Double? {
  return this.get(index)?.asDouble
}

fun JsonArray.getLongOrNull(index: Int): Long? {
  return this.get(index)?.asLong
}

fun JsonArray.getNummberOrNull(index: Int): Number? {
  return this.get(index)?.asNumber
}

fun JsonArray.getBigDecimalOrNull(index: Int): BigDecimal? {
  return this.get(index)?.asBigDecimal
}

fun JsonArray.getFloatOrNull(index: Int): Float? {
  return this.get(index)?.asFloat
}

fun JsonArray.getShortOrNull(index: Int): Short? {
  return this.get(index)?.asShort
}

fun JsonArray.getByteOrNull(index: Int): Byte? {
  return this.get(index)?.asByte
}

fun JsonArray.getJsonObject(index: Int): JsonObject {
  return getJsonObjectOrNull(index).requireNotNull(index)
}

fun JsonArray.getJsonArray(index: Int): JsonArray {
  return getJsonArrayOrNull(index).requireNotNull(index)
}

fun JsonArray.getString(index: Int): String {
  return getStringOrNull(index).requireNotNull(index)
}

fun JsonArray.getInt(index: Int): Int {
  return getIntOrNull(index).requireNotNull(index)
}

fun JsonArray.getBoolean(index: Int): Boolean {
  return getBooleanOrNull(index).requireNotNull(index)
}

fun JsonArray.getDouble(index: Int): Double {
  return getDoubleOrNull(index).requireNotNull(index)
}

fun JsonArray.getLong(index: Int): Long {
  return getLongOrNull(index).requireNotNull(index)
}

fun JsonArray.getNummber(index: Int): Number {
  return getNummberOrNull(index).requireNotNull(index)
}

fun JsonArray.getBigDecimal(index: Int): BigDecimal {
  return getBigDecimalOrNull(index).requireNotNull(index)
}

fun JsonArray.getFloat(index: Int): Float {
  return getFloatOrNull(index).requireNotNull(index)
}

fun JsonArray.getByte(index: Int): Byte {
  return getByteOrNull(index).requireNotNull(index)
}

fun <T> JsonArray(list: List<T>, builder: GsonBuilder = Json.getBuilder()): JsonArray {
  return list.asJsonArray(builder)
}

fun JsonArray(builder: JsonArrayBuilder): JsonArray = builder.build()

inline fun buildJsonArray(gsonBuilder: GsonBuilder = Json.getBuilder(), block: JsonArrayBuilder.() -> Unit): JsonArray {
  return JsonArray(JsonArrayBuilder(gsonBuilder).apply(block))
}

fun <T> Iterable<T>.asJsonArray(gsonBuilder: GsonBuilder = Json.getBuilder()): JsonArray {
  return buildJsonArray {
    forEach(this::add)
  }
}

inline fun <reified T> JsonArray.parseObjectList(builder: GsonBuilder = Json.getBuilder()): List<T> {
  return parseObjectListTo(LinkedList(), builder)
}

inline fun <reified T, M : MutableCollection<in T>> JsonArray.parseObjectListTo(m: M, builder: GsonBuilder = Json.getBuilder()): M {
  return asList().run {
    mapTo(m) { builder.fromJson<T>(it) }
  }
}

private fun <T> T?.requireNotNull(index: Int): T {
  return this ?: throw IllegalStateException("$index in array is invalid")
}

fun String.parseJsonArray(): JsonArray {
  return JsonArrayUtils.parseJsonArray(this)
}

class JsonArrayBuilder(
  private val gsonBuilder: GsonBuilder = Json.getBuilder()
) {
  private val elements: JsonArray = JsonArray()

  fun add(element: Any?) = when (element) {
    is JsonElement -> elements.add(element)
    is Number -> elements.add(element)
    is String -> elements.add(element)
    is Boolean -> elements.add(element)
    is Char -> elements.add(element)
    null -> elements.add(JsonNull.INSTANCE)
    else -> elements.add(gsonBuilder.toJsonTree(element))
  }

  fun set(index: Int, element: Any?): JsonElement = when (element) {
    is JsonElement -> elements.set(index, element)
    is Number -> elements.set(index, JsonPrimitive(element))
    is String -> elements.set(index, JsonPrimitive(element))
    is Boolean -> elements.set(index, JsonPrimitive(element))
    is Char -> elements.set(index, JsonPrimitive(element))
    null -> elements.set(index, JsonNull.INSTANCE)
    else -> elements.set(index, gsonBuilder.toJsonTree(element))
  }

  fun remove(element: Any?): Boolean = when (element) {
    is JsonElement -> elements.remove(element)
    is Number -> elements.remove(JsonPrimitive(element))
    is String -> elements.remove(JsonPrimitive(element))
    is Boolean -> elements.remove(JsonPrimitive(element))
    is Char -> elements.remove(JsonPrimitive(element))
    null -> elements.remove(JsonNull.INSTANCE)
    else -> elements.remove(gsonBuilder.toJsonTree(element))

  }

  fun remove(index: Int): JsonElement = elements.remove(index)

  fun build(): JsonArray = elements
}

fun JsonArrayBuilder.addJsonArray(gsonBuilder: GsonBuilder = Json.getBuilder(), block: JsonArrayBuilder.() -> Unit) =
  add(buildJsonArray(gsonBuilder, block))


fun JsonArrayBuilder.addJsonObject(gsonBuilder: GsonBuilder = Json.getBuilder(), block: JsonObjectBuilder.() -> Unit) =
  add(buildJsonObject(gsonBuilder, block))