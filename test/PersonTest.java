import name.Name;
import name.NameAsFirstLast;
import org.junit.Before;
import org.junit.Test;
import person.*;

import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonTest {
    public Name name;
    public Age age;
    public Prefix prefix;
    public Address address;
    public HashMap<String,String> filters = new HashMap<String, String>();
    @Before
    public void setup() {
        name = new NameAsFirstLast("Julius", "Barrows");
        age = new Age("20");
        prefix = new Prefix("Female");
        City city = new City("Macedonia");
        State state = new State("Vegas");
        Country country = new Country("Brazil");
        address = new Address(city, state, country);
        filters.put("countryFilter","Brazil");
        filters.put("ageFilter","18");
    }

    @Test
    public void fieldsForLabelShouldGiveTheFieldsForInvitationCard() throws Exception {
        Person person = new Person(name, age, prefix, address);
        List<List<String>> expected = asList(asList("Ms Julius Barrows"), asList("Macedonia, Vegas", "Brazil"));
        assertEquals(person.fieldsForLabel(), expected);

    }

    @Test
    public void testIsMeetingRequirement() throws Exception {
        Person person = new Person(name, age, prefix, address);
        assertTrue(person.isMeetingRequirement(filters));
    }
}