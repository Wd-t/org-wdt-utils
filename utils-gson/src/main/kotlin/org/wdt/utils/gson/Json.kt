package org.wdt.utils.gson

import com.google.gson.GsonBuilder

fun Any.toJsonString(): String {
    return Json.toJsonString(this)
}

fun Any.toJsonString(builder: GsonBuilder): String {
    return Json.toJsonString(this, builder)
}