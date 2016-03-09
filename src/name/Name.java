package name;

public abstract class Name {

    protected String lastName;
    protected String firstName;

    Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public abstract String getFullName();
}
