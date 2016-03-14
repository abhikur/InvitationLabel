import name.Name;
import person.Address;
import person.Age;
import person.Person;
import person.Honorific;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Guests extends ArrayList<Person> {

    public void addPerson(Name name, Honorific gender, Age age, Address address) {
        add(new Person(name, age, gender, address));
    }

    public List<Person> filterRecord(HashMap<String, String> filters) {
        List<Person> filteredGuests = new ArrayList<Person>();
        for (Person person : this) {
            if (person.isMeetingRequirement(filters))
                filteredGuests.add(person);
        }
        return filteredGuests;
    }
}
