package org.wdt.utils.gson;

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


}
