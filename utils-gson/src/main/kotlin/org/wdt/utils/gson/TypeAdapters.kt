package org.wdt.utils.gson

import com.google.gson.JsonDeserializer
import com.google.gson.JsonSerializer

@Deprecated(
  "use SimpleTypeAdapter<T>",
  replaceWith = ReplaceWith("SimpleTypeAdapter<T>")
)
interface TypeAdapters<T> : JsonDeserializer<T>, JsonSerializer<T>

interface SimpleTypeAdapter<T> : JsonDeserializer<T>, JsonSerializer<T>