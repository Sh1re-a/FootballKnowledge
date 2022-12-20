package se.sh1re.Knower.service;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import se.sh1re.Knower.models.Player;

import java.util.concurrent.TimeUnit;

public class PlayerService {

    private Player player;


    private static final String safariWebDriver = "webdriver.safari.driver";
    private static final String safariWebDriverPath = "/usr/bin/safaridriver";
    private static SafariDriver safariDriver;



    public void initializeDriver(String player) {
        System.setProperty(safariWebDriver, safariWebDriverPath);
        safariDriver = new SafariDriver();
        safariDriver.navigate().to(player);
        safariDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }



    public String getPersonName(String className) {
        String name = safariDriver.findElement(new By.ByXPath("/html[@class='hydrated']/body/div[@id='main']/main/div[@class='row']/div[@class='large-8 columns']/div[@class='box viewport-tracking'][1]/div[@class='row collapse']/div[@class='large-6 large-pull-6 small-12 columns spielerdatenundfakten']/div[@class='info-table info-table--right-space']/span[@class='info-table__content info-table__content--bold'][1]")).getText();
        return name;
    }



}
