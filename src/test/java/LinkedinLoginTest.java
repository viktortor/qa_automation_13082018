import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedinLoginTest {
    WebDriver driver; //виден всему классу
    //Аннотация (@) - сообщаем компилятору доп инфо - заставляем запускать наш метод
    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/"); //полный формат адреса (с https....)
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test //(enabled = false)
    public void successfullLoginTest () {

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver); //объявили переменную linkedInLoginPage класса LinkedInLoginPage
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage.login("getjman1@meta.ua", "Qwertyu-1");

        LinkedInHomePage linkedInHomePage = new LinkedInHomePage(driver);
        Assert.assertTrue(linkedInHomePage.isPageLoaded(),"Home page is not loaded");
    }


    @Test //(priority = 1)
    public void negativLoginTest() throws InterruptedException {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver); //объявили переменную linkedInLoginPage класса LinkedInLoginPage
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage.login("a@b.c", "Wrong");

       LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(driver);
        Assert.assertTrue(linkedInLoginSubmitPage.isPageLoaded(),"Login-Submit page is not loaded");

    }

    @Test ///(priority = 1) //
    public void wrongEmailFormatWithoutDotLoginTest() throws InterruptedException {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver); //объявили переменную linkedInLoginPage класса LinkedInLoginPage
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage.login("getjman1@metaua", "Wrong");

        LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(driver);
        Assert.assertTrue(linkedInLoginSubmitPage.isPageLoaded(),"Login-Submit page is not loaded");
        Assert.assertTrue(linkedInLoginSubmitPage.isWrongEmailFormatAlertMessageRight(),"Wrong Email Format Alert Message is incorrect");

    }


    @Test ///(priority = 1) //
    public void wrongEmailFormatWithoutAtLoginTest() throws InterruptedException {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver); //объявили переменную linkedInLoginPage класса LinkedInLoginPage
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage.login("getjman1meta.ua", "Wrong");

        LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(driver);
        Assert.assertTrue(linkedInLoginSubmitPage.isPageLoaded(),"Login-Submit page is not loaded");
        Assert.assertTrue(linkedInLoginSubmitPage.isWrongEmailFormatAlertMessageRight(),"Wrong Email Format Alert Message is incorrect");

    }


    @Test ///(priority = 1) //
    public void wrongEmailFormatAccountWithSpaceLoginTest() throws InterruptedException {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver); //объявили переменную linkedInLoginPage класса LinkedInLoginPage
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage.login("getj man1@meta.ua", "Wrong");

        LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(driver);
        Assert.assertTrue(linkedInLoginSubmitPage.isPageLoaded(),"Login-Submit page is not loaded");
        Assert.assertTrue(linkedInLoginSubmitPage.isWrongEmailFormatAlertMessageRight(),"Wrong Email Format Alert Message is incorrect");

    }

    @Test ///(priority = 1) //
    public void wrongEmailFormatDomainWithSpaceLoginTest() throws InterruptedException {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver); //объявили переменную linkedInLoginPage класса LinkedInLoginPage
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage.login("getjman1@me ta.ua", "Wrong");

        LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(driver);
        Assert.assertTrue(linkedInLoginSubmitPage.isPageLoaded(),"Login-Submit page is not loaded");
        Assert.assertTrue(linkedInLoginSubmitPage.isWrongEmailFormatAlertMessageRight(),"Wrong Email Format Alert Message is incorrect");

    }

    @Test ///(priority = 1) //
    public void wrongEmailFormatWithoutAccountLoginTest() throws InterruptedException {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver); //объявили переменную linkedInLoginPage класса LinkedInLoginPage
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage.login("@meta.ua", "Wrong");

        LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(driver);
        Assert.assertTrue(linkedInLoginSubmitPage.isPageLoaded(),"Login-Submit page is not loaded");
        Assert.assertTrue(linkedInLoginSubmitPage.isWrongEmailFormatAlertMessageRight(),"Wrong Email Format Alert Message is incorrect");

    }

    @Test ///(priority = 1) //
    public void wrongEmailFormatWithoutDomainLoginTest() throws InterruptedException {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver); //объявили переменную linkedInLoginPage класса LinkedInLoginPage
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage.login("getjman1@", "Wrong");

        LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(driver);
        Assert.assertTrue(linkedInLoginSubmitPage.isPageLoaded(),"Login-Submit page is not loaded");
        Assert.assertTrue(linkedInLoginSubmitPage.isWrongEmailFormatAlertMessageRight(),"Wrong Email Format Alert Message is incorrect");

    }

    @Test ///(priority = 1)
    public void unknownEmailLoginTest() throws InterruptedException {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver); //объявили переменную linkedInLoginPage класса LinkedInLoginPage
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage.login("abcdefg@bcd.fds", "Wrong123");

        LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(driver);
        Assert.assertTrue(linkedInLoginSubmitPage.isPageLoaded(),"Login-Submit page is not loaded");
        Assert.assertTrue(linkedInLoginSubmitPage.isUnknownEmailAlertMessageRight(),"Unknown Email Alert Message is incorrect");
    }

    @Test ///(priority = 1)
    public void shortPasswordLoginTest() throws InterruptedException {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver); //объявили переменную linkedInLoginPage класса LinkedInLoginPage
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage.login("getjman1@meta.ua", "short");

        LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(driver);
        Assert.assertTrue(linkedInLoginSubmitPage.isPageLoaded(),"Login-Submit page is not loaded");
        Assert.assertTrue(linkedInLoginSubmitPage.isShortPasswordAlertMessageRight(),"Short Password Alert Message is incorrect");
    }

    @Test ///(priority = 1)
    public void incorrectPasswordLoginTest() throws InterruptedException {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver); //объявили переменную linkedInLoginPage класса LinkedInLoginPage
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage.login("getjman1@meta.ua", "moreThan6signs");

        LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(driver);
        Assert.assertTrue(linkedInLoginSubmitPage.isPageLoaded(),"Login-Submit page is not loaded");
        Assert.assertTrue(linkedInLoginSubmitPage.isIncorrectPasswordAlertMessageRight(),"Incorrect Password Alert Message is incorrect");

    }

    @Test ///(priority = 1)
    public void longEmailLoginTest() throws InterruptedException {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver); //объявили переменную linkedInLoginPage класса LinkedInLoginPage
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage.login("qwertyuiopqwertyuiiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyyuiopqwertyuiop@bcd.fds", "moreThan6signs");

        LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(driver);
        Assert.assertTrue(linkedInLoginSubmitPage.isPageLoaded(),"Login-Submit page is not loaded");
        Assert.assertTrue(linkedInLoginSubmitPage.isLongEmailAlertMessageRight(),"Long Email Alert Message is incorrect");
    }

    @Test ///(priority = 1)
    public void longPasswordLoginTest() throws InterruptedException {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver); //объявили переменную linkedInLoginPage класса LinkedInLoginPage
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage.login("getjman1@meta.ua", "qwertyuiopqwertyuiiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyyuiopqwertyuiopqwertyuiopqwertyuiiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyyuiopqwertyuiopqwertyuiopqwertyuiiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyyuiopqwertyuiopqwertyuiopqwertyuiiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyyuiopqwertyuiop");

        LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(driver);
        Assert.assertTrue(linkedInLoginSubmitPage.isPageLoaded(),"Login-Submit page is not loaded");
        Assert.assertTrue(linkedInLoginSubmitPage.isLongPasswordAlertMessageRight(),"Long Password Alert Message is incorrect");
    }

    @Test ///(priority = 1)
    public void emptyPasswordLoginTest() throws InterruptedException {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver); //объявили переменную linkedInLoginPage класса LinkedInLoginPage
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage.login("name@domain.com", "");


        Assert.assertFalse(linkedInLoginPage.isSignInButtonActive(), "SignIn button is Active");
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"It is not Login page");
    }

    @Test ///(priority = 1)
    public void emptyEmailLoginTest() throws InterruptedException {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver); //объявили переменную linkedInLoginPage класса LinkedInLoginPage
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage.login("", "Password");

        Assert.assertFalse(linkedInLoginPage.isSignInButtonActive(), "SignIn button is Active");
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"It is not Login page");
    }

}
