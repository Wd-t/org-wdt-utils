package org.wdt.utils.gson;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

public interface TypeAdapters<T> extends JsonSerializer<T>, JsonDeserializer<T> {

}
