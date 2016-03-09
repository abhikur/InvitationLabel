public class Prefix {
    private String gender;

    public Prefix(String gender) {
        this.gender = gender;
    }

    public String getPrefix() {
        return gender.equals("Male") ? "Mr" : "Ms";
    }
}
