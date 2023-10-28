package org.wdt.utils.gson

import org.wdt.utils.io.writeStringToFile
import java.io.File
import java.io.IOException

object JsonFileUtils {
    @JvmStatic
    fun formatJsonFile(file: File) {
        try {
            file.writeStringToFile(Json.fileGson.toJson(JsonUtils.getJsonObject(file)))
        } catch (_: IOException) {
        }
    }
}