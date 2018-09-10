package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

import static java.lang.Thread.sleep;

public class LinkedInForgotPasswordTest extends LinkedInBaseTest{

    @Test
    public void successfullReNewPasswordTest () {
        String userEmail = "getjman1@gmail.com";
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
//        try {
//            sleep(60000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
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