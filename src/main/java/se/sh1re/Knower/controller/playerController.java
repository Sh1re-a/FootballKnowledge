package se.sh1re.Knower.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.sh1re.Knower.driver.Safari;
import se.sh1re.Knower.Path.XPath;
import se.sh1re.Knower.models.Player;
import se.sh1re.Knower.service.PlayerService;

import java.util.concurrent.TimeUnit;
@RestController
public class playerController {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private Player player;

    private Safari safari;

    private static final String safariWebDriver = "webdriver.safari.driver";
    private static final String safariWebDriverPath = "/usr/bin/safaridriver";
    private static SafariDriver safariDriver;

    @PostMapping(value="/search")
    public Player getPlayer(@RequestBody String playerName) {

        System.setProperty(safariWebDriver, safariWebDriverPath);
        playerName = playerName.strip();
        safari = new Safari();
        Player player = new Player();
        playerService = new PlayerService();
        safari.getDriver().navigate().to("https://en.wikipedia.org/wiki/" + playerName);
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
                .findElement(By.xpath(XPath.currentClubExits.toString())).getText(),safari.getDriver()
                .findElement(By.xpath(XPath.currentClub.toString())).getText()));

        player.setShirtNumber(playerService.getPlayersShirtNumber(safari.getDriver()
                .findElement(By.xpath(XPath.shirtNumber.toString())).getText()));

        player.setHeight(playerService.getPlayerHeight(safari.getDriver()
                .findElement(By.xpath(XPath.height.toString())).getText()));

        safari.tearDown();

        return player;


    }


}
