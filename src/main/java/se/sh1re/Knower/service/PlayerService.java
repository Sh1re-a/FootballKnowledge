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



    public void initializeDriver(String webSiteURL) {
        System.setProperty(safariWebDriver, safariWebDriverPath);
        safariDriver = new SafariDriver();
        safariDriver.navigate().to(webSiteURL);
        safariDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }



    public String getPersonName() {
        String name = safariDriver.findElement(By.className("info-table__content info-table__content--bold")).getText();
        return name;
    }



}
