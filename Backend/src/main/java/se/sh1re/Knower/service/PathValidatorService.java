package se.sh1re.Knower.service;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import se.sh1re.Knower.models.Path.PathValidator;
import se.sh1re.Knower.driver.Safari;
@Service
@Configurable
public class PathValidatorService {


    public PathValidatorService() {
    }


    public String validateInformation(String path, Safari safari) {
        try {
            WebElement self = safari.getDriver().findElement(By.xpath(PathValidator.tablePath.toString() + path));
            WebElement ancestor = safari.getDriver().findElement(By.xpath(PathValidator.tablePath.toString()));
            String XpathInformation = getXpath(self, ancestor);
            XpathInformation = XpathInformation.replaceAll("TH", "TD");
            XpathInformation = XpathInformation.replaceAll("th", "td");
            int counter = 0;
            for (int i = 0; i < XpathInformation.length(); i++) {
                if (XpathInformation.charAt(i) == ']') {
                    counter++;
                    if (counter == 2) {
                        XpathInformation = XpathInformation.substring(0, i + 1);
                    }
                }
            }
            return PathValidator.tablePath.toString() + XpathInformation;
        } catch (NoSuchElementException e) {
            System.out.println("Doesn't find element");
            return "Element doesn't exist";
        }
    }

    public String getFirstClub(Safari safari) {
        try {
            WebElement firstClubElement = safari.getDriver().findElement(By.xpath(PathValidator.FirstYouthClub.toString()));
            return firstClubElement.getText().trim();
        } catch (NoSuchElementException e) {
            System.out.println("First club not found");
            return "First club not found";
        }
    }


    public static String getXpath(WebElement self, WebElement ancestor) {
        int a = ancestor.findElements(By.xpath("./ancestor::*")).size();
        int s = self.findElements(By.xpath("./ancestor::*")).size();
        String path = "";
        WebElement current = self;
        for (int i = s - a; i > 0; i--) {
            String tag = current.getTagName();
            int lvl = current.findElements(By.xpath("./preceding-sibling::" + tag)).size() + 1;
            path = String.format("/%s[%d]%s", tag, lvl, path);
            current = current.findElement(By.xpath("./parent::*"));
        }
        return path;
    }

    public String getPlayerFirstYouthClub(Safari safari) {
        try {
            WebElement firstClubElement = safari.getDriver().findElement(By.xpath(PathValidator.FirstYouthClub.toString()));
            return firstClubElement.getText().trim();
        } catch (NoSuchElementException e) {
            System.out.println("Youth club not found");
            return "Youth club not found";
        }
    }
}

