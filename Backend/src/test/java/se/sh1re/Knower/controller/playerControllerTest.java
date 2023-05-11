package se.sh1re.Knower.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import se.sh1re.Knower.driver.Safari;
import se.sh1re.Knower.models.Path.XPath;
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
    void playerCreation() throws InterruptedException {
        try {
            System.setProperty(safariWebDriver, safariWebDriverPath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            safari = new Safari(options);
            playerService = new PlayerService();
            safari.getDriver().navigate().to("https://en.wikipedia.org/wiki/" + "Joshua_Kimmich");
            safari.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            player = new Player();
            player.setName(playerService.getPersonName(safari.getDriver()
                    .findElement(By.xpath(XPath.name.toString())).getText()));

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
        catch (SessionNotCreatedException e) {
            safari.tearDown();
            Thread.sleep(2000);
        }


    }
}