import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInLoginSubmitPage extends LinkedInBasePage {

    @FindBy(xpath = "//div[@role='alert']")
    WebElement mainAlertMessage;

    @FindBy(xpath = "//span[@id='session_key-login-error']")
    WebElement wrongEmailAlertMessage;

    @FindBy(xpath = "//span[@id='session_password-login-error']")
    WebElement wrongPasswordAlertMessage;


    public LinkedInLoginSubmitPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getMainAlertMessage(){
        return mainAlertMessage.getText();
    }
    public String getWrongEmailAlertMessage(){
        return wrongEmailAlertMessage.getText();
    }
    public String getWrongPasswordAlertMessage(){
        return wrongPasswordAlertMessage.getText();
    }

    public boolean isPageLoaded() {
        return getCurrentUrl().contains("uas/login-submit")
                && getCurrentTitle().contains("Sign In to LinkedIn")
                && mainAlertMessage.isDisplayed();
    }

}
