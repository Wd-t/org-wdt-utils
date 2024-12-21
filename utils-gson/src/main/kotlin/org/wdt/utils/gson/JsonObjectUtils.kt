package org.wdt.utils.gson

import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.JsonObject
import java.math.BigDecimal

fun JsonObject.getJsonObjectOrNull(key: String): JsonObject? {
  return this.get(key)?.asJsonObject
}

fun JsonObject.getJsonArrayOrNull(key: String): JsonArray? {
  return this.get(key)?.asJsonArray
}

fun JsonObject.getStringOrNull(key: String): String? {
  return this.get(key)?.asString
}

fun JsonObject.getIntOrNull(key: String): Int? {
  return this.get(key)?.asInt
}

fun JsonObject.getBooleanOrNull(key: String): Boolean? {
  return this.get(key)?.asBoolean
}

fun JsonObject.getDoubleOrNull(key: String): Double? {
  return this.get(key)?.asDouble
}

fun JsonObject.getLongOrNull(key: String): Long? {
  return this.get(key)?.asLong
}

fun JsonObject.getNummberOrNull(key: String): Number? {
  return this.get(key)?.asNumber
}

fun JsonObject.getBigDecimalOrNull(key: String): BigDecimal? {
  return this.get(key)?.asBigDecimal
}

fun JsonObject.getFloatOrNull(key: String): Float? {
  return this.get(key)?.asFloat
}

fun JsonObject.getShortOrNull(key: String): Short? {
  return this.get(key)?.asShort
}

fun JsonObject.getByteOrNull(key: String): Byte? {
  return this.get(key)?.asByte
}

fun JsonObject.getJsonObject(key: String): JsonObject {
  return getJsonObjectOrNull(key).requireNotNull(key)
}

fun JsonObject.getJsonArray(key: String): JsonArray {
  return getJsonArrayOrNull(key).requireNotNull(key)
}

fun JsonObject.getString(key: String): String {
  return getStringOrNull(key).requireNotNull(key)
}

fun JsonObject.getInt(key: String): Int {
  return getIntOrNull(key).requireNotNull(key)
}

fun JsonObject.getBoolean(key: String): Boolean {
  return getBooleanOrNull(key).requireNotNull(key)
}

fun JsonObject.getDouble(key: String): Double {
  return getDoubleOrNull(key).requireNotNull(key)
}

fun JsonObject.getLong(key: String): Long {
  return getLongOrNull(key).requireNotNull(key)
}

fun JsonObject.getNummber(key: String): Number {
  return getNummberOrNull(key).requireNotNull(key)
}

fun JsonObject.getBigDecimal(key: String): BigDecimal {
  return getBigDecimalOrNull(key).requireNotNull(key)
}

fun JsonObject.getFloat(key: String): Float {
  return getFloatOrNull(key).requireNotNull(key)
}

fun JsonObject.getByte(key: String): Byte {
  return getByteOrNull(key).requireNotNull(key)
}

fun JsonObject(vararg pair: Pair<String, String>): JsonObject {
  return buildJsonObject {
    pair.forEach {
      put(it.first, it.second)
    }
  }
}

inline fun buildJsonObject(gsonBuilder: GsonBuilder = Json.getBuilder(), block: JsonObjectBuilder.() -> Unit): JsonObject {
  return JsonObjectBuilder(gsonBuilder).apply(block).build()
}

private fun <T> T?.requireNotNull(key: String): T {
  return this ?: throw IllegalStateException("$key invalid")
}

fun String.parseJsonObject(): JsonObject {
  return JsonObjectUtils.parseJsonObject(this)
}

class JsonObjectBuilder(
  private val gsonBuilder: GsonBuilder = Json.getBuilder()
) {

  private val jsonObject: JsonObject = JsonObject()

  fun put(key: String, value: Any?) = when (value) {
    is JsonElement -> jsonObject.add(key, value)
    is Number -> jsonObject.addProperty(key, value)
    is String -> jsonObject.addProperty(key, value)
    is Boolean -> jsonObject.addProperty(key, value)
    is Char -> jsonObject.addProperty(key, value)
    null -> jsonObject.add(key, JsonNull.INSTANCE)
    else -> jsonObject.add(key, gsonBuilder.toJsonTree(value))
  }

  fun remove(key: String): JsonElement? = jsonObject.remove(key)

  fun build(): JsonObject = jsonObject

}

inline fun JsonObjectBuilder.putJsonObject(
  gsonBuilder: GsonBuilder = Json.getBuilder(),
  key: String,
  value: JsonObjectBuilder.() -> Unit) = put(key, buildJsonObject(gsonBuilder, value))

inline fun JsonObjectBuilder.putJsonArray(
  gsonBuilder: GsonBuilder = Json.getBuilder(),
  key: String,
  value: JsonArrayBuilder.() -> Unit) = put(key, buildJsonArray(gsonBuilder, value))