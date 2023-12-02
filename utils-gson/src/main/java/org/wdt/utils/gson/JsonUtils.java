package org.wdt.utils.gson;

import com.google.gson.*;
import org.wdt.utils.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class JsonUtils {

    public static JsonObject readFileToJsonObject(File jsonFile) throws IOException {
        return JsonObjectUtils.parseJsonObject(FileUtils.readFileToString(jsonFile));
    }

    public static JsonArray readFileToJsonArray(File jsonFile) throws IOException {
        return JsonArrayUtils.parseJsonArray(FileUtils.readFileToString(jsonFile));
    }

    public static JsonElement readFileToJsonElement(File jsonFile) throws IOException {
        return parseJsonElement(FileUtils.readFileToString(jsonFile));
    }


    public static <T> T readFileToClass(File jsonFile, Class<T> clazz) throws IOException {
        return JsonObjectUtils.parseObject(FileUtils.readFileToString(jsonFile), clazz);
    }

    public static void writeObjectToFile(File jsonFile, Object o) throws IOException {
        writeObjectToFile(jsonFile, o, Json.GSON.newBuilder());
    }

    public static void writeObjectToFile(File jsonFile, Object o, GsonBuilder builder) throws IOException {
        FileUtils.writeStringToFile(jsonFile, builder.create().toJson(o));
    }

    public static JsonElement parseJsonElement(String jsonStr) {
        return JsonParser.parseString(jsonStr);
    }
}
