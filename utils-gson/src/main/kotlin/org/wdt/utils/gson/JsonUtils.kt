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
    fun getJsonObject(jsonFile: File): JsonObject {
        return parseObject(jsonFile.readFileToString())
    }

    @JvmStatic
    @Throws(IOException::class)
    fun getJsonObject(jsonFilePath: String): JsonObject {
        return getJsonObject(File(jsonFilePath))
    }

    @JvmStatic
    @Throws(IOException::class)
    fun <T> readFileToClass(jsonFile: File, clazz: Class<T>): T {
        return parseObject(jsonFile.readFileToString(), clazz)
    }

    @JvmStatic
    @Throws(IOException::class)
    fun <T> readFileToClass(jsonFilePath: String, clazz: Class<T>): T {
        return readFileToClass(File(jsonFilePath), clazz)
    }

    @JvmStatic
    @Throws(IOException::class)
    fun writeObjectToFile(jsonFile: File, o: Any) {
            jsonFile.writeStringToFile(FILE_GSON.toJson(o))
    }

    @JvmStatic
    @Throws(IOException::class)
    fun writeObjectToFile(jsonFilePath: String, o: Any) {
        writeObjectToFile(File(jsonFilePath), o)
    }

    @JvmStatic
    @Throws(IOException::class)
    fun getJsonArray(jsonFile: File): JsonArray {
        return JsonArrayUtils.parseArray(jsonFile.readFileToString())
    }

    @JvmStatic
    @Throws(IOException::class)
    fun getJsonArray(jsonFilePath: String): JsonArray {
        return getJsonArray(File(jsonFilePath))
    }
}
