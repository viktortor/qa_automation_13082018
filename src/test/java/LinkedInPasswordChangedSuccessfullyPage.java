import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInPasswordChangedSuccessfullyPage extends LinkedInBasePage {

    @FindBy(xpath = "//*[@id='reset-password-submit-button']")
    WebElement submitButton;





    public LinkedInPasswordChangedSuccessfullyPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isPageLoaded() {
        return getCurrentUrl().contains("password-reset-submit")
                && getCurrentTitle().contains("You've successfully reset your password. | LinkedIn")
                && submitButton.isDisplayed();
    }


    public LinkedInHomePage goToHomePage() {
        submitButton.click();
        return new LinkedInHomePage(driver);

    }
}
