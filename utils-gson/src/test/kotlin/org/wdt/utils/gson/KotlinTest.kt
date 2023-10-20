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
