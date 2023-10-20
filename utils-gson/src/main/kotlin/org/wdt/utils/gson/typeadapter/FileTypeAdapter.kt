package org.wdt.utils.gson.typeadapter

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.io.File


class FileTypeAdapter : TypeAdapter<File>() {
    override fun write(out: JsonWriter?, value: File?) {
        out?.value(value?.path ?: String())
    }

    override fun read(`in`: JsonReader?): File {
        val path: String
        if (`in`!!.peek() === JsonToken.BEGIN_OBJECT) {
            `in`!!.beginObject()
            `in`.nextName()
            path = `in`.nextString()
            `in`.endObject()
        } else {
            path = `in`!!.nextString()
        }
        return File(path)
    }

}