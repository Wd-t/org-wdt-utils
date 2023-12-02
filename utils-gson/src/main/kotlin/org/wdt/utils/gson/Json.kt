package org.wdt.utils.gson

import com.google.gson.GsonBuilder
import com.google.gson.JsonElement

fun Any.toJsonString(): String {
    return Json.toJsonString(this)
}

fun Any.toJsonString(builder: GsonBuilder): String {
    return Json.toJsonString(this, builder)
}

fun String.parseJsonElement(): JsonElement {
    return JsonUtils.parseJsonElement(this)
}