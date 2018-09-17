package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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
        assertElementIsVisible (signInButton,5, "Login page is not loaded");


    }


    /**
     * User login by username/password.
     *
     * @param userEmail - String with userEmail.
     * @param userPassword - String with userPassword.
     * @param <T> - generic type to return different PageObjects.
     *
     * @return one of corresponding PageObjects LinkedInLoginPage/LinkedInHomePage/LinkedInLoginSubmitPage.
     */
    public <T> T login(String userEmail, String userPassword){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();

        if (isUrlContains("/feed", 5)) {
            return (T) new LinkedInHomePage(driver);
        }
        if (isUrlContains("/login-submit", 5)) {
            return (T) new LinkedInLoginSubmitPage(driver);
        }
        else {
            return (T) this;
        }
    }


    /**
     * Verify is expected Page Loaded
     *
     * @return true if page loaded and false if page doesn't load
     */
    public boolean isPageLoaded(){
        return getCurrentUrl().contains("https://www.linkedin.com/")
                && getCurrentTitle().equals("LinkedIn: Log In or Sign Up")
                && signInButton.isDisplayed();
    }


    /**
     * Click to forgotPassword Link
     *
     * @return PageObject LinkedInRequestPasswordResetPage
     */
    public LinkedInRequestPasswordResetPage forgotPassword() {
        forgotPasswordLink.click();
        return new LinkedInRequestPasswordResetPage(driver);
    }
}
