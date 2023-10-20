package org.wdt.utils.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.List;

public class FileUtils {
    public static String readFileToString(File file) throws IOException {
        return PathUtils.readFileToString(file.toPath());
    }

    public static void writeStringToFile(File file, String s) throws IOException {
        PathUtils.writeStringToFile(file.toPath(), s);
    }

    public static void touch(File file) throws IOException {
        PathUtils.touch(file.toPath());
    }

    public static List<String> readFileToLines(File file) throws IOException {
        return PathUtils.readFileToLines(file.toPath());
    }

    public static void delete(File file) throws IOException {
        PathUtils.delete(file.toPath());
    }

    public static void cleanDirectory(File file) throws IOException {
        ckeckIsDirectory(file);
        PathUtils.cleanDirectory(file.toPath());
    }


    public static long sizeOfDirectory(File file) throws IOException {
        ckeckIsDirectory(file);
        return PathUtils.sizeOfDirectory(file.toPath());
    }

    public static void deleteDirectory(File file) throws IOException {
        ckeckIsDirectory(file);
        PathUtils.deleteDirectory(file.toPath());
    }

    public static void copyFile(File srcFile, File file) throws IOException {
        Files.copy(Files.newInputStream(srcFile.toPath()), file.toPath());
    }


    public static InputStream newInputStream(File file) throws IOException {
        return Files.newInputStream(file.toPath());
    }

    public static OutputStream newOutputStream(File file) throws IOException {
        return Files.newOutputStream(file.toPath());
    }

    public static void createDirectories(File file) throws IOException {
        ckeckIsDirectory(file);
        Files.createDirectories(file.toPath());
    }

    public static String getCanonicalPath(File file) {
        try {
            return file.getCanonicalPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isFileOlder(File file, Date date) throws IOException {
        return isFileOlder(file, date.getTime());
    }

    public static boolean isFileOlder(File file, long l) throws IOException {
        return Files.getLastModifiedTime(file.toPath()).compareTo(FileTime.fromMillis(l)) < 0;
    }


    public static void ckeckIsDirectory(File file) throws IOException {
        if (!file.isDirectory()) {
            throw new IOException("This File isn't Directory");
        }
    }

    public static boolean isFileNotExists(File file) throws IOException {
        return PathUtils.isFileNotExists(file.toPath());
    }

    public static boolean isFileExists(File file) {
        return PathUtils.isFileExists(file.toPath());
    }

    public static boolean isFileNotExistsAndIsNotSameSize(File file, long l) throws IOException {
        return PathUtils.isFileNotExistsAndIsNotSameSize(file.toPath(), l);
    }

    public static File toFile(String s) {
        return new File(s);
    }

    public static File toFile(String parent, String child) {
        return new File(toFile(parent), child);
    }

    public static File toFile(File parent, String child) {
        return new File(parent, child);
    }

    public static String getFileSha1(File file) throws IOException {
        return IOUtils.getInputStreamSha1(newInputStream(file));
    }

    public static long sizeOf(File file) throws IOException {
        return PathUtils.sizeOf(file.toPath());
    }
}
