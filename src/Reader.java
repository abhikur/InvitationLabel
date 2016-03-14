import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public String readFile(String file) throws IOException {
        File fileName = new File(file);
        FileReader reader = new FileReader(fileName);
        char[] content = new char[(int) fileName.length()];
        reader.read(content,0, (int) fileName.length());
        return new String(content);
    }
}
