import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ArgsFilterTest {

    @Test
    public void testFilterWhenOnlyCountryIsPassed() throws Exception {
        String[] arguments = {"--countryFilter_India"};
        ArgsFilter argsFilter = new ArgsFilter(arguments);
        HashMap<String, String> filteredArgs = argsFilter.filter();
        assertEquals(filteredArgs.get("countryFilter"), "India");
    }

    @Test
    public void testFilterWhenOnlyAgeIsPassed() throws Exception {
        String[] arguments = {"--ageFilter_20"};
        ArgsFilter argsFilter = new ArgsFilter(arguments);
        HashMap<String, String> filteredArgs = argsFilter.filter();
        assertEquals(filteredArgs.get("ageFilter"), "20");
    }

    @Test
    public void testFilterWhenOnlyFileIsPassed() throws Exception {
        String[] arguments = {"--file_Dummy.txt"};
        ArgsFilter argsFilter = new ArgsFilter(arguments);
        HashMap<String, String> filteredArgs = argsFilter.filter();
        assertEquals(filteredArgs.get("fileFilter"), "Dummy.txt");
    }

    @Test
    public void testFilterWhenCountryAndAgeIsPassed() throws Exception {
        String[] arguments = {"--countryFilter_India","--ageFilter_20"};
        ArgsFilter argsFilter = new ArgsFilter(arguments);
        HashMap<String, String> filteredArgs = argsFilter.filter();
        assertEquals(filteredArgs.get("countryFilter"), "India");
        assertEquals(filteredArgs.get("ageFilter"), "20");
    }

    @Test
    public void testFilterWhenCountryAndFileIsPassed() throws Exception {
        String[] arguments = {"--countryFilter_India","--file_Dummy"};
        ArgsFilter argsFilter = new ArgsFilter(arguments);
        HashMap<String, String> filteredArgs = argsFilter.filter();
        assertEquals(filteredArgs.get("countryFilter"), "India");
        assertEquals(filteredArgs.get("fileFilter"), "Dummy");
    }

    @Test
    public void testFilterWhenCountryAgeAndFileIsPassed() throws Exception {
        String[] arguments = {"--countryFilter_India","--file_Dummy","--ageFilter_20"};
        ArgsFilter argsFilter = new ArgsFilter(arguments);
        HashMap<String, String> filteredArgs = argsFilter.filter();
        assertEquals(filteredArgs.get("countryFilter"), "India");
        assertEquals(filteredArgs.get("ageFilter"), "20");
        assertEquals(filteredArgs.get("fileFilter"), "Dummy");
    }

    @Test
    public void isNeedHelpShouldReturnFalseIfArgsAreBetweenTwoAndFour() {
        String[] args = {"-fl", "--file_records", "--ageFilter_20"};
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