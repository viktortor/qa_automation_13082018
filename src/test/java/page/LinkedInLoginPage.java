package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

/**
 * LinkedInLogin Page Object class
 */
public class LinkedInLoginPage extends LinkedInBasePage {

    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@class='link-forgot-password']")
    private WebElement forgotPasswordLink;


    /**
     * Constructor for LinkedInLoginPage.
     *
     * @param driver - driver instance from tests.
     */
    public LinkedInLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * User login by username/password.
     * @param userEmail - String with userEmail.
     * @param userPassword - String with userPassword.
     * @param <T> - generic type to return different PageObjects.
     * @return one of corresponding PageObjects LinkedInLoginPage/LinkedInHomePage/LinkedInLoginSubmitPage.
     */
    public <T> T login(String userEmail, String userPassword){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        try {
            sleep (3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        if (getCurrentUrl().contains("/feed")) {
            return (T) new LinkedInHomePage(driver);
        }
        if (getCurrentUrl().contains("/login-submit")) {
            return (T) new LinkedInLoginSubmitPage(driver);
        }
        else {
            return (T) this;
        }
    }


    public boolean isPageLoaded(){
        return getCurrentUrl().contains("https://www.linkedin.com/")
                && getCurrentTitle().equals("LinkedIn: Log In or Sign Up")
                && signInButton.isDisplayed();
    }

//    public boolean isSignInButtonActive(){
//        return  signInButton.isEnabled();
//    }

    public LinkedInRequestPasswordResetPage forgotPassword() {
        forgotPasswordLink.click();
        return new LinkedInRequestPasswordResetPage(driver);
    }
}
