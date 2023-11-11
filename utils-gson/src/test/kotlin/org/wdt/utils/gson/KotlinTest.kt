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
