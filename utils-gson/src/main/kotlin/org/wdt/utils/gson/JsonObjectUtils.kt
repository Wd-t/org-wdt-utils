package org.wdt.utils.gson

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
  throwIllegalStateException(key)
}

fun JsonObject.getDouble(key: String): Double {
  if (checkKey(key)) {
    return this.get(key).asDouble
  }
  throwIllegalStateException(key)
}

fun JsonObject.getJsonObject(key: String): JsonObject {
  if (checkKey(key)) {
    return this.get(key).asJsonObject
  }
  throwIllegalStateException(key)
}

fun JsonObject.getJsonArray(key: String): JsonArray {
  if (checkKey(key)) {
    return this.get(key).asJsonArray
  }
  throwIllegalStateException(key)
}

fun JsonObject(vararg pair: Pair<String, String>): JsonObject {
  return JsonObject().apply {
    pair.forEach {
      addProperty(it.first, it.second)
    }
  }
}

fun JsonObject.checkKey(key: String): Boolean {
  return this.has(key) && !this.get(key).isJsonNull
}

private fun throwIllegalStateException(key: String): Nothing {
  throw IllegalStateException("$key invalid")
}

fun String.parseJsonObject(): JsonObject {
  return JsonObjectUtils.parseJsonObject(this)
}
