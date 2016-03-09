import name.Name;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Guests {
    private List<Person> guestList = new ArrayList<>();

    public void addPerson(Name name, Prefix gender, Age age, Address address) {
            guestList.add(new Person(name, age, gender, address));
    }

    public List<Person> filterRecord(HashMap<String, String> filters) {
        List<Person> record = new ArrayList<>();
        for (Person person : guestList) {
            if(person.isMeetingRequirement(filters))
                record.add(person);
        }
        return record;
    }

    public List<String> makeLabel(List<Person> people) {
        List<String> labels = new ArrayList<>();
        for (Person person : people) {
            labels.add(person.makeLabel());
        }
        return labels;
    }
}
