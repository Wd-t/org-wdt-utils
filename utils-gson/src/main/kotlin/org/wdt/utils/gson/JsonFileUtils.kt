package org.wdt.utils.gson

import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.io.File


fun File.formatJsonFile() {
    this.writeObjectToFile(this.readFileToJsonObject(), Json.getBuilder().setPrettyPrinting())
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

fun File.writeObjectToFile(o: Any, builder: GsonBuilder = Json.getBuilder()) {
    return JsonUtils.writeObjectToFile(this, o, builder)
}