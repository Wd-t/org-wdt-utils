package org.wdt.utils.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.List;

public class PathUtils {
    public static String readFileToString(Path FilePath) throws IOException {
        return IOUtils.toString(Files.newBufferedReader(FilePath));
    }

    public static void writeStringToFile(Path path, String s) throws IOException {
        touch(path);
        IOUtils.write(Files.newBufferedWriter(path), s);
    }

    public static void touch(Path path) throws IOException {
        if (!Files.exists(path)) {
            Files.createDirectories(path.getParent());
            Files.createFile(path);
        } else {
            Files.setLastModifiedTime(path, FileTime.from(Instant.now()));
        }
    }

    public static List<String> readFileToLines(Path path) throws IOException {
        return IOUtils.readLines(Files.newBufferedReader(path));
    }

    public static void delete(Path path) throws IOException {
        if (Files.exists(path)) {
            Files.delete(path);
        }
    }

    public static long sizeOf(Path path) throws IOException {
        return Files.size(path);
    }

    public static void cleanDirectory(Path path) throws IOException {
        ckeckIsDirectory(path);
        for (Path path1 : Files.newDirectoryStream(path)) {
            if (Files.isDirectory(path1)) {
                cleanDirectory(path1);
                deleteDirectory(path1);
            } else {
                delete(path1);
            }
        }
    }

    public static void deleteDirectory(Path path) throws IOException {
        ckeckIsDirectory(path);
        cleanDirectory(path);
        delete(path);
    }


    public static long sizeOfDirectory(Path path) throws IOException {
        ckeckIsDirectory(path);
        long dirSize = 0;
        for (Path path1 : Files.list(path).toList()) {
            if (Files.isDirectory(path1)) {
                sizeOfDirectory(path1);
            } else {
                dirSize = PathUtils.sizeOf(path1);
            }
        }
        return dirSize;
    }

    public static boolean isFileExists(Path path) {
        return Files.exists(path);
    }

    public static boolean isFileNotExists(Path path) {
        return Files.notExists(path);
    }

    public static boolean isFileNotExistsAndIsNotSameSize(Path path, long l) throws IOException {
        return isFileNotExists(path) && sizeOf(path) != l;
    }

    public static void ckeckIsDirectory(Path path) throws IOException {
        if (!Files.isDirectory(path)) {
            throw new IOException("This File isn't Directory");
        }
    }

    public static String getFileSha1(Path path) throws IOException {
        return IOUtils.getInputStreamSha1(Files.newInputStream(path));
    }

}
