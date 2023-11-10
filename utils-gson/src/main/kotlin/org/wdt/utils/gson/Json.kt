package org.wdt.utils.gson

fun Any.toJsonString(): String {
    return Json.toJsonString(this)
}