import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ArgsFilterTest {

    @Test
    public void testFilterWhenOnlyCountryIsPassed() throws Exception {
        ArgsFilter argsFilter = new ArgsFilter();
        String[] arguments = {"--countryFilter_India"};
        HashMap<String, String> filteredArgs = argsFilter.filter(arguments);
        assertEquals(filteredArgs.get("countryFilter"), "India");
    }

    @Test
    public void testFilterWhenOnlyAgeIsPassed() throws Exception {
        ArgsFilter argsFilter = new ArgsFilter();
        String[] arguments = {"--ageFilter_20"};
        HashMap<String, String> filteredArgs = argsFilter.filter(arguments);
        assertEquals(filteredArgs.get("ageFilter"), "20");
    }

    @Test
    public void testFilterWhenBothCountryAndAgeIsPassed() throws Exception {
        ArgsFilter argsFilter = new ArgsFilter();
        String[] arguments = {"--countryFilter_India","--ageFilter_20"};
        HashMap<String, String> filteredArgs = argsFilter.filter(arguments);
        assertEquals(filteredArgs.get("countryFilter"), "India");
        assertEquals(filteredArgs.get("ageFilter"), "20");
    }
}