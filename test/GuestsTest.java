import org.junit.Test;
import name.Name;
import name.NameAsFirstLast;
import name.NameAsLastFirst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GuestsTest {

    @Test
    public void testGetLabelNameAsFirstLast() throws Exception {
        Guests guests = new Guests();
        Name name = new NameAsFirstLast("Julius", "Barrows");
        Prefix prefixForJulius = new Prefix("Female");
        Age juliusAge = new Age("18");
        Address juliusAddress = new Address("Veda haven", "Vermont", "Macedonia");

        HashMap<String, String> filters = new HashMap<>();
        filters.put("countryFilter","Macedonia");
        filters.put("ageFilter","15");

        List<String> expected = new ArrayList<>();
        expected.add("Ms Julius Barrows, Macedonia, 18");

        guests.addPerson(name, prefixForJulius, juliusAge, juliusAddress);
        List<Person> filteredGuest = guests.filterRecord(filters);
        assertEquals(guests.makeLabel(filteredGuest), expected);
    }

    @Test
    public void testGetLabelNAmeAsLastFirst() throws Exception {
        Guests guests = new Guests();
        Name name = new NameAsLastFirst("Julius", "Barrows");
        Prefix prefixForJulius = new Prefix("Female");
        Age juliusAge = new Age("18");
        Address juliusAddress = new Address("Veda haven", "Vermont", "Macedonia");

        HashMap<String, String> filters = new HashMap<>();
        filters.put("countryFilter","Macedonia");
        filters.put("ageFilter","15");

        List<String> expected = new ArrayList<>();
        expected.add("Ms Barrows, Julius, Macedonia, 18");

        guests.addPerson(name, prefixForJulius, juliusAge, juliusAddress);
        List<Person> filteredGuest = guests.filterRecord(filters);
        assertEquals(guests.makeLabel(filteredGuest), expected);
    }
}