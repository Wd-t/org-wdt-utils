# utils-gson

### 使让用惯FastJson的人转向Gson更加舒服

- 只是把一些在FastJson上常用的函数用Kotlin在Gson上拓展了

#### 以前:

```java
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

```

#### 现在:

```kotlin
package org.wdt.utils.gson

import kotlin.test.Test

class KotlinTest {
    @Test
    fun testJsonForJava() {
        val jsonStr = """
            {
                "Hello": "World"
            }
        """.trimIndent()
        val testJsonObject = JsonObjectUtils.parseObject(jsonStr)
        println(testJsonObject.getString("Hello"))
    }
}

```
