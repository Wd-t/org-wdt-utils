package org.wdt.utils.io.okio

import okio.FileSystem
import okio.Path.Companion.toOkioPath
import java.io.File
import java.nio.file.Files

fun File.readFileToString(): String {
    return fileSystem.read(toOkioPath()) {
        readUtf8()
    }
}

fun File.deleteFile() {
    fileSystem.delete(toOkioPath(), false)
}

fun File.writeStringToFile(string: String) {
    return fileSystem.write(toOkioPath()) {
        writeUtf8(string)
    }
}

fun File.touch() {
    fileSystem.createDirectories(toOkioPath().parent!!)
    Files.createFile(toPath())
}

fun File.readFileToLine(): List<String> {
    return bufferedReader().lines().toList()
}

fun File.sizeOf(): Long {
    return fileSystem.metadata(toOkioPath()).size!!
}

fun File.deleteDirectory() {
    return fileSystem.deleteRecursively(toOkioPath(), false)
}


fun File.createDirectories() {
    fileSystem.createDirectories(toOkioPath())
}

fun File.copyFile(file: File) {
    fileSystem.copy(toOkioPath(), file.toOkioPath())
}

fun File.sizeOfDirectory(): Long {
    return fileSystem.metadata(toOkioPath()).size!!
}

fun File.isFileExists(): Boolean {
    return fileSystem.exists(toOkioPath())
}

fun File.isFileNotExists(): Boolean {
    return !isFileExists()
}

fun File.sha1(): String {
    return fileSystem.read(toOkioPath()) {
        readByteString().sha1().hex()
    }
}

fun String.toFile(): File {
    return File(this)
}

fun String.toFile(child: String): File {
    return File(this, child)
}

fun File.toFile(child: String): File {
    return File(this, child)
}

internal val fileSystem = FileSystem.SYSTEM