package org.wdt.utils.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.wdt.utils.gson.typeadapter.FileTypeAdapter;

import java.io.File;

public class Json {
    public static final Gson GSON = getBuilder().create();
    public static final GsonBuilder GSON_BUILDER = getBuilder();

    public static GsonBuilder getBuilder() {
        return new GsonBuilder().disableHtmlEscaping().registerTypeAdapter(File.class, new FileTypeAdapter());
    }

    public static String toJsonString(Object o) {
        return GSON.toJson(o);
    }
}
