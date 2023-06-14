package se.sh1re.Knower.controller;

import org.hibernate.jdbc.Expectation;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.sh1re.Knower.models.Path.PathValidator;
import se.sh1re.Knower.models.Path.XPath;
import se.sh1re.Knower.driver.Safari;
import se.sh1re.Knower.models.model.Player;
import se.sh1re.Knower.models.repository.PlayerRepo;
import se.sh1re.Knower.service.PathValidatorService;
import se.sh1re.Knower.service.PlayerService;
import se.sh1re.Knower.webconfiguration.WebDriverPath;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class playerController {


    private static final String safariWebDriver = "webdriver.chrome.driver";

    // private static final String safariWebDriverPath = "C:\\ws\\chromedriver_win32\\chromedriver.exe";

    WebDriverPath x = new WebDriverPath();
    String safariWebDriverPath = x.safariWebDriverPath;



    @Autowired
    private PlayerService playerService;
    private Safari safari;
    @Autowired
    private PlayerRepo playerRepo;
    @Autowired
    private PathValidatorService pathValidatorService;

    @PostMapping(value = "/search")
    public ResponseEntity<Player> getPlayer(@RequestBody String playerName) throws InterruptedException {


        boolean StartSelenium = false;

        String dbName = playerName;
        dbName = dbName.replaceAll("_", " ");
        dbName = dbName.strip();


        if (playerRepo.findByName(dbName) == null) {
            StartSelenium = true;
        } else {

            Player DatebasePlayer = playerRepo.findByName(dbName);
            DatebasePlayer.setPositions(playerService.getPlayersPositions(DatebasePlayer.getDatabasePositions()));
            DatebasePlayer.setPlaceOfBirth(playerService.getPlayersBirthOfPlace(DatebasePlayer.getDatabasePlaceOfBirth()));

            return new ResponseEntity<>(DatebasePlayer, HttpStatus.OK);
        }


        while (StartSelenium)
            try {

                System.setProperty(safariWebDriver, safariWebDriverPath);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                safari = new Safari(options);

                playerName = playerName.strip();

                pathValidatorService = new PathValidatorService();

                playerService = new PlayerService();
                safari.getDriver().navigate().to("https://en.wikipedia.org/wiki/" + playerName);
                safari.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                Player player = new Player(
                        playerService.getPersonName(safari.getDriver().
                                findElement(By.xpath(XPath.name.toString())).getText()),

                        playerService.getPersonFullName(safari.getDriver()
                                .findElement(By.xpath(pathValidatorService.validateInformation
                                        (PathValidator.FullName.toString(), safari))).getText()),

                        playerService.getPlayersBirthOfPlace(safari.getDriver()
                                .findElement(By.xpath(pathValidatorService.validateInformation
                                        (PathValidator.PlaceOfBirth.toString(), safari))).getText()),

                        playerService.getPersonBirthDate(safari.getDriver().
                                findElement(By.xpath(pathValidatorService.validateInformation
                                        (PathValidator.DateOfBirth.toString(), safari))).getText()), //Tar lång tid

                        playerService.getPersonAge(playerService.getPersonBirthDate(safari.getDriver().
                                findElement(By.xpath(pathValidatorService.validateInformation
                                        (PathValidator.DateOfBirth.toString(), safari))).getText())), //Tar lång tid


                        playerService.getPlayerHeight(safari.getDriver()
                                .findElement(By.xpath(pathValidatorService.validateInformation
                                        (PathValidator.Height.toString(), safari))).getText()),

                        playerService.getPlayersCurrentClub(safari.getDriver()
                                .findElement(By.xpath(pathValidatorService.validateInformation
                                        (PathValidator.CurrentClub.toString(), safari))).getText()),

                        playerService.getPlayersPositions(safari.getDriver()
                                .findElement(By.xpath(pathValidatorService.validateInformation
                                        (PathValidator.Positions.toString(), safari))).getText()),


                        playerService.getPlayersShirtNumber(safari.getDriver()
                                .findElement(By.xpath(pathValidatorService.validateInformation
                                        (PathValidator.ShirtNumber.toString(), safari))).getText()),

                      playerService.getPlayerYouthClub(safari.getDriver()
                        .findElement(By.xpath(pathValidatorService.validateInformation
                                (PathValidator.FirstYouthClub.toString(), safari))).getText()));


                safari.tearDown();

                Player playerDB = player;


                playerDB.setDatabasePlaceOfBirth(playerService.setArrayToStringForDB(player.getPlaceOfBirth()));
                playerDB.setDatabasePositions(playerService.setArrayToStringForDB(player.getPositions()));
                playerRepo.save(playerDB);
                return new ResponseEntity<>(player, HttpStatus.OK);

            } catch (SessionNotCreatedException | UnreachableBrowserException e) {
                safari.tearDown();
                Thread.sleep(2000);

                continue;
            } catch (NoSuchElementException e) {
                System.out.println("No such element was found, check the if the name was spelled correct");
                safari.tearDown();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } catch (TimeoutException e) {
                safari.tearDown();
                Thread.sleep(2000);

                continue;
            }
         catch (DateTimeParseException e) {
            safari.tearDown();
            Thread.sleep(2000);
            System.out.println(e);
            break;
        }





        return null;
    }

    @PostMapping(value = "/search1")
    public List<Player> getPlayers(@RequestBody String[] playerName) throws InterruptedException {
        List<Player> players = new ArrayList<>(playerName.length);
        for (int i = 0; i < playerName.length; i++) {

            boolean StartSelenium = false;

            String dbName = playerName[i];
            dbName = dbName.replaceAll("_", " ");


            if (playerRepo.findByName(dbName) == null) {
                StartSelenium = true;
            } else {

                Player DatebasePlayer = playerRepo.findByName(dbName);
                DatebasePlayer.setPositions(playerService.getPlayersPositions(DatebasePlayer.getDatabasePositions()));
                DatebasePlayer.setPlaceOfBirth(playerService.getPlayersBirthOfPlace(DatebasePlayer.getDatabasePlaceOfBirth()));

                players.add(DatebasePlayer);
            }

            while (StartSelenium)

                try {

                    System.setProperty(safariWebDriver, safariWebDriverPath);
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    safari = new Safari(options);
                    playerName[i] = playerName[i].strip();

                    pathValidatorService = new PathValidatorService();

                    playerService = new PlayerService();
                    safari.getDriver().navigate().to("https://en.wikipedia.org/wiki/" + playerName[i]);
                    safari.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                    Player player = new Player(
                            playerService.getPersonName(safari.getDriver().
                                    findElement(By.xpath(XPath.name.toString())).getText()),

                            playerService.getPersonFullName(safari.getDriver()
                                    .findElement(By.xpath(pathValidatorService.validateInformation
                                            (PathValidator.FullName.toString(), safari))).getText()),

                            playerService.getPlayersBirthOfPlace(safari.getDriver()
                                    .findElement(By.xpath(pathValidatorService.validateInformation
                                            (PathValidator.PlaceOfBirth.toString(), safari))).getText()),

                            playerService.getPersonBirthDate(safari.getDriver().
                                    findElement(By.xpath(pathValidatorService.validateInformation
                                            (PathValidator.DateOfBirth.toString(), safari))).getText()), //Tar lång tid

                            playerService.getPersonAge(playerService.getPersonBirthDate(safari.getDriver().
                                    findElement(By.xpath(pathValidatorService.validateInformation
                                            (PathValidator.DateOfBirth.toString(), safari))).getText())), //Tar lång tid


                            playerService.getPlayerHeight(safari.getDriver()
                                    .findElement(By.xpath(pathValidatorService.validateInformation
                                            (PathValidator.Height.toString(), safari))).getText()),

                            playerService.getPlayersCurrentClub(safari.getDriver()
                                    .findElement(By.xpath(pathValidatorService.validateInformation
                                            (PathValidator.CurrentClub.toString(), safari))).getText()),

                            playerService.getPlayersPositions(safari.getDriver()
                                    .findElement(By.xpath(pathValidatorService.validateInformation
                                            (PathValidator.Positions.toString(), safari))).getText()),


                            playerService.getPlayersShirtNumber(safari.getDriver()
                                    .findElement(By.xpath(pathValidatorService.validateInformation
                                            (PathValidator.ShirtNumber.toString(), safari))).getText()),

                   playerService.getPlayerYouthClub(safari.getDriver()
                            .findElement(By.xpath(pathValidatorService.validateInformation
                                    (PathValidator.FirstYouthClub.toString(), safari))).getText()));
                    safari.tearDown();
                    Player playerDB = player;


                    playerDB.setDatabasePlaceOfBirth(playerService.setArrayToStringForDB(player.getPlaceOfBirth()));
                    playerDB.setDatabasePositions(playerService.setArrayToStringForDB(player.getPositions()));
                    playerRepo.save(playerDB);
                    players.add(player);
                    break;

                } catch (SessionNotCreatedException | UnreachableBrowserException e) {
                    safari.tearDown();
                    Thread.sleep(2000);

                    continue;
                } catch (NoSuchElementException e) {
                    System.out.println("No such element was found, check the if the name was spelled correct");
                    safari.tearDown();
                    break;
                } catch (TimeoutException e) {
                    safari.tearDown();
                    Thread.sleep(2000);

                    continue;
                }


        }

        return players;


    }

}
