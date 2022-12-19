package se.sh1re.Knower.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        safariDriver.navigate().to("https://en.wikipedia.org/wiki/Eden_Hazard");
        safariDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    @AfterEach
    void tearDown() {
        safariDriver.close();
    }


    @Test
    void getPersonName() {
    }
}