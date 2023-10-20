@file:JvmName("JsonUtils")

package org.wdt.utils.gson

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.wdt.utils.gson.Json.FILE_GSON
import org.wdt.utils.gson.JsonObjectUtils.parseObject
import org.wdt.utils.io.readFileToString
import org.wdt.utils.io.writeStringToFile
import java.io.File
import java.io.IOException

object JsonUtils {


    @Throws(IOException::class)
    fun getJSONObject(file: File): JsonObject {
        return parseObject(file.readFileToString())
    }


    @Throws(IOException::class)
    fun getJsonObject(jsonFile: File): JsonObject {
        return parseObject(jsonFile.readFileToString())
    }

    @Throws(IOException::class)
    fun getJsonObject(jsonFilePath: String): JsonObject {
        return getJsonObject(File(jsonFilePath))
    }

    @Throws(IOException::class)
    fun <T> readFileToClass(jsonFile: File, clazz: Class<T>): T {
        return FILE_GSON.fromJson(getJSONObject(jsonFile), clazz)
    }

    @Throws(IOException::class)
    fun <T> readFileToClass(jsonFilePath: String, clazz: Class<T>): T {
        return readFileToClass(File(jsonFilePath), clazz)
    }

    fun writeObjectToFile(jsonFile: File, o: Any) {
        try {
            jsonFile.writeStringToFile(FILE_GSON.toJson(o))
        } catch (_: IOException) {
        }
    }

    fun writeObjectToFile(jsonFilePath: String, o: Any) {
        writeObjectToFile(File(jsonFilePath), o)
    }

    @Throws(IOException::class)
    fun getJsonArray(jsonFile: File): JsonArray {
        return JsonArrayUtils.parseArray(jsonFile.readFileToString())
    }

    @Throws(IOException::class)
    fun getJsonArray(jsonFilePath: String): JsonArray {
        return getJsonArray(File(jsonFilePath))
    }
}
