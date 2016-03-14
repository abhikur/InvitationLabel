package name;

public class NameAsFirstLast extends Name {

    public NameAsFirstLast(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
