import name.Name;

import java.util.HashMap;

public class Person {

    private Name name;
    private Age age;
    private Prefix prefix;
    private Address address;

    protected Person(Name name, Age age, Prefix prefix, Address address) {
        this.name = name;
        this.age = age;
        this.prefix = prefix;
        this.address = address;
    }

    public String makeLabel() {
        return prefix.getPrefix()+" "+name.getFullName()+", "+ address.getCountry()+ ", "+age.value;
    }

    private boolean isFromCountry(String country) {
        return country.equals(address.getCountry());
    }


    private boolean isOderThanOrEqualTo(String age) {
        return Integer.parseInt(this.age.toString()) >= Integer.parseInt(age);
    }

    public boolean isMeetingRequirement(HashMap<String, String> filters) {
        Boolean isCountryMatch = true, isAgeMatch = true;
        if(filters.containsKey("countryFilter"))
            isCountryMatch = isFromCountry(String.valueOf(filters.get("countryFilter")));
        if(filters.containsKey("ageFilter"))
            isAgeMatch = isOderThanOrEqualTo(String.valueOf(filters.get("ageFilter")));
        return isCountryMatch && isAgeMatch;
    }
}
