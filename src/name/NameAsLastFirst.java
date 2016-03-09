package name;

public class NameAsLastFirst extends Name{

    public NameAsLastFirst(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String getFullName() {
        return lastName+", "+firstName;
    }
}
