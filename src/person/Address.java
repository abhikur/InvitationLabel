package person;

public class Address {
    private City city;
    private State state;
    private Country country;
    public Address(City city, State state, Country country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getCountry() {
        return country.getName();
    }

    public String getCity() {
        return city.getName();
    }

    public String getState() {
        return state.getName();
    }
}
