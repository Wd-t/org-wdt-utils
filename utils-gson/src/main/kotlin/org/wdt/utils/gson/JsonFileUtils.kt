package org.wdt.utils.gson

import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.wdt.utils.io.writeStringToFile
import java.io.File

object JsonFileUtils {
	@JvmStatic
	fun formatJsonFile(file: File) {
		file.writeStringToFile(Json.GSON_BUILDER.setPrettyPrinting().create().toJson(JsonUtils.getJsonObject(file)))
	}
}

fun File.readFileToJsonObject(): JsonObject {
	return JsonUtils.getJsonObject(this)
}

fun File.readFileToJsonArray(): JsonArray {
	return JsonUtils.getJsonArray(this)
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