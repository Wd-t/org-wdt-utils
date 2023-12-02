# utils-io

## 文件方面的封装库
-----

## e.g.

#### Java:

```text
import org.wdt.utils.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileJavaTest {
    public static void main(String[] args) throws IOException {
        File file = new File("./Test.txt");
        // Test.txt : Hello World
        System.out.println(FileUtils.readFileToString(file));
        // Out : Hello World
    }
}

```

#### Kotlin:

```text
import org.wdt.utils.io.readFileToString
import org.wdt.utils.io.toFile

fun main() {
	val file = "./Test.txt".toFile()
	// Test.txt : Hello World
	println(file.readFileToString())
	// Out : Hello World
}

```