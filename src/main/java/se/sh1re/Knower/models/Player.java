package se.sh1re.Knower.models;

import java.util.Arrays;

public class Player {

    private String name;
    private String fullName;
    private String placeOfBirth;
    private String birth;
    private int age;
    private double height;
    private String currentClub;
    private String[] positions;

    public Player(String name,String fullName, String placeOfBirth, String birth, int age, double height,
                  String currentClub, String[] positions) {
        this.name = name;
        this.fullName = fullName;
        this.placeOfBirth = placeOfBirth;
        this.birth = birth;
        this.age = age;
        this.height = height;
        this.currentClub = currentClub;
        this.positions = positions;
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

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
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

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", birth='" + birth + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", currentClub='" + currentClub + '\'' +
                ", positions=" + Arrays.toString(positions) +
                '}';
    }
}
