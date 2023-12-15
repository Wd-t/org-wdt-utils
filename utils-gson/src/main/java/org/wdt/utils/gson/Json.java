package org.wdt.utils.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.wdt.utils.gson.typeadapter.DateTypeAdapter;
import org.wdt.utils.gson.typeadapter.FileTypeAdapter;

import java.io.File;
import java.util.Date;

public class Json {
    public static final Gson GSON = getBuilder().create();
    public static final GsonBuilder GSON_BUILDER = getBuilder();

    public static GsonBuilder getBuilder() {
        return new GsonBuilder().disableHtmlEscaping().registerTypeAdapter(File.class, new FileTypeAdapter())
                .registerTypeAdapter(Date.class, new DateTypeAdapter());
    }

    public static String toJsonString(Object o) {
        return toJsonString(o, GSON.newBuilder());
    }

    public static String toJsonString(Object o, GsonBuilder builder) {
        return builder.create().toJson(o);
    }

}
