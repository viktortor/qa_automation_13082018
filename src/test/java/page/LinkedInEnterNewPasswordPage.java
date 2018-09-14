package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * LinkedInEnterNewPasswordPage Page Object class
 */
public class LinkedInEnterNewPasswordPage extends LinkedInBasePage {
    @FindBy(xpath = "//*[@id='confirm-password-reset-form']")
    WebElement confirmPasswordResetForm;

    @FindBy(xpath = "//*[@id='newPassword']")
    WebElement newPasswordField;

    @FindBy(xpath = "//*[@id='confirmPassword']")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//*[@id='reset-password-submit-button']")
    WebElement submitButton;




    /**
     * Constructor for LinkedInEnterNewPasswordPage.
     *
     * @param driver - driver instance from tests.
     */
    public LinkedInEnterNewPasswordPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * Verify is expected Page Loaded
     *
     * @return true if page loaded and false if page doesn't load
     */
    public boolean isPageLoaded() {
        return getCurrentUrl().contains("password-reset?requestSubmissionId")
                && getCurrentTitle().contains("Reset Your Password | LinkedIn")
                && confirmPasswordResetForm.isDisplayed();
    }


    /**
     * Enter new password into two fields: newPasswordField and confirmPasswordField
     *
     * @param userNewPassword - String with new userPassword
     *
     * @return PageObject LinkedInPasswordChangedSuccessfullyPage
     */
    public LinkedInPasswordChangedSuccessfullyPage newPassword(String userNewPassword) {
        newPasswordField.sendKeys(userNewPassword);
        confirmPasswordField.sendKeys(userNewPassword);
        submitButton.click();
        return new LinkedInPasswordChangedSuccessfullyPage(driver);

    }
}
