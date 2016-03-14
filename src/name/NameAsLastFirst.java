package name;

public class NameAsLastFirst extends Name{

    public NameAsLastFirst(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String getFullName(String honorific) {
        return String.format("%s %s, %s",honorific,lastName,firstName);
    }
}
