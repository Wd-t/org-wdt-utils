package org.wdt.utils.io.okio

import okio.BufferedSource
import okio.ByteString.Companion.encodeUtf8
import okio.buffer
import okio.source
import java.io.InputStream

fun InputStream.toBufferedSource(): BufferedSource = source().buffer()

fun BufferedSource.sha1(): String = readByteString().sha1().hex()

fun String.base64(): String = encodeUtf8().base64()