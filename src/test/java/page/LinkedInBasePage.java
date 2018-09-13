package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;

public class LinkedInBasePage {
    protected WebDriver driver;

    protected String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    protected String getCurrentTitle(){
        return driver.getTitle();
    }

    protected   static GMailService gMailService = new GMailService();

    protected WebElement waitUntilElementVisible(WebElement webElement, int timeOutInSec){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        return wait.until(ExpectedConditions.visibilityOf(webElement));

    }










}
