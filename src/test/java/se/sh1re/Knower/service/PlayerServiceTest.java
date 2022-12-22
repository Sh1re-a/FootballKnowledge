package se.sh1re.Knower.service;


import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;


import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

class PlayerServiceTest {

    private static final String safariWebDriver = "webdriver.safari.driver";
    private static final String safariWebDriverPath = "/usr/bin/safaridriver";
    private static SafariDriver safariDriver;




    @BeforeEach
    void setUp() {
        System.setProperty(safariWebDriver, safariWebDriverPath);
        safariDriver = new SafariDriver();
        safariDriver.navigate().to("https://en.wikipedia.org/wiki/Cristiano_Ronaldo");
        safariDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //  safariDriver.findElement(By.xpath("//*[@id="notice"]/div[3]/div[2]/button")).click();
    }

    @AfterEach
    void tearDown() {

            if (safariDriver != null)
            {
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e){
                    System.out.println("something went wrong");
                }
                safariDriver.quit();
            }

    }


    @Test
    void getPersonName() {
        String personNameXPath = "//*[@id=\"firstHeading\"]/span";
        String personName = safariDriver.findElement(By.xpath(personNameXPath)).getText();
        String expectedPersonName = "Cristiano Ronaldo";
        System.out.println(personName);
        assertEquals(expectedPersonName, personName);

    }

    @Test
    void getPersonFullName() {
        String personFullNameXPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[3]/td";
        String personFullName = safariDriver.findElement(By.xpath(personFullNameXPath)).getText();
        String expectedPersonFullName = "Cristiano Ronaldo dos Santos Aveiro";

        personFullName = personFullName.replace("[", "");
        personFullName = personFullName.replace("]", "");
        personFullName = personFullName.replaceAll("[0-9]","");
        personFullName =  personFullName.strip();

        System.out.println(personFullName);
        assertEquals(expectedPersonFullName, personFullName);
    }



    @Test
    void getPersonAgeAndBirthDate() {
        String birthDateXPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[4]/td";
        String personBirthDate = safariDriver.findElement(By.xpath(birthDateXPath)).getText();
        String[] expectedBirthArrays = {"1985","02","05"};
        System.out.println(personBirthDate);
        personBirthDate = personBirthDate.replaceAll("\\s+","");
        personBirthDate = personBirthDate.replace("\u00a0","");

        for(int i = 0; i < personBirthDate.length(); i++){
            if(personBirthDate.charAt(i) == ')'){
                personBirthDate = personBirthDate.substring(1, i);
            }
        }
        String[] birthArray = personBirthDate.split("-");
        assertArrayEquals(expectedBirthArrays, birthArray);
    }

    //*[@id="mw-content-text"]/div[1]/table[1]/tbody/tr[6]/td

    @Test
    void getPlayerHeight() {
        String playersHeightXPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[6]/td";
        Double expectedPlayersHeight = 1.87;
        String playerHeight = safariDriver.findElement(By.xpath(playersHeightXPath)).getText();
        playerHeight = playerHeight.replace("\u00a0","");
        playerHeight = playerHeight.substring(0,5);
        playerHeight = playerHeight.strip();
        System.out.println(playerHeight);
        Double playerHeightConvert = Double.parseDouble(playerHeight);

        assertEquals(expectedPlayersHeight, playerHeightConvert);
    }

    @Test
    void getPlayersPositions() {
        String playerPositionsXPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[7]/td";
        String[] expectedPlayerPositions = {"Forward"};
        String playerPositions = safariDriver.findElement(By.xpath(playerPositionsXPath)).getText();
        playerPositions = playerPositions.strip();
        String playerPositionsRemovedOfWhiteSpace = playerPositions;

        if(playerPositions.contains(",")) {

            for (int i = 0; i < playerPositions.length(); i++) {
                if (playerPositions.charAt(i) == ',') {
                    playerPositionsRemovedOfWhiteSpace = playerPositions.substring(0, i + 1) + playerPositions.substring(i + 2);
                    playerPositions = playerPositions.substring(i + 1, i + 2);
                }
            }
        }
        System.out.println(playerPositionsRemovedOfWhiteSpace);
        String[] playersPositionsArray = playerPositionsRemovedOfWhiteSpace.split(",");

        assertArrayEquals(expectedPlayerPositions, playersPositionsArray);
    }

    @Test
    void getPlayersBirthOfPlace() {
        String playersBirthOfPlaceXPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[5]/td";
        String[] expectedPlayersBirthOfPlace = {"Funchal","Madeira","Portugal"};
        String playersBirthOfPlace = safariDriver.findElement(By.xpath(playersBirthOfPlaceXPath)).getText();

        playersBirthOfPlace = playersBirthOfPlace.replaceAll("\\s+","");
        playersBirthOfPlace = playersBirthOfPlace.replace("\u00a0","");
        playersBirthOfPlace = playersBirthOfPlace.replace("]", "");
        playersBirthOfPlace = playersBirthOfPlace.replace("[" , "");

        playersBirthOfPlace = playersBirthOfPlace.replaceAll("[0-9]","");
        playersBirthOfPlace = playersBirthOfPlace.strip();


        String [] playerBirthOfPlaceArrays = playersBirthOfPlace.split(",");
        System.out.println(playersBirthOfPlace);
        assertArrayEquals(expectedPlayersBirthOfPlace, playerBirthOfPlaceArrays);
    }

    @Test
    void getPlayersCurrentClub() {
        String checkIfPlayerHasACurrentClub = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[8]/th";
        String expectedInformation = "Club information";
        String playersCurrentClubExists = safariDriver.findElement(By.xpath(checkIfPlayerHasACurrentClub)).getText();
        playersCurrentClubExists = playersCurrentClubExists.strip();

        if(playersCurrentClubExists.equals(expectedInformation)) {
            String clubXPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[9]/td";
            String expectedClub = "Paris Saint-Germain";
            String playersClub = safariDriver.findElement(By.xpath(clubXPath)).getText();
            playersClub = playersClub.strip();
            System.out.println(playersClub);
            assertEquals(expectedClub, playersClub);
        }
        else {
            System.out.println(playersCurrentClubExists);
            assertNotEquals(expectedInformation, playersCurrentClubExists);
        }

    }

    @Test
    void getPlayersShirtNumber(){ //För messi specifikt
        String playersShirtNumberXPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[10]/td";
        int expectedShirtNumber = 30;
        String playersShirtNumber = safariDriver.findElement(By.xpath(playersShirtNumberXPath)).getText();
        playersShirtNumber = playersShirtNumber.strip();
        int shirtNumber = Integer.parseInt(playersShirtNumber);

        assertEquals(expectedShirtNumber, shirtNumber);
    }







}