package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;

/**
 * LinkedIn Base Page Object class. Contains common elements of all Pages
 */
public class LinkedInBasePage {
    protected WebDriver driver;

    protected String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    protected String getCurrentTitle(){
        return driver.getTitle();
    }

    protected   static GMailService gMailService = new GMailService();

    /**
     * It waits until the object becomes visible (page is loaded)
     *
     * @param webElement - Expected object, which must be on the page
     * @param timeOutInSec - max timeOut In Sec
     *
     * @return Expected visible webelement
     */
    protected WebElement waitUntilElementVisible(WebElement webElement, int timeOutInSec){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        return wait.until(ExpectedConditions.visibilityOf(webElement));

    }


    /**
     * It waits until the object becomes Clickable (page is loaded)
     *
     * @param webElement - Expected object, which must be on the page
     * @param timeOutInSec - max timeOut In Sec
     *
     * @return Expected Clickable webelement
     */
    protected WebElement waitUntilElementClickable(WebElement webElement, int timeOutInSec){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));

    }










}
