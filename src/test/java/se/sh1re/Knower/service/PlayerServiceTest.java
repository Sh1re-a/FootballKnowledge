package se.sh1re.Knower.service;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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
        String name = "//*[@id=\"firstHeading\"]/span";
        String text = safariDriver.findElement(By.xpath(name)).getText();
        String expectedText = "CristianoRonaldo";
        System.out.println(text);
        assertEquals(expectedText, text.replaceAll("\\s+",""));
    }

    @Test
    void getPersonFullName() {
        String name = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[3]/td";
        String text = safariDriver.findElement(By.xpath(name)).getText();
        String expectedText = "CristianoRonaldodosSantosAveiro[1]";
        System.out.println(text);
        Assert.assertEquals(expectedText, text.replaceAll("\\s+",""));
    }



    @Test
    void getPersonAgeAndBirthDate() {
        String age = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[4]/td";
        String text = safariDriver.findElement(By.xpath(age)).getText();
        String expectedText = "(1985-02-05)5February1985(age37)[1]";
        System.out.println(text);
        text = text.replace("\u00a0","");
        Assert.assertEquals(expectedText.replaceAll("\\s+",""), text.replaceAll("\\s+",""));

    }

    //*[@id="mw-content-text"]/div[1]/table[1]/tbody/tr[6]/td

    @Test
    void getPlayerHeight() {
        String height = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[6]/td";
        String expectedText = "1.87m(6ft2in)[note1]";
        String text = safariDriver.findElement(By.xpath(height)).getText();
        System.out.println(text);
        text = text.replace("\u00a0","");
        Assert.assertEquals(expectedText, text.replaceAll("\\s+",""));
    }

    @Test
    void getPlayersPositions() {
        String position = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[7]/td";
        String expectedText = "Forward";
        String text = safariDriver.findElement(By.xpath(position)).getText();
        System.out.println(text);
        Assert.assertEquals(expectedText, text.replaceAll("\\s+",""));

    }

    @Test
    void getPlayersBirthOfPlace() {
        String position = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[5]/td";
        String expectedText = "Funchal, Madeira, Portugal[1]";
        String text = safariDriver.findElement(By.xpath(position)).getText();
        System.out.println(text);
        Assert.assertEquals(expectedText.replaceAll("\\s+",""), text.replaceAll("\\s+",""));
    }

    @Test
    void getPlayersCurrentClub() {
        String checkIfPlayerHasACurrentClub = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[8]/th";
        String expectedInformation = "Club information";
        String text = safariDriver.findElement(By.xpath(checkIfPlayerHasACurrentClub)).getText();

        if(text.replaceAll("\\s+", "").equals(expectedInformation.replaceAll("\\s+", ""))) {
            String clubPath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[9]/td";
            String expectedClub = "ParisSaint-Germain";
            String club = safariDriver.findElement(By.xpath(clubPath)).getText();
            System.out.println(club);
            Assert.assertEquals(expectedClub, club.replaceAll("\\s+",""));
        }
        else {
            System.out.println(text);
            Assert.assertNotEquals(expectedInformation.replaceAll("\\s+", ""), text.replaceAll("\\s+", ""));
        }

    }







}