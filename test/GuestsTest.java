import name.Name;
import name.NameAsFirstLast;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import person.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuestsTest {
    Guests guests;
    Name name;
    Honorific honorific;
    Age age;
    Address address;
    @Before
    public void setup() {
        guests = new Guests();
        name = new NameAsFirstLast("Julius", "Barrows");
        honorific = new Honorific("Female");
        age = new Age("18");
        address= new Address(new City("Veda haven"), new State("Vermont"), new Country("Macedonia"));
        guests.add(new Person(name, age, honorific, address));
    }

    @Test
    public void filterRecordShouldFilterPeopleAccordingToAge() {
        HashMap<String, String> filters = new HashMap<String, String>();
        filters.put("--filterAge", "18");
        List<Person> expected = new ArrayList<Person>();
        expected.add(guests.get(0));
        Assert.assertEquals(expected, guests.filterRecord(filters));
    }

    @Test
    public void filterRecordShouldFilterPeopleAccordingToCountry() {
        HashMap<String, String> filters = new HashMap<String, String>();
        filters.put("--filterCountry", "Macedonia");
        List<Person> expected = new ArrayList<Person>();
        expected.add(guests.get(0));
        Assert.assertEquals(expected, guests.filterRecord(filters));
    }

    @Test
    public void filterRecordShouldGiveEmptyListIfNoMatchFound() {
        HashMap<String, String> filters = new HashMap<String, String>();
        filters.put("--filterCountry", "Qatar");
        List<Person> expected = new ArrayList<Person>();
        Assert.assertEquals(expected, guests.filterRecord(filters));
    }

}