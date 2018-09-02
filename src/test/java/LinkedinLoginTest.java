import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LinkedinLoginTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }


    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "getjman1@meta.ua", "Qwertyu-1" },
                { "getJMan1@meta.ua", "Qwertyu-1" }
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
    public static Object[][] invalidDataProvider() {
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


    @Test(dataProvider = "validDataProvider")
    public void successfullLoginTest (String userEmail, String userPassword) {

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login(userEmail, userPassword);

        Assert.assertTrue(linkedInHomePage.isPageLoaded(),"Home page is not loaded");

    }


    @Test (dataProvider = "emptyDataProvider")
    public void emptyUserEmailAndUserPasswordTest(String userEmail, String userPassword) {

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage = linkedInLoginPage.login(userEmail, userPassword);

        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
    }


    @Test (dataProvider = "invalidDataProvider")
    public void negativLoginTest(String userEmail, String userPassword, String userEmailFieldError, String userPasswordFieldError){
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage.login(userEmail, userPassword);

        LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(driver);

        Assert.assertTrue(linkedInLoginSubmitPage.isPageLoaded(),"Login-Submit page is not loaded");
        Assert.assertTrue(linkedInLoginSubmitPage.isAlertMessageRight(userEmailFieldError, userPasswordFieldError),"Wrong Email Format Alert Message is incorrect");

    }

}
