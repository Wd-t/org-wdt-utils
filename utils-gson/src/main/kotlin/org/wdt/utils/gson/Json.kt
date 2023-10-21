package org.wdt.utils.gson

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.wdt.utils.gson.typeadapter.FileTypeAdapter

import java.io.File


object Json {
    @JvmStatic
    val FILE_GSON: Gson = getBuilder().setPrettyPrinting().create()

    @JvmStatic
    val GSON: Gson = getBuilder().create()

    @JvmStatic
    val GSONBUILDER: GsonBuilder = getBuilder()

    @JvmStatic
    fun getBuilder(): GsonBuilder {
        return GsonBuilder().disableHtmlEscaping().registerTypeAdapter(File::class.java, FileTypeAdapter())
    }
}