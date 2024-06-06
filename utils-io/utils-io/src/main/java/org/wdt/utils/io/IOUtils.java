package org.wdt.utils.io;

import java.io.*;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

public class IOUtils {
  public static String toString(InputStream inputStream) throws IOException {
    return toString(new InputStreamReader(inputStream));
  }

  public static void copy(Reader reader, Writer writer) throws IOException {
    char[] array = new char[100];
    int n;
    while (-1 != (n = reader.read(array))) {
      writer.write(array, 0, n);
    }
    reader.close();
    writer.close();
  }

  public static String toString(Reader reader) throws IOException {
    try (StringWriter stringWriter = new StringWriter()) {
      copy(reader, stringWriter);
      return stringWriter.toString();
    }
  }

  public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
    int m;
    byte[] data = new byte[1024];
    while ((m = inputStream.read(data, 0, 1024)) >= 0) {
      outputStream.write(data, 0, m);
    }
    inputStream.close();
    outputStream.close();
  }

  public static void write(Writer writer, String s) throws IOException {
    writer.write(s);
    writer.close();
  }

  public static List<String> readLines(Reader reader) {
    try (BufferedReader bufferedReader = new BufferedReader((reader))) {
      return bufferedReader.lines().collect(Collectors.toList());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static List<String> readLines(InputStream inputStream) {
    return readLines(new InputStreamReader(inputStream));
  }

  public static String toString(URL url) throws IOException {
    return toString(url.openStream());
  }

  public static String getInputStreamSha1(InputStream stream) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-1");
      byte[] buffer = new byte[1024 * 1024 * 10];
      int len;
      while ((len = stream.read(buffer)) > 0) {
        digest.update(buffer, 0, len);
      }
      stream.close();
      StringBuilder sha1 = new StringBuilder(new BigInteger(1, digest.digest()).toString(16));
      int length = 40 - sha1.length();
      if (length > 0) {
        for (int i = 0; i < length; i++) {
          sha1.insert(0, "0");
        }
      }
      return sha1.toString();
    } catch (IOException | NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

}
