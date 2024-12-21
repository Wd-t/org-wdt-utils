package org.wdt.utils.gson

import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.io.File

@Deprecated(
  "remove soon",
  ReplaceWith("this.writeObjectToFile(builder.setPrettyPrinting()) { readFileToJsonElement() }"),
)
fun File.formatJsonFile(builder: GsonBuilder = Json.getBuilder()) {
  this.writeObjectToFile(builder.setPrettyPrinting()) {
    readFileToJsonElement()
  }
}

fun File.readFileToJsonObject(): JsonObject {
  return JsonUtils.readFileToJsonObject(this)
}

fun File.readFileToJsonArray(): JsonArray {
  return JsonUtils.readFileToJsonArray(this)
}

fun File.readFileToJsonElement(): JsonElement {
  return JsonUtils.readFileToJsonElement(this)
}

inline fun <reified T> File.readFileToClass(builder: GsonBuilder = Json.getBuilder()): T {
  return JsonUtils.readFileToClass(this, T::class.java, builder)
}

inline fun <reified T, R> File.readFileToClass(builder: GsonBuilder = Json.getBuilder(), block: (T) -> R): R {
  return block(JsonUtils.readFileToClass(this, T::class.java, builder))
}


inline fun <T> File.writeObjectToFile(builder: GsonBuilder = Json.getBuilder(), block: () -> T) {
  return JsonUtils.writeObjectToFile(this, block(), builder)
}