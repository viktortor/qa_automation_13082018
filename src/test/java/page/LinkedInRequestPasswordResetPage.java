package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class LinkedInRequestPasswordResetPage extends LinkedInBasePage {

    @FindBy(xpath = "//*[@id='reset-password-submit-button']")
    WebElement findAccountButton;


    @FindBy(xpath = "//*[@id='username']")
    WebElement userEmailField;




    public LinkedInRequestPasswordResetPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isPageLoaded() {
        return getCurrentUrl().contains("uno-reg-guest-home-forgot-password")
                && getCurrentTitle().contains("Reset Password | LinkedIn")
                && findAccountButton.isDisplayed();
    }

    public LinkedInRequestPasswordResetSubmitPage searchAccount(String userEmail) {
        GMailService gMailService = new GMailService();
        gMailService.connect();

        userEmailField.sendKeys(userEmail);
        findAccountButton.click();
// это должно быть в другом  методе на странице где надпись - проверьте почту. для этого этот разорванный метод необходимо связать через базовую страницу.
        String messageSubject = "данное сообщение содержит ссылку для изменения пароля";
        String messageTo = "getjman1@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";


        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 60);
        System.out.println("Content: " + message);

        //

        return new LinkedInRequestPasswordResetSubmitPage(driver);
    }
}
