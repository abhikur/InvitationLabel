package name;

public class NameFormatter {

    public static Name getNameAsPerFormat(String firstName, String lastName, String option) {
        if (option.equals("-fl"))
            return new NameAsFirstLast(firstName, lastName);
        return new NameAsLastFirst(firstName, lastName);
    }
}
