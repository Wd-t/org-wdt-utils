package org.wdt.utils.io

import java.nio.file.Path

fun Path.readFileToString(): String {
    return PathUtils.readFileToString(this)
}

fun Path.writeStringToFile(string: String) {
    PathUtils.writeStringToFile(this, string)
}

fun Path.writeStringToFile(string: String, boolean: Boolean) {
    PathUtils.writeStringToFile(this, string, boolean)
}

fun Path.touch() {
    PathUtils.touch(this)
}

fun Path.readFileToLines(): List<String> {
    return PathUtils.readFileToLines(this)
}

fun Path.delete() {
    PathUtils.delete(this)
}

fun Path.sizeOf(): Long {
    return PathUtils.sizeOf(this)
}

fun Path.cleanDirectory() {
    PathUtils.cleanDirectory(this)
}

fun Path.deleteDirectory() {
    PathUtils.deleteDirectory(this)
}

fun Path.sizeOfDirectory(): Long {
    return PathUtils.sizeOfDirectory(this)
}

fun Path.isFileExists(): Boolean {
    return PathUtils.isFileExists(this)
}

fun Path.isFileNotExistsAndIsNotSameSize(long: Long): Boolean {
    return PathUtils.isFileNotExistsAndIsNotSameSize(this, long)
}

fun Path.createDirectories() {
    PathUtils.createDirectories(this)
}

fun Path.getExtension(): String {
	return FilenameUtils.getExtension(this.toFile().canonicalPath)
}
fun Path.getFileSha1(): String {
    return PathUtils.getFileSha1(this)
}