package se.sh1re.Knower.models.model;

import java.util.List;

public class Country {

    private String countryName;
    private int population;
    private String capital;
    private double area;
    private String language;

    public Country(String countryName, int population, String capital, double area, String language) {
        this.countryName = countryName;
        this.population = population;
        this.capital = capital;
        this.area = area;
        this.language = language;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", population=" + population +
                ", capital='" + capital + '\'' +
                ", area=" + area +
                ", languages=" + language +
                '}';
    }
}
