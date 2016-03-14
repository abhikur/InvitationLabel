import name.Name;
import person.*;

import java.io.IOException;

import static name.NameFormatter.getNameAsPerFormat;

public class RecordParser {

    private Guests guests;

    public RecordParser(Guests guests) {
        this.guests = guests;
    }

    public String[] parse(String file) throws IOException {
        Reader reader = new Reader();
        return reader.readFile(file).split("\n");
    }

    public String[] dataSplitter(String data, String splitBy) {
        return data.split(splitBy);
    }

    public void storePersonAsPerOption(String option, String[] record) throws IOException {
        for (String personInfo : record) {
            String[] personDetail = dataSplitter(personInfo, ",");

            Name name = getNameAsPerFormat(personDetail[0], personDetail[1], option);
            Honorific Honorific = new Honorific(personDetail[2]);
            Age ageOfPerson = new Age(personDetail[3]);
            City city = new City(personDetail[4]);
            State state = new State(personDetail[5]);
            Country country = new Country(personDetail[6]);
            Address address = new Address(city, state, country);
            guests.addPerson(name, Honorific, ageOfPerson, address);
        }
    }
}
