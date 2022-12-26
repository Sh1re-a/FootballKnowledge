package se.sh1re.Knower.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import se.sh1re.Knower.driver.Safari;
import se.sh1re.Knower.Path.XPath;
import se.sh1re.Knower.models.model.Player;
import se.sh1re.Knower.service.PlayerService;

import java.util.concurrent.TimeUnit;

class playerControllerTest {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private Player player;
    @Autowired
    private Safari safari;



    private static final String safariWebDriver = "webdriver.safari.driver";
    private static final String safariWebDriverPath = "/usr/bin/safaridriver";


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        if (safari.getDriver() != null)
        {
            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
                System.out.println("something went wrong");
            }
            safari.getDriver().quit();
        }
    }



    @Test
    void playerCreation() {

        System.setProperty(safariWebDriver, safariWebDriverPath);

        safari = new Safari();
        playerService = new PlayerService();
        safari.getDriver().navigate().to("https://en.wikipedia.org/wiki/" + "Joshua_Kimmich");
        safari.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String NameToFix = safari.getDriver().findElement(By.xpath(XPath.name.toString())).getText();

        player.setName(playerService.getPersonName(NameToFix));

        player.setFullName(playerService.getPersonFullName(safari.getDriver()
                .findElement(By.xpath(XPath.fullName.toString())).getText()));

        player.setPositions(playerService.getPlayersPositions(safari.getDriver()
                .findElement(By.xpath(XPath.positions.toString())).getText()));
        player.setPlaceOfBirth(playerService.getPlayersBirthOfPlace(safari.getDriver().findElement(By.xpath(XPath.birthPlace.toString())).getText()));
        player.setBirth(playerService.getPersonBirthDate(safari.getDriver().findElement(By.xpath(XPath.birthDate.toString())).getText()));
        player.setAge(playerService.getPersonAge(player.getBirth()));
        player.setCurrentClub(playerService.getPlayersCurrentClub(safari.getDriver()
                .findElement(By.xpath(XPath.currentClub.toString())).getText()));

        player.setShirtNumber(playerService.getPlayersShirtNumber(safari.getDriver()
                .findElement(By.xpath(XPath.shirtNumber.toString())).getText()));

        player.setHeight(playerService.getPlayerHeight(safari.getDriver()
                .findElement(By.xpath(XPath.height.toString())).getText()));

       System.out.println(player.toString());


    }
}