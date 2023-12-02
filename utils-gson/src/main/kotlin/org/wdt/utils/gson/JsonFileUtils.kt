package org.wdt.utils.gson

import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.io.File

object JsonFileUtils {
	@JvmStatic
	fun formatJsonFile(file: File) {
		file.writeObjectToFile(file.readFileToJsonObject(), Json.GSON_BUILDER.setPrettyPrinting())
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

inline fun <reified T> File.readFileToClass(): T {
	return JsonUtils.readFileToClass(this, T::class.java)
}

fun File.writeObjectToFile(o: Any) {
	return JsonUtils.writeObjectToFile(this, o)
}

fun File.writeObjectToFile(o: Any, builder: GsonBuilder) {
	JsonUtils.writeObjectToFile(this, o, builder)
}