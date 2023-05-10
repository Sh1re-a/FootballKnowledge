package se.sh1re.Knower.service;


import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebElement;
import se.sh1re.Knower.models.Path.PathValidator;
import se.sh1re.Knower.driver.Safari;


import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

class PlayerServiceTest {

    private static final String safariWebDriver = "webdriver.safari.driver";
    private static final String safariWebDriverPath = "/usr/bin/safaridriver";
    private static Safari safariDriver;





    @BeforeEach
    void setUp() {
        System.setProperty(safariWebDriver, safariWebDriverPath);
        safariDriver = new Safari();
        safariDriver.getDriver().navigate().to("https://en.wikipedia.org/wiki/Lionel_Messi");
        safariDriver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //  safariDriver.findElement(By.xpath("//*[@id="notice"]/div[3]/div[2]/button")).click();
    }

    @AfterEach
    void tearDown() {

            if (safariDriver != null)
            {
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e){
                    System.out.println("something went wrong");
                }
                safariDriver.getDriver().quit();
            }

    }




    String validateInformation(String path) {
        WebElement self = safariDriver.getDriver().findElement(By.xpath(PathValidator.tablePath.toString() + path));
        WebElement ancestor = safariDriver.getDriver().findElement(By.xpath(PathValidator.tablePath.toString()));
        String broder =  getXpath(self, ancestor );
        return PathValidator.tablePath.toString() + broder;
    }



    public static String getXpath(WebElement self, WebElement ancestor){
        int a = ancestor.findElements(By.xpath("./ancestor::*")).size();
        int s = self.findElements(By.xpath("./ancestor::*")).size();
        String path = "";
        WebElement current = self;
        for(int i = s - a; i > 0; i--){
            String tag = current.getTagName();
            int lvl = current.findElements(By.xpath("./preceding-sibling::" + tag)).size() + 1;
            path = String.format("/%s[%d]%s", tag, lvl, path);
            current = current.findElement(By.xpath("./parent::*"));
        }
        return path;
    }



    @Test
    void getPersonName() throws InterruptedException {


            try {
                String personNameXPath = "//*[@id=\"firstHeading\"]/span";
                String personName = safariDriver.getDriver().findElement(By.xpath(personNameXPath)).getText();

                String expectedPersonName = "Lionel Messi";
                System.out.println(personName);
                assertEquals(expectedPersonName, personName);
            }
            catch (SessionNotCreatedException e) {
                safariDriver.tearDown();
                Thread.sleep(2000);
            }




    }

    @Test
    void getPersonFullName() throws InterruptedException {
        try {
            String personFullNameXPath = validateInformation(PathValidator.FullName.toString());
            personFullNameXPath = personFullNameXPath.replaceAll("TH", "TD");
            String personFullName = safariDriver.getDriver().findElement(By.xpath(personFullNameXPath)).getText();

            String expectedPersonFullName = "Lionel Andrés Messi";

            personFullName = personFullName.replace("[", "");
            personFullName = personFullName.replace("]", "");
            personFullName = personFullName.replaceAll("[0-9]", "");
            personFullName = personFullName.strip();

            System.out.println(personFullName);
            assertEquals(expectedPersonFullName, personFullName);
        }

        catch (SessionNotCreatedException e) {
            safariDriver.tearDown();
            Thread.sleep(2000);
        }
    }



    @Test
    void getPersonAgeAndBirthDate() throws InterruptedException {
        try {
            String birthDateXPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[4]/td";
            String personBirthDate = safariDriver.getDriver().findElement(By.xpath(birthDateXPath)).getText();
            String[] expectedBirthArrays = {"1987", "06", "24"};
            System.out.println(personBirthDate);
            personBirthDate = personBirthDate.replaceAll("\\s+", "");
            personBirthDate = personBirthDate.replace("\u00a0", "");

            for (int i = 0; i < personBirthDate.length(); i++) {
                if (personBirthDate.charAt(i) == ')') {
                    personBirthDate = personBirthDate.substring(1, i);
                }
            }
            String[] birthArray = personBirthDate.split("-");
            assertArrayEquals(expectedBirthArrays, birthArray);
        }
        catch (SessionNotCreatedException e) {
            safariDriver.tearDown();
            Thread.sleep(2000);
        }
    }

    //*[@id="mw-content-text"]/div[1]/table[1]/tbody/tr[6]/td

    @Test
    void getPlayerHeight() throws InterruptedException {
        try {
            String playersHeightXPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[6]/td";
            Double expectedPlayersHeight = 1.7;
            String playerHeight = safariDriver.getDriver().findElement(By.xpath(playersHeightXPath)).getText();
            playerHeight = playerHeight.replace("\u00a0", "");
            playerHeight = playerHeight.substring(0, 5);
            playerHeight = playerHeight.strip();
            System.out.println(playerHeight);
            Double playerHeightConvert = Double.parseDouble(playerHeight);

            assertEquals(expectedPlayersHeight, playerHeightConvert);
        }
        catch (SessionNotCreatedException e) {
            safariDriver.tearDown();
            Thread.sleep(2000);
        }
    }

    @Test
    void getPlayersPositions() throws InterruptedException {
        try {
            String playerPositionsXPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[7]/td";
            String[] expectedPlayerPositions = {"Forward"};
            String playerPositions = safariDriver.getDriver().findElement(By.xpath(playerPositionsXPath)).getText();
            playerPositions = playerPositions.replace("[", "");
            playerPositions = playerPositions.replace("]", "");
            playerPositions = playerPositions.replaceAll("[0-9]", "");
            playerPositions = playerPositions.strip();
            String playerPositionsRemovedOfWhiteSpace = playerPositions;

            if (playerPositions.contains(",")) {

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
        catch (SessionNotCreatedException e) {
            safariDriver.tearDown();
            Thread.sleep(2000);
        }
    }

    @Test
    void getPlayersBirthOfPlace() throws InterruptedException {
        try {
            String playersBirthOfPlaceXPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[5]/td";
            String[] expectedPlayersBirthOfPlace = {"Rosario", "Santa Fe", "Argentina"};
            String playersBirthOfPlace = safariDriver.getDriver().findElement(By.xpath(playersBirthOfPlaceXPath)).getText();


            playersBirthOfPlace = playersBirthOfPlace.replace("\u00a0", "");
            playersBirthOfPlace = playersBirthOfPlace.replace("]", "");
            playersBirthOfPlace = playersBirthOfPlace.replace("[", "");

            playersBirthOfPlace = playersBirthOfPlace.replaceAll("[0-9]", "");
            playersBirthOfPlace = playersBirthOfPlace.strip();


            String[] playerBirthOfPlaceArrays = playersBirthOfPlace.split(",");
            for (int i = 0; i < playerBirthOfPlaceArrays.length; i++) {
                playerBirthOfPlaceArrays[i] = playerBirthOfPlaceArrays[i].strip();
            }
            System.out.println(playersBirthOfPlace);
            assertArrayEquals(expectedPlayersBirthOfPlace, playerBirthOfPlaceArrays);
        }
        catch (SessionNotCreatedException e) {
            safariDriver.tearDown();
            Thread.sleep(2000);
        }
    }

    @Test
    void getPlayersCurrentClub() throws InterruptedException {
        try {
            String checkIfPlayerHasACurrentClub = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[8]/th";
            String expectedInformation = "Club information";
            String playersCurrentClubExists = safariDriver.getDriver().findElement(By.xpath(checkIfPlayerHasACurrentClub)).getText();
            playersCurrentClubExists = playersCurrentClubExists.strip();

            if (playersCurrentClubExists.equals(expectedInformation)) {
                String clubXPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[9]/td";
                String expectedClub = "Paris Saint-Germain";
                String playersClub = safariDriver.getDriver().findElement(By.xpath(clubXPath)).getText();
                playersClub = playersClub.strip();
                System.out.println(playersClub);
                assertEquals(expectedClub, playersClub);
            } else {
                System.out.println(playersCurrentClubExists);
                assertNotEquals(expectedInformation, playersCurrentClubExists);
            }
        }
        catch (SessionNotCreatedException e) {
            safariDriver.tearDown();
            Thread.sleep(2000);
        }

    }

    @Test
    void getPlayersShirtNumber() throws InterruptedException {
        try {
            String playersShirtNumberXPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[10]/td";
            int expectedShirtNumber = 30;
            String playersShirtNumber = safariDriver.getDriver().findElement(By.xpath(playersShirtNumberXPath)).getText();
            playersShirtNumber = playersShirtNumber.strip();
            int shirtNumber = Integer.parseInt(playersShirtNumber);

            assertEquals(expectedShirtNumber, shirtNumber);
        }
        catch (SessionNotCreatedException e) {
            safariDriver.tearDown();
            Thread.sleep(2000);
        }
    }







}