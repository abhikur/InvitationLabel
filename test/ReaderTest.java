import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReaderTest {

    @Test
    public void testReadFile() throws Exception {
        String file = "./resource/Dummy";
        Reader reader = new Reader();
        String content = reader.readFile(file);
        assertEquals(content, "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia\n" +
                              "Melody,Dooley,Female,31,West Shanna,Vermont,Bangladesh");
    }
}