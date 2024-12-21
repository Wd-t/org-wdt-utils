package org.wdt.utils.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.wdt.utils.gson.typeadapter.DateTypeAdapter;
import org.wdt.utils.gson.typeadapter.FileTypeAdapter;

import java.io.File;
import java.util.Date;

public class Json {

  public static GsonBuilder GSON_BUILDER = new GsonBuilder().disableHtmlEscaping().registerTypeAdapter(File.class, new FileTypeAdapter())
    .registerTypeAdapter(Date.class, new DateTypeAdapter());

  public static Gson GSON = GSON_BUILDER.create();

  public static GsonBuilder getBuilder() {
    return GSON_BUILDER;
  }

  public static <T> String toJsonString(T o) {
    return toJsonString(o, GSON_BUILDER);
  }

  public static <T> String toJsonString(T o, GsonBuilder builder) {
    return builder.create().toJson(o, o.getClass());
  }

}