package se.sh1re.Knower.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.sh1re.Knower.driver.Safari;
import se.sh1re.Knower.Path.XPath;
import se.sh1re.Knower.models.model.Player;
import se.sh1re.Knower.models.repository.PlayerRepo;
import se.sh1re.Knower.service.PlayerService;

import java.util.concurrent.TimeUnit;
@RestController
public class playerController {

    @Autowired
    private PlayerService playerService;
    private Safari safari;
    @Autowired
    private PlayerRepo playerRepo;

    private static final String safariWebDriver = "webdriver.safari.driver";
    private static final String safariWebDriverPath = "/usr/bin/safaridriver";


    @PostMapping(value="/search")
    public ResponseEntity<Player>getPlayer(@RequestBody String playerName) throws  InterruptedException {
    while (true)
        try {
        System.setProperty(safariWebDriver, safariWebDriverPath);
        playerName = playerName.strip();
        safari = new Safari();
        Player player = new Player();
        playerService = new PlayerService();
        safari.getDriver().navigate().to("https://en.wikipedia.org/wiki/" + playerName);
        safari.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);



        player.setName(playerService.getPersonName(safari.getDriver().
                findElement(By.xpath(XPath.name.toString())).getText()));

        player.setFullName(playerService.getPersonFullName(safari.getDriver()
                .findElement(By.xpath(XPath.fullName.toString())).getText()));

        player.setPositions(playerService.getPlayersPositions(safari.getDriver()
                .findElement(By.xpath(XPath.positions.toString())).getText()));

        player.setPlaceOfBirth(playerService.getPlayersBirthOfPlace(safari.getDriver()
                .findElement(By.xpath(XPath.birthPlace.toString())).getText()));

        player.setBirth(playerService.getPersonBirthDate(safari.getDriver().
                findElement(By.xpath(XPath.birthDate.toString())).getText()));

        player.setAge(playerService.getPersonAge(player.getBirth()));

        player.setCurrentClub(playerService.getPlayersCurrentClub(safari.getDriver()
                .findElement(By.xpath(XPath.currentClubExits.toString())).getText(),safari.getDriver()
                .findElement(By.xpath(XPath.currentClub.toString())).getText()));

        player.setShirtNumber(playerService.getPlayersShirtNumber(safari.getDriver()
                .findElement(By.xpath(XPath.shirtNumber.toString())).getText()));

        player.setHeight(playerService.getPlayerHeight(safari.getDriver()
                .findElement(By.xpath(XPath.height.toString())).getText()));

        safari.tearDown();

        playerRepo.save(player);
        return new ResponseEntity<>(player, HttpStatus.OK);



    }
        catch (SessionNotCreatedException | UnreachableBrowserException e) {
            safari.tearDown();
            Thread.sleep(2000);
            continue;
        }

        catch (NoSuchElementException e){
            System.out.println("No such element was found, check the if the name was spelled correct");
            safari.tearDown();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }


}
