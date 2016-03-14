package borderMaker;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class BorderMakerTest {
    public List<List<String>> fields;
    BorderMaker borderMaker;

    @Before
    public void setup() {
        borderMaker = new BorderMaker();
        fields = asList(asList("Ms Julius Barrows"), asList("Veda haven,Vermont", "Macedonia"));
    }

    @Test
    public void BorderShouldGiveExpectedBorderForName() {
        String toFill = "Ms Julius";
        String expected = "| Ms Julius |";
        assertEquals(expected, borderMaker.border("|", toFill, toFill.length()));
        assertEquals("abc", "abc");
    }

    @Test
    public void BorderShouldGiveExpectedBorderForDashes() {
        String expected = "|-----------|";
        assertEquals(expected, borderMaker.border("|", '-', 9));
        assertEquals("abc", "abc");
    }

    @Test
    public void testSetBorderForTheGivenField() throws Exception {
        BorderMaker borderMaker = new BorderMaker();
        String expected = "+--------------------+\n"+
                          "| Ms Julius Barrows  |\n"+
                          "|--------------------|\n"+
                          "| Veda haven,Vermont |\n"+
                          "| Macedonia          |\n"+
                          "+--------------------+";
        assertEquals(borderMaker.setBorder(fields), expected);
    }
}