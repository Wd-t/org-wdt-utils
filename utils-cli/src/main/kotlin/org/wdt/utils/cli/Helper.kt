package org.wdt.utils.cli

import kotlin.system.exitProcess

class Helper(private val listIterator: HashSet<Option>) {
  fun printHelp() {
    val stringBuilder = StringBuilder("Usage <this> <option> <arg>:\n")
    stringBuilder.append("Options:\n")
    listIterator.forEach {
      stringBuilder.append("\t").append("-${it.shortName}/--${it.fullName}, Has arg: ${it.hasArgs}\n")
    }
    println(stringBuilder)
    exitProcess(0)
  }
}