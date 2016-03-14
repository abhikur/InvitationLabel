package person;

import name.Name;

import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;

public class Person {

    private Name name;
    private Age age;
    private Honorific honorific;
    private Address address;

    public Person(Name name, Age age, Honorific honorific, Address address) {
        this.name = name;
        this.age = age;
        this.honorific = honorific;
        this.address = address;
    }
    
    public List<List<String>> fieldsForLabel() {
        return asList(asList(String.format("%s", name.getFullName(honorific.getHonorific()))),
                             asList(String.format("%s, %s",address.getCity(),address.getState()),address.getCountry()));
    }

    private boolean isFromCountry(String country) {
        return country.equals(address.getCountry());
    }

    private boolean isFromState(String state) {
        return state.equals(address.getState());
    }

    private boolean isOlderThanOrEqualTo(String age) {
        return Integer.parseInt(this.age.toString()) >= Integer.parseInt(age);
    }

    public boolean isMeetingRequirement(HashMap<String, String> filters) {
        Boolean isCountryMatch = true, isAgeMatch = true, isStateMatch = true;
        if (filters.containsKey("--filterCountry"))
            isCountryMatch = isFromCountry(String.valueOf(filters.get("--filterCountry")));
        if (filters.containsKey("--filterState"))
            isStateMatch = isFromState(String.valueOf(filters.get("--filterState")));
        if (filters.containsKey("--filterAge"))
            isAgeMatch = isOlderThanOrEqualTo(String.valueOf(filters.get("--filterAge")));
        return isCountryMatch && isAgeMatch && isStateMatch;
    }
}
