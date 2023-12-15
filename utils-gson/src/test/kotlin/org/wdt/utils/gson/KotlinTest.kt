package org.wdt.utils.gson

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
        val list: List<String>? = jsonArray?.parseArray()
        println(list)
    }
}
