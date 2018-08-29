import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedInLoginSubmitPage {
    private WebDriver driver;
    WebElement mainAlertMessage;
    WebElement wrongEmailAlertMessage;
    WebElement wrongPasswordAlertMessage;


    public LinkedInLoginSubmitPage(WebDriver driver){
        this.driver = driver;
        initElements();
    }

    private void initElements(){
        mainAlertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
        wrongEmailAlertMessage = driver.findElement(By.xpath("//span[@id='session_key-login-error']"));
        wrongPasswordAlertMessage = driver.findElement(By.xpath("//span[@id='session_password-login-error']"));


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
    public boolean isWrongEmailFormatAlertMessageRight(){
        return getWrongEmailAlertMessage().equals("Please enter a valid email address.");
    }
    public boolean isUnknownEmailAlertMessageRight(){
        return getWrongEmailAlertMessage().equals("Hmm, we don't recognize that email. Please try again.");
    }
    public boolean isShortPasswordAlertMessageRight(){
        return getWrongPasswordAlertMessage().equals("The password you provided must have at least 6 characters.");
    }
    public boolean isIncorrectPasswordAlertMessageRight(){
        return getWrongPasswordAlertMessage().equals("Hmm, that's not the right password. Please try again or request a new one.");
    }
    public boolean isLongEmailAlertMessageRight(){
        return getWrongEmailAlertMessage().equals("The text you provided is too long (the maximum length is 128 characters, your text contains 140 characters).");
    }
    public boolean isLongPasswordAlertMessageRight(){
        return getWrongPasswordAlertMessage().equals("The password you provided must have at most 400 characters.");
    }
}
