package org.wdt.utils.gson;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;

public class TestJava {
    @Test
    public void testJsonForJava() {
        String jsonStr = """
                    {
                        "Hello": "World"
                    }
                """;
        JsonObject testJsonObject = JsonParser.parseString(jsonStr).getAsJsonObject();
        System.out.println(testJsonObject.get("Hello").getAsString());
        // Out : World
    }
}
