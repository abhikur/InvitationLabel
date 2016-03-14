import name.Name;
import name.NameAsFirstLast;
import name.NameAsLastFirst;
import org.junit.Test;
import person.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class GuestsTest {

    @Test
    public void testGetLabelNameAsFirstLast() throws Exception {
        Guests guests = new Guests();
        Name name = new NameAsFirstLast("Julius", "Barrows");
        Prefix prefixForJulius = new Prefix("Female");
        Age juliusAge = new Age("18");
        Address juliusAddress = new Address(new City("Veda haven"), new State("Vermont"), new Country("Macedonia"));

        HashMap<String, String> filters = new HashMap<String, String>();
        filters.put("countryFilter","Macedonia");
        filters.put("ageFilter","15");

        List<List<List<String>>> expected = new ArrayList<List<List<String>>>();
        List<List<String>> fields = asList(asList("Ms Julius Barrows"), asList("Veda haven, Vermont", "Macedonia"));
        expected.add(fields);

        guests.addPerson(name, prefixForJulius, juliusAge, juliusAddress);
        List<Person> filteredGuest = guests.filterRecord(filters);
        assertEquals(guests.fieldsForLabel(filteredGuest), expected);
    }

    @Test
    public void testGetLabelNAmeAsLastFirst() throws Exception {
        Guests guests = new Guests();
        Name name = new NameAsLastFirst("Julius", "Barrows");
        Prefix prefixForJulius = new Prefix("Female");
        Age juliusAge = new Age("18");
        Address juliusAddress = new Address(new City("Veda haven"), new State("Vermont"), new Country("Macedonia"));

        HashMap<String, String> filters = new HashMap<String, String>();
        filters.put("countryFilter","Macedonia");
        filters.put("ageFilter","15");

        List<List<List<String>>> expected = new ArrayList<List<List<String>>>();
        List<List<String>> fields = asList(asList("Ms Barrows, Julius"), asList("Veda haven, Vermont", "Macedonia"));
        expected.add(fields);

        guests.addPerson(name, prefixForJulius, juliusAge, juliusAddress);
        List<Person> filteredGuest = guests.filterRecord(filters);
        assertEquals(guests.fieldsForLabel(filteredGuest), expected);
    }
}