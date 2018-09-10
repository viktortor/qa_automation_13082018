package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInRequestPasswordResetSubmitPage extends LinkedInBasePage {

    @FindBy(xpath = "//*[@class='different__email different__email--desktop']")
    WebElement tryDifferentEmailButton;


    @FindBy(xpath = "//*[@id='username']")
    WebElement userEmailField;




    public LinkedInRequestPasswordResetSubmitPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isPageLoaded() {
        return
//                getCurrentUrl().contains("request-password-reset-submit")
//                   && getCurrentTitle().equals("Please check your mail for reset password link.  | LinkedIn")
//                &&
                tryDifferentEmailButton.isDisplayed();
    }


    public LinkedInEnterNewPasswordPage tempMethod() {
        return new LinkedInEnterNewPasswordPage(driver);
    }
}
