package org.wdt.utils.io

import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
import java.io.StringReader
import java.net.URL

fun InputStream.toStrings(): String {
    return IOUtils.toString(this)
}

fun InputStream.readLines(): List<String> {
    return IOUtils.readLines(this)
}

fun Reader.readLines(): List<String> {
    return IOUtils.readLines(this)
}

fun Reader.toStrings(): String {
    return IOUtils.toString(this)
}

fun URL.toStrings(): String {
    return IOUtils.toString(this)
}

fun InputStream.getSha1(): String {
    return IOUtils.getInputStreamSha1(this)
}

fun String.toReader(): StringReader {
    return StringReader(this)
}

fun InputStream.toReader(): InputStreamReader {
    return InputStreamReader(this)
}