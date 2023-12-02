# utils-gson

### 使让用惯FastJson的人转向Gson更加舒服

- 只是把一些在FastJson上常用的函数用Kotlin在Gson上拓展了

#### Java:

```text
package org.wdt.utils.gson;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

public class TestJava {
    @Test
    public void testJsonForJava() {
        String jsonStr = " {\"Hello\": \"World\"}";
        JsonObject testJsonObject = JsonObjectUtils.parseJsonObject(jsonStr);
        System.out.println(testJsonObject.get("Hello").getAsString());
        // Out : World
    }
}
```

#### Kotlin:

```text
package org.wdt.utils.gson

import kotlin.test.Test

class KotlinTest {
    @Test
    fun testJsonForKotlin() {
        val jsonStr = """
            {
                "Hello": "World"
            }
        """.trimIndent()
        val testJsonObject = jsonStr.parseJsonObject()
        println(testJsonObject.getString("Hello"))
    }
}


```
