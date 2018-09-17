package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedInHomePage;
import page.LinkedInLoginSubmitPage;

/**
 * LinkedInLogin Test Object class
 */
public class LinkedinLoginTest extends LinkedInBaseTest{



    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "getjman1@gmail.com", "Qwertyu-2" },
                { "getJMan1@gmail.com", "Qwertyu-2" }
        };
    }


    @DataProvider
    public Object[][] emptyDataProvider() {
        return new Object[][]{
                { "getjman1@meta.ua", "" },
                { "", "Qwertyu-1" },
                { "", "" },
                { "            ", "Qwertyu-1" },
                { "getjman1@meta.ua", "            " },
                { "             ", "            " },
                { "              ", "" },
                { "", "            " }
        };
    }


    @DataProvider
    public Object[][] invalidDataProvider() {
        return new Object[][]{
                { "abcdefg@bcd.fds", "Wrong123", "Hmm, we don't recognize that email. Please try again.", "" },
                { "getjman1@metaua", "Wrong123", "Please enter a valid email address.", "" },
                { "getjman1meta.ua", "Wrong123", "Please enter a valid email address.", "" },
                { "getj man1@meta.ua", "Wrong123", "Please enter a valid email address.", "" },
                { "getjman1@me ta.ua", "Wrong123", "Please enter a valid email address.", "" },
                { "@meta.ua", "Wrong123", "Please enter a valid email address.", "" },
                { "getjman1@", "Wrong123", "Please enter a valid email address.", "" },
                { "getjman1@meta.ua", "short", "", "The password you provided must have at least 6 characters." },
                { "getjman1@meta.ua", "Wrong123", "", "Hmm, that's not the right password. Please try again or request a new one." },
                { "qwertyuiopqwertyuiiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyyuiopqwertyuiop@bcd.fds", "Wrong123", "The text you provided is too long (the maximum length is 128 characters, your text contains 140 characters).", "" },
                { "getjman1@meta.ua", "qwertyuiopqwertyuiiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyyuiopqwertyuiopqwertyuiopqwertyuiiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyyuiopqwertyuiopqwertyuiopqwertyuiiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyyuiopqwertyuiopqwertyuiopqwertyuiiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyyuiopqwertyuiop", "", "The password you provided must have at most 400 characters." },
                { "a@b.c", "Wrong", "Please enter a valid email address.", "The password you provided must have at least 6 characters." }
        };
    }


    /**
     * Verify successful user Login.
     *
     * Preconditions:
     * - Open new browser.
     * - Navigate to linkedin.com
     *
     * Scenario:
     * - Verify that login page is loaded.
     * - Enter userEmail.
     * - Enter userPassword.
     * - Click on 'Sign in' button.
     * - Verify Home page is loaded.
     */
    @Test(dataProvider = "validDataProvider")
    public void successfullLoginTest (String userEmail, String userPassword) {


        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login(userEmail, userPassword);

        Assert.assertTrue(linkedInHomePage.isPageLoaded(),"Home page is not loaded");

    }


    /**
     * checking the inability to login with an empty username and / or password
     *
     *  Preconditions:
     * - Open new browser.
     * - Navigate to linkedin.com
     *
     * Scenario:
     * - Verify that login page is loaded.
     * - Enter empty userEmail (empty userPassword)
     * - Verify that 'Sign in' button is disabled.
     */
    @Test (dataProvider = "emptyDataProvider")
    public void emptyUserEmailAndUserPasswordTest(String userEmail, String userPassword) {

        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage = linkedInLoginPage.login(userEmail, userPassword);

        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
    }


    /**
     * checking negativ login with incorrect username and / or password
     *
     * Preconditions
     * - Open new browser.
     * - Navigate to linkedin.com
     *
     * Scenario:
     * - Verify that login page is loaded.
     * - Enter wrong userEmail (wrong userPassword)
     * - Verify that Login Submit Page is loaded.
     * - Verify Email Field Alert Message and Password Field Alert Message
     *
     * @param userEmail
     * @param userPassword
     * @param userEmailFieldError
     * @param userPasswordFieldError
     */
    @Test (dataProvider = "invalidDataProvider")
    public void negativLoginTest(String userEmail, String userPassword, String userEmailFieldError, String userPasswordFieldError){
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        LinkedInLoginSubmitPage linkedInLoginSubmitPage = linkedInLoginPage.login(userEmail, userPassword);

        Assert.assertTrue(linkedInLoginSubmitPage.isPageLoaded(),"Login-Submit page is not loaded");


        Assert.assertEquals(linkedInLoginSubmitPage.getMainAlertMessage(), "There were one or more errors in your submission. Please correct the marked fields below.", "Main text is wrong");
        Assert.assertEquals(linkedInLoginSubmitPage.getWrongEmailAlertMessage(), userEmailFieldError, "EmailAlertMessage is wrong");
        Assert.assertEquals(linkedInLoginSubmitPage.getWrongPasswordAlertMessage(), userPasswordFieldError,"PasswordAlertMessage is wrong");

    }

}
