package org.wdt.utils.gson

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.io.InputStream
import java.io.Reader

fun InputStream.parseJsonStreamToJsonObject(): JsonObject {
  return JsonIOUtils.parseJsonSteamToJsonObject(this)
}

fun InputStream.parseJsonStreamToJsonElement(): JsonElement {
  return JsonIOUtils.parseJsonStreamToJsonElement(this)
}

fun InputStream.parseJsonStreamToJsonArray(): JsonArray {
  return JsonIOUtils.parseJsonSteamToJsonArray(this)
}

fun Reader.parseReaderToJsonObject(): JsonObject {
  return JsonIOUtils.parseJsonReaderToJsonObject(this)
}

fun Reader.parseReaderToJsonElement(): JsonElement {
  return JsonIOUtils.parseJsonReaderToJsonElement(this)
}

fun Reader.parseReaderToJsonArray(): JsonArray {
  return JsonIOUtils.parseJsonReaderToJsonArray(this)
}