import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInEnterNewPasswordPage extends LinkedInBasePage {
    @FindBy(xpath = "//*[@id='confirm-password-reset-form']")
    WebElement confirmPasswordResetForm;

    @FindBy(xpath = "//*[@id='newPassword']")
    WebElement newPasswordField;

    @FindBy(xpath = "//*[@id='confirmPassword']")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//*[@id='reset-password-submit-button']")
    WebElement submitButton;





    public LinkedInEnterNewPasswordPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isPageLoaded() {
        return getCurrentUrl().contains("password-reset?requestSubmissionId")
                && getCurrentTitle().contains("Reset Your Password | LinkedIn")
                && confirmPasswordResetForm.isDisplayed();
    }


    public LinkedInPasswordChangedSuccessfullyPage newPassword(String userNewPassword) {
        newPasswordField.sendKeys(userNewPassword);
        confirmPasswordField.sendKeys(userNewPassword);
        submitButton.click();
        return new LinkedInPasswordChangedSuccessfullyPage(driver);

    }
}
