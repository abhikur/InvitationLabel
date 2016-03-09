import name.Name;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static name.NameFormatter.getNameAsPerFormat;

public class LabelMaker {
    private Guests guest;
    private String option;
    List<String> labels = new ArrayList<String>();

    public LabelMaker(String option) {
        this.guest = new Guests();
        this.option = option;

    }

    private String getRecord(String file) throws IOException {
        Reader reader = new Reader();
        return reader.readFile(file);
    }

    public void make(HashMap<String, String> filters) throws IOException {
        String[] record = getRecord(filters.get("file")).split("\n");
        storePeople(record);
        makeLabelForFilteredPerson(filters);
    }

    private void storePeople(String[] record) {
        for (String personInfo : record) {
            String[] personDetail = personInfo.split(",");
            String firstName = personDetail[0];
            String lastName = personDetail[1];
            String gender = personDetail[2];
            String age = personDetail[3];
            String city = personDetail[4];
            String state = personDetail[5];
            String country = personDetail[6];
            Name name = getNameAsPerFormat(firstName, lastName, option);
            Prefix prefix = new Prefix(gender);
            Age ageOfPerson = new Age(age);
            Address address = new Address(city, state, country);
            guest.addPerson(name, prefix, ageOfPerson, address);
        }
    }

    private void makeLabelForFilteredPerson(HashMap<String, String> filters) {
        List<Person> filteredPeople = guest.filterRecord(filters);
        labels = guest.makeLabel(filteredPeople);
    }

    public List<String> getLabels() {
        return labels;
    }
}
