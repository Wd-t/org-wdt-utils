package org.wdt.utils.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class JsonArrayUtils {
    public static JsonArray parseJsonArray(String jsonString) {
        return JsonParser.parseString(jsonString).getAsJsonArray();
    }

    public static <T extends Iterable<T>> T parseArray(String jsonString, Class<T> clazz) {
        return Json.GSON.fromJson(jsonString, clazz);
    }

    public static <T extends Iterable<T>> T parseArray(JsonArray jsonArray, Class<T> clazz) {
        return Json.GSON.fromJson(jsonArray, clazz);
    }
}
