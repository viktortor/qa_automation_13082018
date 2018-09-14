package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * LinkedInPasswordChangedSuccessfullyPage Page Object class
 */
public class LinkedInPasswordChangedSuccessfullyPage extends LinkedInBasePage {

    @FindBy(xpath = "//*[@id='reset-password-submit-button']")
    WebElement submitButton;


    /**
     * Constructor for LinkedInLoginSubmitPage.
     *
     * @param driver - driver instance from tests.
     */
    public LinkedInPasswordChangedSuccessfullyPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * Verify is expected Page Loaded
     *
     * @return true if page loaded and false if page doesn't load
     */
    public boolean isPageLoaded() {
        return getCurrentUrl().contains("password-reset-submit")
                && getCurrentTitle().contains("You've successfully reset your password. | LinkedIn")
                && submitButton.isDisplayed();
    }


    /**
     * Click submitButton to go To HomePage
     *
     * @return PageObject LinkedInHomePage
     */
    public LinkedInHomePage goToHomePage() {
        submitButton.click();
        return new LinkedInHomePage(driver);

    }
}
