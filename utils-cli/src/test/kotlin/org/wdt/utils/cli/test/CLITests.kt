package org.wdt.utils.cli.test

import org.wdt.utils.cli.ArgParse
import org.wdt.utils.cli.ArgParseConfig
import org.wdt.utils.cli.Option
import kotlin.test.Test

class CLITests {
    @Test
    fun test() {
        val a = ArgParse(
            arrayOf("-a", "123"),
            ArgParseConfig(mustHaveAction = true, errorThrowingException = true, autoStartAction = true)
        )
        val option = Option("asdaa", "a", hasArgs = true) {
            println(it)
        }
        a.addOptions(option)
        a.parse()
    }
}