package se.sh1re.Knower.driver;

import org.openqa.selenium.safari.SafariDriver;
import org.springframework.stereotype.Service;


public class Safari {

    public SafariDriver safariDriver;



    public Safari() {
        safariDriver = new SafariDriver();
    }

    public SafariDriver getDriver() {

        if(safariDriver == null){
            safariDriver = new SafariDriver();
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
