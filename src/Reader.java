import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Reader {
    public String readFile(String file) throws IOException {
        Path path = Paths.get(file);
        return new String(Files.readAllBytes(path));
    }
}
