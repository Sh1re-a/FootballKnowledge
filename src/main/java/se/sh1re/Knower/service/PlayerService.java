package se.sh1re.Knower.service;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;


import java.util.concurrent.TimeUnit;

public class PlayerService {
    private static final String safariWebDriver = "webdriver.safari.driver";
    private static final String safariWebDriverPath = "/usr/bin/safaridriver";
    private static SafariDriver safariDriver;


    public SafariDriver safariDriver(String player) {
        System.setProperty(safariWebDriver, safariWebDriverPath);
        safariDriver = new SafariDriver();
        safariDriver.navigate().to("https://en.wikipedia.org/wiki/" + player);
        safariDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return safariDriver;
    }


    public String getPersonName() {
        String personNameXPath = "//*[@id=\"firstHeading\"]/span";
        String personName = safariDriver.findElement(By.xpath(personNameXPath)).getText();
        return personName;
    }

    public String getPersonFullName() {
        String personFullNameXPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[3]/td";
        String personFullName = safariDriver.findElement(By.xpath(personFullNameXPath)).getText();
        return personFullName;
    }
    public String getPersonAgeAndBirthDate() {
        String ageAndBirthXPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[4]/td";
        String personAgeAndBirth = safariDriver.findElement(By.xpath(ageAndBirthXPath)).getText();
        return personAgeAndBirth;
    }

    public String getPlayerHeight() {
        String playerHeightsXPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[6]/td";
        String playersHeight = safariDriver.findElement(By.xpath(playerHeightsXPath)).getText();
        return playersHeight;
    }

    public String getPlayersPositions() {
        String playersPositionsXPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[7]/td";
        String playersPositions = safariDriver.findElement(By.xpath(playersPositionsXPath)).getText();
        return playersPositions;
    }

    
    public String getPlayersBirthOfPlace() {
        String playerBirthOfPlaceXPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[5]/td";
        String playersBirthOfPlace = safariDriver.findElement(By.xpath(playerBirthOfPlaceXPath)).getText();
        return playersBirthOfPlace;
    }

    
    public String getPlayersCurrentClub() {
        String checkIfPlayerHasACurrentClub = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[8]/th";
        String expectedInformation = "Club information";
        String text = safariDriver.findElement(By.xpath(checkIfPlayerHasACurrentClub)).getText();

        if(text.replaceAll("\\s+", "").equals(expectedInformation.replaceAll("\\s+", ""))) {
            String clubPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[9]/td";
            String expectedClub = "ParisSaint-Germain";
            String club = safariDriver.findElement(By.xpath(clubPath)).getText();
            return club;
        }
        else {
            return null;
        }

    }




}
