import borderMaker.BorderMaker;
import name.Name;
import name.NameAsFirstLast;
import org.junit.Before;
import org.junit.Test;
import person.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LabelMakerTest {
    private Guests guests = new Guests();
    @Before
    public void setup() {
        Name name = new NameAsFirstLast("Melody", "Dooley");
        Honorific Honorific = new Honorific("Female");
        Age age = new Age("20");
        Address address = new Address(new City("West Shanna"), new State("Vermont"), new Country("Bangladesh"));
        guests.addPerson(name, Honorific, age, address);

    }

    @Test
    public void testGetLabels() throws Exception {
        HashMap<String, String> filters = new HashMap<String, String>();
        filters.put("countryFilter","Bangladesh");
        List<List<String>> expected = new ArrayList<List<String>>();
        List<String> label = Arrays.asList("+----------------------+","| Ms Melody Dooley     |", "|----------------------|", "| West Shanna, Vermont |","| Bangladesh           |","+----------------------+");
        expected.add(label);
        BorderMaker borderMaker = new BorderMaker();
        LabelMaker labelMaker = new LabelMaker(borderMaker);
        labelMaker.makeLabelForGuests(guests.filterRecord(filters));
        assertEquals(labelMaker.getLabels(), expected);
    }
}