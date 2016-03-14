package person;

import name.Name;

import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;

public class Person {

    private Name name;
    private Age age;
    private Prefix prefix;
    private Address address;

    public Person(Name name, Age age, Prefix prefix, Address address) {
        this.name = name;
        this.age = age;
        this.prefix = prefix;
        this.address = address;
    }
    
    public List<List<String>> fieldsForLabel() {
        return asList(asList(String.format("%s %s",prefix.getPrefix(),name.getFullName())),
                             asList(String.format("%s, %s",address.getCity(),address.getState()),address.getCountry()));
    }

    private boolean isFromCountry(String country) {
        return country.equals(address.getCountry());
    }


    private boolean isOlderThanOrEqualTo(String age) {
        return Integer.parseInt(this.age.toString()) >= Integer.parseInt(age);
    }

    public boolean isMeetingRequirement(HashMap<String, String> filters) {
        Boolean isCountryMatch = true, isAgeMatch = true;
        if (filters.containsKey("countryFilter"))
            isCountryMatch = isFromCountry(String.valueOf(filters.get("countryFilter")));
        if (filters.containsKey("ageFilter"))
            isAgeMatch = isOlderThanOrEqualTo(String.valueOf(filters.get("ageFilter")));
        return isCountryMatch && isAgeMatch;
    }
}
