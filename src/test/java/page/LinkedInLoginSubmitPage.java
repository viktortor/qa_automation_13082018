package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * LinkedInLoginSubmitPage Page Object class
 */
public class LinkedInLoginSubmitPage extends LinkedInBasePage {

    @FindBy(xpath = "//div[@role='alert']")
    WebElement mainAlertMessage;

    @FindBy(xpath = "//span[@id='session_key-login-error']")
    WebElement wrongEmailAlertMessage;

    @FindBy(xpath = "//span[@id='session_password-login-error']")
    WebElement wrongPasswordAlertMessage;


    /**
     * Constructor for LinkedInLoginSubmitPage.
     *
     * @param driver - driver instance from tests.
     */
    public LinkedInLoginSubmitPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementVisible(mainAlertMessage, 10);
    }

    /**
     * Get Main Alert Message
     *
     * @return String text message
     */
    public String getMainAlertMessage(){
        return mainAlertMessage.getText();
    }

    /**
     * Get Email Alert Message
     *
     * @return String text message
     */
    public String getWrongEmailAlertMessage(){
        return wrongEmailAlertMessage.getText();
    }

    /**
     * Get Password Alert Message
     *
     * @return String text message
     */
    public String getWrongPasswordAlertMessage(){
        return wrongPasswordAlertMessage.getText();
    }

    /**
     * Verify is expected Page Loaded
     *
     * @return true if page loaded and false if page doesn't load
     */
    public boolean isPageLoaded() {
        return getCurrentUrl().contains("uas/login-submit")
                && getCurrentTitle().contains("Sign In to LinkedIn")
                && mainAlertMessage.isDisplayed();
    }

}
