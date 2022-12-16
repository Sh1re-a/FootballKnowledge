package se.sh1re.Knower.models;

public class Person {

    private String firstName;
    private String lastName;
    private String placeOfBirth;
    private String occupation;
    private double height;

    public Person(String firstName, String lastName, String placeOfBirth, String occupation, double height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.placeOfBirth = placeOfBirth;
        this.occupation = occupation;
        this.height = height;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", occupation='" + occupation + '\'' +
                ", height=" + height +
                '}';
    }
}
