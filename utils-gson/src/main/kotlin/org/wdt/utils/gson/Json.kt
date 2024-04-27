package org.wdt.utils.gson

import com.google.gson.GsonBuilder
import com.google.gson.JsonElement

fun Any.toJsonString(builder: GsonBuilder = Json.getBuilder()): String {
  return Json.toJsonString(this, builder)
}

fun String.parseJsonElement(): JsonElement {
  return JsonUtils.parseJsonElement(this)
}