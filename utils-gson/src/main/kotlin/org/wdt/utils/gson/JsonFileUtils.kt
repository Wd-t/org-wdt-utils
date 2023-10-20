@file:JvmName("JsonFileUtils")

package org.wdt.utils.gson

import org.wdt.utils.io.writeStringToFile
import java.io.File
import java.io.IOException


fun formatJsonFile(file: File) {
    try {
        file.writeStringToFile(Json.FILE_GSON.toJson(JsonUtils.getJsonObject(file)))
    } catch (_: IOException) {
    }
}