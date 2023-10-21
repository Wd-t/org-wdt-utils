import org.junit.jupiter.api.Test;
import org.wdt.utils.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DeletFileTest {
    @Test
    public void deletPomFile() throws IOException {
        File file = new File("D:/Projects/consulo-consulo-3392");
        for (File child : file.listFiles()) {
            deletFile(child);
        }
    }

    public void deletFile(File file) throws IOException {
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                deletFile(child);
            }
        } else if (file.isFile()) {
            if (file.getName().equals("pom.xml")) {
                System.out.println(file);
                FileUtils.delete(file);
            }

        }
    }
}
