package se.sh1re.Knower.models;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CityTest {

    private City city;

    @BeforeEach
    void setUpClass(){
        city = new City("Stockholm",2000000, "Sweden");
    }

    @Test
    void getCityName() {
        String expectedCityName = "Stockholm";
        String cityName = city.getCityName();
        Assert.assertEquals(expectedCityName, cityName);
    }

    @Test
    void setCityName() {
       String setCityName = "Bryssel";
        city.setCityName(setCityName);

       String cityName = city.getCityName();
       Assert.assertEquals(setCityName, cityName);
    }

    @Test
    void getPopulation() {
    }

    @Test
    void setPopulation() {
    }

    @Test
    void getRegion() {
    }

    @Test
    void setRegion() {
    }

    @Test
    void getCountry() {
    }

    @Test
    void setCountry() {
    }




}