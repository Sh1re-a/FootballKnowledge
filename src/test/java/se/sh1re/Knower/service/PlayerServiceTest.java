package se.sh1re.Knower.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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



      //  safariDriver.findElement(By.xpath("//*[@id=\"notice\"]/div[3]/div[1]/button")).click();

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
        System.out.println(text);
    }

    @Test
    void getPersonAgeAndBirthDate() {
        String age = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[4]/td";
        String text = safariDriver.findElement(By.xpath(age)).getText();
        System.out.println(text);
    }
}