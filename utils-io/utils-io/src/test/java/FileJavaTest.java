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
