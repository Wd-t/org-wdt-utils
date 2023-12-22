package org.wdt.utils.gson;

import com.google.gson.*;

import java.io.*;

public class JsonUtils {

    public static JsonObject readFileToJsonObject(File jsonFile) throws IOException {
        return JsonObjectUtils.parseJsonObject(jsonFile);
    }

    public static JsonArray readFileToJsonArray(File jsonFile) throws IOException {
        return JsonArrayUtils.parseJsonArray(jsonFile);
    }

    public static JsonElement readFileToJsonElement(File jsonFile) throws IOException {
        return JsonIOUtils.parseJsonReaderToJsonElement(newJsonFileReader(jsonFile));
    }


    public static <T> T readFileToClass(File jsonFile, Class<T> clazz) throws IOException {
        return JsonObjectUtils.parseObject(readFileToJsonElement(jsonFile), clazz);
    }
    public static <T> T readFileToClass(File jsonFile, Class<T> clazz, GsonBuilder builder) throws IOException {
        return JsonObjectUtils.parseObject(readFileToJsonElement(jsonFile), clazz, builder);
    }

    public static void writeObjectToFile(File jsonFile, Object o) throws IOException {
        writeObjectToFile(jsonFile, o, Json.GSON.newBuilder());
    }

    public static void writeObjectToFile(File jsonFile, Object o, GsonBuilder builder) throws IOException {
        FileWriter writer = new FileWriter(jsonFile);
        writer.write(builder.create().toJson(o));
        writer.close();
    }

    public static JsonElement parseJsonElement(String jsonStr) {
        return JsonParser.parseString(jsonStr);
    }


    public static FileReader newJsonFileReader(File jsonFile) throws FileNotFoundException {
        return new FileReader(jsonFile);
    }

}
