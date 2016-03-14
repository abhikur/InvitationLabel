import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RecordParserTest {

    @Test
    public void testParse() throws Exception {
        RecordParser recordParser = new RecordParser(new Guests());
        String[] expected = {"Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia","Melody,Dooley,Female,31,West Shanna,Vermont,Bangladesh"};
        assertArrayEquals(recordParser.parse("./resource/Dummy"), expected);

    }
    @Test
    public void DataSplitterShouldSplitTheDataAsPerSplitterGiven() {
        RecordParser recordParser = new RecordParser(new Guests());
        String data = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia";
        String[] expected = {"Julius","Barrows","Female","18","Veda haven","Vermont","Macedonia"};
        assertArrayEquals(recordParser.dataSplitter(data, ","), expected);
    }
}