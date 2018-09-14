package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * LinkedInPasswordChangedSuccessfullyPage Page Object class
 */
public class LinkedInRequestPasswordResetPage extends LinkedInBasePage {

    @FindBy(xpath = "//*[@id='reset-password-submit-button']")
    WebElement findAccountButton;


    @FindBy(xpath = "//*[@id='username']")
    WebElement userEmailField;


    /**
     * Constructor for LinkedInRequestPasswordResetPage.
     *
     * @param driver - driver instance from tests.
     */
    public LinkedInRequestPasswordResetPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * Verify is expected Page Loaded
     *
     * @return true if page loaded and false if page doesn't load
     */
    public boolean isPageLoaded() {
        return getCurrentUrl().contains("uno-reg-guest-home-forgot-password")
                && getCurrentTitle().contains("Reset Password | LinkedIn")
                && findAccountButton.isDisplayed();
    }

    /**
     * search user Account for reset password and connect to Mail box
     *
     * @param userEmail - String userEmail
     *
     * @return PageObject LinkedInRequestPasswordResetSubmitPage
     */
    public LinkedInRequestPasswordResetSubmitPage searchAccount(String userEmail) {
        gMailService.connect();
        userEmailField.sendKeys(userEmail);
        findAccountButton.click();
        return new LinkedInRequestPasswordResetSubmitPage(driver);
    }
}
