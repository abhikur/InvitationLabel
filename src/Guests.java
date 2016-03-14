import name.Name;
import person.Address;
import person.Age;
import person.Person;
import person.Prefix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Guests extends ArrayList<Person> {

    public void addPerson(Name name, Prefix gender, Age age, Address address) {
        add(new Person(name, age, gender, address));
    }

    public List<Person> filterRecord(HashMap<String, String> filters) {
        List<Person> record = new ArrayList<Person>();
        for (Person person : this) {
            if (person.isMeetingRequirement(filters))
                record.add(person);
        }
        return record;
    }

    public List<List<List<String>>> fieldsForLabel(List<Person> people) {
        List<List<List<String>>> labels = new ArrayList<List<List<String>>>();
        for (Person person : people) {
            labels.add(person.fieldsForLabel());
        }
        return labels;
    }
}
