package se.sh1re.Knower.controller;

import org.openqa.selenium.safari.SafariDriver;
import se.sh1re.Knower.models.Player;
import se.sh1re.Knower.service.PlayerService;

import java.util.concurrent.TimeUnit;

public class playerController {

    private PlayerService playerService;
    private Player player;

    private static final String safariWebDriver = "webdriver.safari.driver";
    private static final String safariWebDriverPath = "/usr/bin/safaridriver";
    private static SafariDriver safariDriver;

   /* public Player playerCreation(String playerName){


        System.setProperty(safariWebDriver, safariWebDriverPath);
        safariDriver = new SafariDriver();
        safariDriver.navigate().to("https://en.wikipedia.org/wiki/" + playerName);
        safariDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        player.setName(playerService.getPersonName());
        player.setFullName(playerService.getPersonFullName());
        player.setAge();


    }

    */
}
