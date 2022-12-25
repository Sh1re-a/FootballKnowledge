package se.sh1re.Knower.models.model;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String fullName;

    private String[] placeOfBirth;
    @Column
    private LocalDate birth;
    @Column
    private int age;
    @Column
    private double height;
    @Column
    private String currentClub;

    private String[] positions;
    @Column
    private int shirtNumber;

    public Player() {
    }

    public Player(String name, String fullName, String[] placeOfBirth,
                  LocalDate birth, int age, double height, String currentClub, String[] positions, int shirtNumber) {
        this.name = name;
        this.fullName = fullName;
        this.placeOfBirth = placeOfBirth;
        this.birth = birth;
        this.age = age;
        this.height = height;
        this.currentClub = currentClub;
        this.positions = positions;
        this.shirtNumber = shirtNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String[] getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String[] placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    public String getCurrentClub() {
        return currentClub;
    }

    public void setCurrentClub(String currentClub) {
        this.currentClub = currentClub;
    }

    public String[] getPositions() {
        return positions;
    }

    public void setPositions(String[] positions) {
        this.positions = positions;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    @Override
    public String toString() {
        return "Player{" + System.lineSeparator() +
                "name='" + name + '\'' + System.lineSeparator() +
                "fullName='" + fullName + '\'' + System.lineSeparator() +
                "placeOfBirth=" + Arrays.toString(placeOfBirth) + System.lineSeparator() +
                "birth=" + birth + System.lineSeparator() +
                "age=" + age + System.lineSeparator() +
                "height=" + height + System.lineSeparator() +
                "currentClub='" + currentClub + '\'' + System.lineSeparator() +
                "positions=" + Arrays.toString(positions) + System.lineSeparator() +
                "shirtNumber=" + shirtNumber + System.lineSeparator() +
                '}';
    }
}
