package se.sh1re.Knower.models.model;

public class City {

    private String cityName;
    private int population;
    private String country;

    public City(String cityName, int population, String country) {
        this.cityName = cityName;
        this.population = population;
        this.country = country;
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", population=" + population +
                ", country='" + country + '\'' +
                '}';
    }
}
