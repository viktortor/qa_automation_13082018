package page;

import org.openqa.selenium.WebDriver;
import util.GMailService;

public class LinkedInBasePage {
    protected WebDriver driver;

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getCurrentTitle(){
        return driver.getTitle();
    }

    protected   static GMailService gMailService = new GMailService();










}
