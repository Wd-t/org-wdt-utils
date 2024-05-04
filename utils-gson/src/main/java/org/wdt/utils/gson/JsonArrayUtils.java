package org.wdt.utils.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.IOException;

public class JsonArrayUtils {
  public static JsonArray parseJsonArray(String jsonString) {
    return JsonParser.parseString(jsonString).getAsJsonArray();
  }

  public static JsonArray parseJsonArray(File jsonFile) throws IOException {
    return JsonUtils.readFileToJsonElement(jsonFile).getAsJsonArray();
  }
}
