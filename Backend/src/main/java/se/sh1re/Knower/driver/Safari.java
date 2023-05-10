package se.sh1re.Knower.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Safari {

    //public SafariDriver safariDriver;

    public ChromeDriver safariDriver;

    public Safari(ChromeOptions options) {

        safariDriver = new ChromeDriver(options);
    }

    public ChromeDriver getDriver() {

        if(safariDriver == null){
            safariDriver = new ChromeDriver();
            return safariDriver;
        }
        else{
            return safariDriver;
        }

    }

    public void tearDown() {
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
}
