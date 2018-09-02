import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInLoginSubmitPage {
    private WebDriver driver;

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


    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public String getCurrentTitle(){
        return driver.getTitle();
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
        return getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit")
                && getCurrentTitle().equals("Sign In to LinkedIn")
                && getMainAlertMessage().equals("There were one or more errors in your submission. Please correct the marked fields below.");
    }


    public boolean isAlertMessageRight(String userEmailFieldError, String userPasswordFieldError){
        return getWrongEmailAlertMessage().equals(userEmailFieldError)
                && getWrongPasswordAlertMessage().equals(userPasswordFieldError);
    }

}
