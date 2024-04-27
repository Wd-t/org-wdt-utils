package org.wdt.utils.gson;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.IOException;

public class JsonObjectUtils {

    public static JsonObject parseJsonObject(String jsonString) {
        return JsonUtils.parseJsonElement(jsonString).getAsJsonObject();
    }

    public static JsonObject parseJsonObject(File jsonFile) throws IOException {
        return JsonUtils.readFileToJsonElement(jsonFile).getAsJsonObject();
    }

    public static <T> T parseObject(String jsonString, Class<T> clazz) {
        return parseObject(jsonString, clazz, Json.getBuilder());
    }

    public static <T> T parseObject(String jsonString, Class<T> clazz, GsonBuilder builder) {
        return builder.create().fromJson(jsonString, clazz);
    }

    public static <T> T parseObject(JsonElement jsonElement, Class<T> clazz) {
        return parseObject(jsonElement, clazz, Json.getBuilder());
    }

    public static <T> T parseObject(JsonElement jsonElement, Class<T> clazz, GsonBuilder builder) {
        return builder.create().fromJson(jsonElement, clazz);
    }

}
