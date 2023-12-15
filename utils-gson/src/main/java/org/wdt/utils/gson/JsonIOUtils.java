package org.wdt.utils.gson;

import com.google.gson.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class JsonIOUtils {
    /**
     * This function equivalent to <pre>JsonParser.parseReader(reader)</pre>
     * @param reader is an about json's reader, It can be a json file's reader or String's reader.
     * @exception JsonIOException io exception
     */
    public static JsonElement parseJsonReaderToJsonElement(Reader reader) {
        return JsonParser.parseReader(reader);
    }

    /**
     * This function equivalent to <pre>JsonParser.parseReader(reader).getAsJsonObject()</pre>
     * @param reader is an about json's reader, It can be a json file's reader or String's reader.
     * @exception JsonIOException io exception.
     * @exception IllegalStateException if this element is of another type.
     */
    public static JsonObject parseJsonReaderToJsonObject(Reader reader) {
        return parseJsonReaderToJsonElement(reader).getAsJsonObject();
    }

    /**
     * This function equivalent to <pre>JsonParser.parseReader(reader).getAsJsonArray()</pre>
     * @param reader is an about json's reader, It can be a json file's reader or String's reader.
     * @exception JsonIOException io exception.
     * @exception IllegalStateException if this element is of another type.
     */
    public static JsonArray parseJsonReaderToJsonArray(Reader reader) {
        return parseJsonReaderToJsonElement(reader).getAsJsonArray();
    }

    /**
     * See to {@linkplain #parseJsonReaderToJsonElement(Reader)}
     */
    public static JsonElement parseJsonStreamToJsonElement(InputStream stream) {
        return parseJsonReaderToJsonElement(newInputStreamReader(stream));
    }

    /**
     * See to {@linkplain #parseJsonReaderToJsonObject(Reader)}
     */

    public static JsonObject parseJsonSteamToJsonObject(InputStream stream) {
        return parseJsonReaderToJsonObject(newInputStreamReader(stream));
    }

    /**
     * See to {@linkplain #parseJsonReaderToJsonArray(Reader)}
     */

    public static JsonArray parseJsonSteamToJsonArray(InputStream stream) {
        return parseJsonReaderToJsonArray(newInputStreamReader(stream));
    }

    private static Reader newInputStreamReader(InputStream stream) {
        return new InputStreamReader(stream);
    }
}
