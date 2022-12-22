package se.sh1re.Knower.Driver;

import org.openqa.selenium.safari.SafariDriver;
import org.springframework.stereotype.Component;

@Component
public  class Safari {
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
}
