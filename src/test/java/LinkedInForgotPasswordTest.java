import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedInForgotPasswordTest {
    WebDriver driver;
    LinkedInLoginPage linkedInLoginPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        linkedInLoginPage = new LinkedInLoginPage(driver);
    }

    @AfterMethod
    public void afterMethod(){driver.quit();}




    @Test
    public void successfullReNewPasswordTest () {
        String userEmail = "getjman1@meta.ua";
        String userNewPassword = "Qwertyu-1";

        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        LinkedInRequestPasswordResetPage requestPasswordResetPage = linkedInLoginPage.forgotPassword();
        Assert.assertTrue(requestPasswordResetPage.isPageLoaded(),"Request Password Reset page is not loaded");
        LinkedInRequestPasswordResetSubmitPage requestPasswordResetSubmitPage = requestPasswordResetPage.searchAccount(userEmail);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(requestPasswordResetSubmitPage.isPageLoaded(),"Request Password Reset Submit page is not loaded");
        try {
            sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LinkedInEnterNewPasswordPage enterNewPasswordPage = requestPasswordResetSubmitPage.tempMethod();
        Assert.assertTrue(enterNewPasswordPage.isPageLoaded(),"Enter New Password page is not loaded");
        LinkedInPasswordChangedSuccessfullyPage passwordChangedSuccessfullyPage = enterNewPasswordPage.newPassword(userNewPassword);
        Assert.assertTrue(passwordChangedSuccessfullyPage.isPageLoaded(),"password Changed Successfully page is not loaded");
        LinkedInHomePage linkedInHomePage = passwordChangedSuccessfullyPage.goToHomePage();
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(linkedInHomePage.isPageLoaded(),"Home page is not loaded");






    }


}