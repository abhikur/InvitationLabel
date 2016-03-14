package name;

public class NameAsFirstLast extends Name {

    public NameAsFirstLast(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String getFullName(String honorific) {
        return String.format("%s %s %s",honorific,firstName,lastName);
    }
}
