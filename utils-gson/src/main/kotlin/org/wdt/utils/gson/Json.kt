package org.wdt.utils.gson

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.wdt.utils.gson.typeadapter.FileTypeAdapter

import java.io.File


object Json {
    @JvmStatic
    val fileGson: Gson = getBuilder().setPrettyPrinting().create()

    @JvmStatic
    val gson: Gson = getBuilder().create()

    @JvmStatic
    val gsonBuilder: GsonBuilder = getBuilder()

    @JvmStatic
    fun getBuilder(): GsonBuilder {
        return GsonBuilder().disableHtmlEscaping().registerTypeAdapter(File::class.java, FileTypeAdapter())
    }
}