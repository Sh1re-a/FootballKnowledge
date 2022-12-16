package se.sh1re.Knower.service;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;
import se.sh1re.Knower.models.Person;

import java.util.concurrent.TimeUnit;

public class PersonService {

    private Person person;


    private static final String safariWebDriver = "webdriver.safari.driver";
    private static final String safariWebDriverPath = "/usr/bin/safaridriver";
    private static SafariDriver safariDriver;



    public void initializeDriver(String webSiteURL) {
        System.setProperty(safariWebDriver, safariWebDriverPath);
        safariDriver = new SafariDriver();
        safariDriver.navigate().to(webSiteURL);
        safariDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public Boolean humanCheck() {
        return  false;
    }


    public String getPersonName() {
        String name = safariDriver.findElement(By.className("")).getText();
        return name;
    }

    /*
    public void clickButton(String findElementById, SafariDriver safariDriver){
        WebElement m=safariDriver.
                findElement(By.id(findElementById));
        m.click();
    }

    public void writeInForm(String findElementById, String inputText,SafariDriver safariDriver){
        safariDriver.findElement(By.id(findElementById)).sendKeys(inputText);
    }

    public String gettingTextFromWebsite(String findElementById, SafariDriver safariDriver){
        String text = safariDriver.findElement(By.id(findElementById)).getText();
        return text;
    }

    public void usingThreadSleep(int millisSecond){
        try{
            Thread.sleep(millisSecond);
        } catch (InterruptedException e){
            System.out.println("something went wrong");
        }
    }

    public void closeDriver(SafariDriver safariDriver){
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

    public void makeItFullScreen(SafariDriver safariDriver){
        safariDriver.manage().window().maximize();
    }


     */

}
