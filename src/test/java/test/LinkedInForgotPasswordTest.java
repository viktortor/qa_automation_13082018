package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

/**
 *  linkedInForgotPassword Test Object class
 */
public class LinkedInForgotPasswordTest extends LinkedInBaseTest{

    /**
     * check replace a forgotten password
     *
     * Preconditions:
     * - Open new browser.
     * - Navigate to linkedin.com
     *
     * Scenario:
     * - Verify that login page is loaded.
     * - click forgotPassword Link
     * - Verify that request Password Reset Page is loaded.
     * - enter user Email
     * - click findAccount Button
     * - Verify that request Password Reset Submit Page is loaded.
     * - check user EmailBox
     * - find resetPassword Link in the letter
     * - follow the link
     * - Verify that enterNewPassword Page is loaded.
     * - enter New Password into two fields
     * - click submit Button
     * - Verify that password Changed Successfully page is loaded.
     * - click goToHome button
     * - Verify that HomePage is loaded.
     */
    @Test
    public void successfullReNewPasswordTest () {
        String userEmail = "getjman1@gmail.com";
        String userNewPassword = "Qwertyu-2";

        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        LinkedInRequestPasswordResetPage requestPasswordResetPage = linkedInLoginPage.forgotPassword();
        Assert.assertTrue(requestPasswordResetPage.isPageLoaded(),"Request Password Reset page is not loaded");
        LinkedInRequestPasswordResetSubmitPage requestPasswordResetSubmitPage = requestPasswordResetPage.searchAccount(userEmail);

        Assert.assertTrue(requestPasswordResetSubmitPage.isPageLoaded(),"Request Password Reset Submit page is not loaded");

        LinkedInEnterNewPasswordPage enterNewPasswordPage = requestPasswordResetSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(enterNewPasswordPage.isPageLoaded(),"Enter New Password page is not loaded");
        LinkedInPasswordChangedSuccessfullyPage passwordChangedSuccessfullyPage = enterNewPasswordPage.newPassword(userNewPassword);
        Assert.assertTrue(passwordChangedSuccessfullyPage.isPageLoaded(),"password Changed Successfully page is not loaded");
        LinkedInHomePage linkedInHomePage = passwordChangedSuccessfullyPage.goToHomePage();
        Assert.assertTrue(linkedInHomePage.isPageLoaded(),"Home page is not loaded");

    }


}