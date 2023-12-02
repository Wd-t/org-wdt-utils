package org.wdt.utils.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonObjectUtils {

    public static JsonObject parseJsonObject(String jsonString) {
        return JsonUtils.parseJsonElement(jsonString).getAsJsonObject();
    }

    public static <T> T parseObject(String jsonString, Class<T> clazz) {
        return Json.GSON.fromJson(jsonString, clazz);
    }

    public static <T> T parseObject(JsonElement jsonElement, Class<T> clazz) {
        return Json.GSON.fromJson(jsonElement, clazz);
    }
}
