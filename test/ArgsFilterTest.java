import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ArgsFilterTest {

    @Test
    public void testFilterWhenOnlyCountryIsPassed() throws Exception {
        String[] arguments = {"--filterCountry_India"};
        ArgsFilter argsFilter = new ArgsFilter(arguments);
        HashMap<String, String> filteredArgs = argsFilter.filter();
        assertEquals(filteredArgs.get("--filterCountry"), "India");
    }

    @Test
    public void testFilterWhenOnlyAgeIsPassed() throws Exception {
        String[] arguments = {"--filterAge_20"};
        ArgsFilter argsFilter = new ArgsFilter(arguments);
        HashMap<String, String> filteredArgs = argsFilter.filter();
        assertEquals(filteredArgs.get("--filterAge"), "20");
    }

    @Test
    public void testFilterWhenOnlyFileIsPassed() throws Exception {
        String[] arguments = {"Dummy.txt"};
        ArgsFilter argsFilter = new ArgsFilter(arguments);
        HashMap<String, String> filteredArgs = argsFilter.filter();
        assertEquals(filteredArgs.get("file"), "Dummy.txt");
    }

    @Test
    public void testFilterWhenCountryAndAgeIsPassed() throws Exception {
        String[] arguments = {"--filterCountry_India","--filterAge_20"};
        ArgsFilter argsFilter = new ArgsFilter(arguments);
        HashMap<String, String> filteredArgs = argsFilter.filter();
        assertEquals(filteredArgs.get("--filterCountry"), "India");
        assertEquals(filteredArgs.get("--filterAge"), "20");
    }

    @Test
    public void testFilterWhenCountryAndFileIsPassed() throws Exception {
        String[] arguments = {"--filterCountry_India","Dummy"};
        ArgsFilter argsFilter = new ArgsFilter(arguments);
        HashMap<String, String> filteredArgs = argsFilter.filter();
        assertEquals(filteredArgs.get("--filterCountry"), "India");
        assertEquals(filteredArgs.get("file"), "Dummy");
    }

    @Test
    public void testFilterWhenCountryAgeAndFileIsPassed() throws Exception {
        String[] arguments = {"--filterCountry_India","Dummy","--filterAge_20"};
        ArgsFilter argsFilter = new ArgsFilter(arguments);
        HashMap<String, String> filteredArgs = argsFilter.filter();
        assertEquals(filteredArgs.get("--filterCountry"), "India");
        assertEquals(filteredArgs.get("--filterAge"), "20");
        assertEquals(filteredArgs.get("file"), "Dummy");
    }

    @Test
    public void isNeedHelpShouldReturnFalseIfArgsAreBetweenTwoAndFour() {
        String[] args = {"-fl", "records", "--filterAge_20"};
        ArgsFilter argsFilter = new ArgsFilter(args);
        assertFalse(argsFilter.isNeedHelp());
    }

    @Test
    public void isNeedHelpShouldReturnTrueIfArgsAreLessThanTwo() {
        String[] args = {"-fl"};
        ArgsFilter argsFilter = new ArgsFilter(args);
        assertTrue(argsFilter.isNeedHelp());
    }
}