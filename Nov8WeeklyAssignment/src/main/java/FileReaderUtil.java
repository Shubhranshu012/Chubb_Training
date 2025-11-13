import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileReaderUtil {

    public static List<String> readFile(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + path, e);
        }
    }
}
