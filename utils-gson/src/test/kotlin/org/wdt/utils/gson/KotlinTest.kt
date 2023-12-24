package org.wdt.utils.gson

import com.google.gson.JsonObject
import java.io.File
import java.io.StringReader
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

    @Test
    fun testJsonArray() {
        val jsonArray = KotlinTest::class.java.getResourceAsStream("/test.json")?.parseJsonStreamToJsonObject()
            ?.getJsonArray("array")
        val reader = StringReader(
            """
             {
                "Hello": "World"
            }
        """.trimIndent()
        )
        println(reader.parseReaderToJsonObject().getString("Hello"))
        println(jsonArray?.ckeckIndex(1))
    }

    @Test
    fun testWriteFile() {
        val jsonObject = JsonObject()
        jsonObject.addProperty("hello", "world")
        val file = File("./json.json")
        file.writeObjectToFile(jsonObject)
    }
}
