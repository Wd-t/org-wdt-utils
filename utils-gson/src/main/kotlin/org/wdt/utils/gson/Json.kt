package org.wdt.utils.gson

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.wdt.utils.gson.typeadapter.FileTypeAdapter

import java.io.File


object Json {
    val FILE_GSON: Gson = getBuilder().setPrettyPrinting().create()
    val GSON: Gson = getBuilder().create()
    val GSONBUILDER: GsonBuilder = getBuilder()
    fun getBuilder(): GsonBuilder {
        return GsonBuilder().disableHtmlEscaping().registerTypeAdapter(File::class.java, FileTypeAdapter())
    }
}