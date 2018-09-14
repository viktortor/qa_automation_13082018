package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * LinkedInRequestPasswordResetSubmitPage Page Object class
 */
public class LinkedInRequestPasswordResetSubmitPage extends LinkedInBasePage {

    @FindBy(xpath = "//*[@class='different__email different__email--desktop']")
    WebElement tryDifferentEmailButton;


    @FindBy(xpath = "//*[@id='username']")
    WebElement userEmailField;


    /**
     * Constructor for LinkedInRequestPasswordResetSubmitPage.
     *
     * @param driver - driver instance from tests.
     */
    public LinkedInRequestPasswordResetSubmitPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * Verify is expected Page Loaded
     *
     * @return true if page loaded and false if page doesn't load
     */
    public boolean isPageLoaded() {
        return
//                getCurrentUrl().contains("request-password-reset-submit")
//                   && getCurrentTitle().equals("Please check your mail for reset password link.  | LinkedIn")
//                &&
                tryDifferentEmailButton.isDisplayed();
    }


    /**
     * get message and go to the resetPasswordLink from email
     *
     * @return PageObject LinkedInEnterNewPasswordPage
     */
    public LinkedInEnterNewPasswordPage navigateToLinkFromEmail() {

        String messageSubject = "данное сообщение содержит ссылку для изменения пароля";
        String messageTo = "getjman1@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 60);
        System.out.println("Content: " + message);


        String resetPasswordLink =
                StringUtils.substringBetween(message,
                        "Чтобы изменить пароль в LinkedIn, нажмите <a href=\"",
                        "\" style").replace("amp;", "");

        driver.get(resetPasswordLink);

        return new LinkedInEnterNewPasswordPage(driver);
    }

















}
