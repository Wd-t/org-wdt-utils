package org.wdt.utils.cli

import kotlin.system.exitProcess

class ArgParse(
    private val args: Array<String>,
    private val config: ArgParseConfig = ArgParseConfig(),
) {
    private val optionsList = HashSet<Option>()
    val optionValueMap = HashMap<Option, String?>()
    fun parse() {
        val shortNameList = optionsList.map { it.shortName }
        val fullNameList = optionsList.map { it.fullName }
        val listIterator = args.iterator()
        if ("-h" in args || "--help" in args) Helper(optionsList).printHelp()
        parseImpl(listIterator, shortNameList, true)
        parseImpl(listIterator, fullNameList, false)
    }

    private fun parseImpl(
        listIterator: Iterator<String>,
        nameList: List<String>,
        shrotName: Boolean,
    ) {
        val startWith = getStartWith(shrotName)
        while (listIterator.hasNext()) {
            var it = listIterator.next()
            if (it.startsWith(startWith)) {
                it = it.replace(startWith, "")
                if (it in nameList) {
                    val optins = if (shrotName) findShortName(it) else findFullName(it)
                    val arg: String? = if (optins.hasArgs) {
                        try {
                            val s = listIterator.next()
                            if (s.startsWith("-") || s.startsWith("--")) {
                                throwParseException(getNotHaveArgErrorMessage(it), config)
                            }
                            s
                        } catch (_: NoSuchElementException) {
                            throwParseException(getNotHaveArgErrorMessage(it), config)
                        }
                    } else {
                        null
                    }
                    putOptionToMap(optins, arg)
                }
            }
        }
    }

    private fun getNotHaveArgErrorMessage(name: String): String {
        return "$name must have arg!"
    }

    private fun startAction(option: Option) {
        if (!config.autoStartAction) return
        if (config.mustHaveAction) {
            if (option.action == null) {
                throwParseException("${option.shortName} key must have action", config)
            }
        }
        option.action?.invoke(getValue(option))
    }


    private fun getStartWith(shortName: Boolean): String {
        return if (shortName) "-" else "--"
    }

    private fun findShortName(shortName: String): Option {
        optionsList.forEach {
            if (shortName == it.shortName) {
                return it
            }
        }
        throwParseException("Not has $shortName options", config)
    }

    private fun findFullName(fullName: String): Option {
        optionsList.forEach {
            if (fullName == it.fullName) {
                return it
            }
        }
        throwParseException("Not has $fullName options", config)
    }


    fun getValue(option: Option): String? {
        return optionValueMap[option]
    }

    fun hasOption(option: Option): Boolean {
        return option in optionValueMap.keys
    }


    private fun putOptionToMap(option: Option, arg: String?) {
        optionValueMap[option] = arg
        startAction(option)
    }

    fun addOptions(option: Option) {
        optionsList.add(option)
    }
}

fun throwParseException(message: String, config: ArgParseConfig = ArgParseConfig()): Nothing {
    if (config.errorThrowingException) {
        throw ParseException(message)
    } else {
        System.err.println(message)
        exitProcess(2)
    }
}


class ArgParseConfig(
    var mustHaveAction: Boolean = false,
    var errorThrowingException: Boolean = true,
    var autoStartAction: Boolean = false,
)