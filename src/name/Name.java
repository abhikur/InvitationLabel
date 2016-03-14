package name;

public abstract class Name {

    protected String firstName;
    protected String lastName;

    Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public abstract String getFullName();
}
