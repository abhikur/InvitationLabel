import name.Name;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Guests {
    private List<Person> guestList = new ArrayList<Person>();

    public void addPerson(Name name, Prefix gender, Age age, Address address) {
            guestList.add(new Person(name, age, gender, address));
    }

    public List<Person> filterRecord(HashMap<String, String> filters) {
        List<Person> record = new ArrayList<Person>();
        for (Person person : guestList) {
            if(person.isMeetingRequirement(filters))
                record.add(person);
        }
        return record;
    }

    public List<String> makeLabel(List<Person> people) {
        List<String> labels = new ArrayList<String >();
        for (Person person : people) {
            labels.add(person.makeLabel());
        }
        return labels;
    }
}
