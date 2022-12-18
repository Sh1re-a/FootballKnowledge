package se.sh1re.Knower.models;

public class Player {

    private String name;
    private String placeOfBirth;
    private String birth;
    private int age;
    private double height;
    private String foot;
    private String club;

    public Player(String name, String placeOfBirth, String birth, int age, double height, String foot, String club) {
        this.name = name;
        this.placeOfBirth = placeOfBirth;
        this.birth = birth;
        this.age = age;
        this.height = height;
        this.foot = foot;
        this.club = club;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", birth='" + birth + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", foot='" + foot + '\'' +
                ", club='" + club + '\'' +
                '}';
    }


}
