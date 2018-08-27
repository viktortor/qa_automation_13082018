import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

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
    public void successfullLoginTest () throws InterruptedException {

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver); //объявили переменную linkedInLoginPage класса LinkedInLoginPage
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage.login("getjman1@meta.ua", "Qwertyu-1");


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/",
                "Home page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"LinkedIn",
                "Home page Title is wrong.");

        WebElement profileNavItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
        Assert.assertTrue(profileNavItem.isDisplayed(),
                "profileNavItem button is not displayed on Home page.");
    }
    @Test //(priority = 1)
    public void negativLoginTest() throws InterruptedException {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver); //объявили переменную linkedInLoginPage класса LinkedInLoginPage
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        linkedInLoginPage.login("a@b.c", "Wrong");

       //не забыть дома проверять тайтл и урл
        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(alertMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Alert message text is wrong.");

    }

    @Test ///(priority = 1) //
    public void wrongEmailFormatWithoutDotLoginTest() throws InterruptedException {


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/",
                "Login page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up",
                "Title is wrong.");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(signInButton.isDisplayed(),
                "signIn button is noy displayed on Login page.");
        userEmailField.sendKeys("getjman1@metaua");
        userPasswordField.sendKeys("Wrong");
        signInButton.click();

        sleep(3000);

        //не забыть дома проверять тайтл и урл

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit",
                "Home page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"Sign In to LinkedIn",
                "Home page Title is wrong.");



        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(alertMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Alert message text is wrong.");
        WebElement alertMessageWrongEmailFormat = driver.findElement(By.xpath("//span[@id='session_key-login-error']"));
        Assert.assertEquals(alertMessageWrongEmailFormat.getText(),
                "Please enter a valid email address.",
                "Alert message (loginField) text is wrong.");

    }

    @Test ///(priority = 1) //
    public void wrongEmailFormatWithoutAtLoginTest() throws InterruptedException {


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/",
                "Login page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up",
                "Title is wrong.");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(signInButton.isDisplayed(),
                "signIn button is noy displayed on Login page.");
        userEmailField.sendKeys("getjman1meta.ua");
        userPasswordField.sendKeys("Wrong");
        signInButton.click();

        sleep(3000);

        //не забыть дома проверять тайтл и урл

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit",
                "Home page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"Sign In to LinkedIn",
                "Home page Title is wrong.");



        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(alertMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Alert message text is wrong.");
        WebElement alertMessageWrongEmailFormat = driver.findElement(By.xpath("//span[@id='session_key-login-error']"));
        Assert.assertEquals(alertMessageWrongEmailFormat.getText(),
                "Please enter a valid email address.",
                "Alert message (loginField) text is wrong.");

    }


    @Test ///(priority = 1) //
    public void wrongEmailFormatAccountWithSpaceLoginTest() throws InterruptedException {


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/",
                "Login page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up",
                "Title is wrong.");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(signInButton.isDisplayed(),
                "signIn button is noy displayed on Login page.");
        userEmailField.sendKeys("getj man1@meta.ua");
        userPasswordField.sendKeys("Wrong");
        signInButton.click();

        sleep(3000);

        //не забыть дома проверять тайтл и урл

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit",
                "Home page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"Sign In to LinkedIn",
                "Home page Title is wrong.");



        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(alertMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Alert message text is wrong.");
        WebElement alertMessageWrongEmailFormat = driver.findElement(By.xpath("//span[@id='session_key-login-error']"));
        Assert.assertEquals(alertMessageWrongEmailFormat.getText(),
                "Please enter a valid email address.",
                "Alert message (loginField) text is wrong.");

    }

    @Test ///(priority = 1) //
    public void wrongEmailFormatDomainWithSpaceLoginTest() throws InterruptedException {


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/",
                "Login page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up",
                "Title is wrong.");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(signInButton.isDisplayed(),
                "signIn button is noy displayed on Login page.");
        userEmailField.sendKeys("getjman1@me ta.ua");
        userPasswordField.sendKeys("Wrong");
        signInButton.click();

        sleep(3000);

        //не забыть дома проверять тайтл и урл

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit",
                "Home page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"Sign In to LinkedIn",
                "Home page Title is wrong.");



        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(alertMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Alert message text is wrong.");
        WebElement alertMessageWrongEmailFormat = driver.findElement(By.xpath("//span[@id='session_key-login-error']"));
        Assert.assertEquals(alertMessageWrongEmailFormat.getText(),
                "Please enter a valid email address.",
                "Alert message (loginField) text is wrong.");

    }

    @Test ///(priority = 1) //
    public void wrongEmailFormatWithoutAccountLoginTest() throws InterruptedException {


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/",
                "Login page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up",
                "Title is wrong.");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(signInButton.isDisplayed(),
                "signIn button is noy displayed on Login page.");
        userEmailField.sendKeys("@meta.ua");
        userPasswordField.sendKeys("Wrong");
        signInButton.click();

        sleep(3000);

        //не забыть дома проверять тайтл и урл

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit",
                "Home page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"Sign In to LinkedIn",
                "Home page Title is wrong.");



        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(alertMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Alert message text is wrong.");
        WebElement alertMessageWrongEmailFormat = driver.findElement(By.xpath("//span[@id='session_key-login-error']"));
        Assert.assertEquals(alertMessageWrongEmailFormat.getText(),
                "Please enter a valid email address.",
                "Alert message (loginField) text is wrong.");

    }

    @Test ///(priority = 1) //
    public void wrongEmailFormatWithoutDomainLoginTest() throws InterruptedException {


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/",
                "Login page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up",
                "Title is wrong.");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(signInButton.isDisplayed(),
                "signIn button is noy displayed on Login page.");
        userEmailField.sendKeys("getjman1@");
        userPasswordField.sendKeys("Wrong");
        signInButton.click();

        sleep(3000);

        //не забыть дома проверять тайтл и урл

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit",
                "Home page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"Sign In to LinkedIn",
                "Home page Title is wrong.");



        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(alertMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Alert message text is wrong.");
        WebElement alertMessageWrongEmailFormat = driver.findElement(By.xpath("//span[@id='session_key-login-error']"));
        Assert.assertEquals(alertMessageWrongEmailFormat.getText(),
                "Please enter a valid email address.",
                "Alert message (loginField) text is wrong.");

    }

    @Test ///(priority = 1)
    public void wrongEmailLoginTest() throws InterruptedException {


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/",
                "Login page URL is wrong.");

        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up",
                "Title is wrong.");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(signInButton.isDisplayed(),
                "signIn button is noy displayed on Login page.");
        userEmailField.sendKeys("abcdefg@bcd.fds");
        userPasswordField.sendKeys("Wrong1234");
        signInButton.click();

        sleep(3000);

        //не забыть дома проверять тайтл и урл

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit",
                "Home page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"Sign In to LinkedIn",
                "Home page Title is wrong.");

        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(alertMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Alert message text is wrong.");
        WebElement alertMessageWrongEmail = driver.findElement(By.xpath("//span[@id='session_key-login-error']"));
        Assert.assertEquals(alertMessageWrongEmail.getText(),
                "Hmm, we don't recognize that email. Please try again.",
                "Alert message (loginField) text is wrong.");
    }

    @Test ///(priority = 1)
    public void shortPasswordLoginTest() throws InterruptedException {


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/",
                "Login page URL is wrong.");

        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up",
                "Title is wrong.");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(signInButton.isDisplayed(),
                "signIn button is noy displayed on Login page.");
        userEmailField.sendKeys("getjman1@meta.ua");
        userPasswordField.sendKeys("short");
        signInButton.click();

        sleep(3000);

        //не забыть дома проверять тайтл и урл

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit",
                "Home page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"Sign In to LinkedIn",
                "Home page Title is wrong.");

        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(alertMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Alert message text is wrong.");
        WebElement alertMessageShortPassword = driver.findElement(By.xpath("//span[@id='session_password-login-error']"));
        Assert.assertEquals(alertMessageShortPassword.getText(),
                "The password you provided must have at least 6 characters.",
                "Alert message (passwordField) text is wrong.");
    }

    @Test ///(priority = 1)
    public void wrongPasswordLoginTest() throws InterruptedException {


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/",
                "Login page URL is wrong.");

        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up",
                "Title is wrong.");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(signInButton.isDisplayed(),
                "signIn button is noy displayed on Login page.");
        userEmailField.sendKeys("getjman1@meta.ua");
        userPasswordField.sendKeys("moreThan6signs");
        signInButton.click();

        sleep(3000);

        //не забыть дома проверять тайтл и урл

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit",
                "Home page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"Sign In to LinkedIn",
                "Home page Title is wrong.");

        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(alertMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Alert message text is wrong.");
        WebElement alertMessageWrongPassword = driver.findElement(By.xpath("//span[@id='session_password-login-error']"));
        Assert.assertEquals(alertMessageWrongPassword.getText(),
                "Hmm, that's not the right password. Please try again or request a new one.",
                "Alert message (passwordField) text is wrong.");
    }

    @Test ///(priority = 1)
    public void longEmailLoginTest() throws InterruptedException {


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/",
                "Login page URL is wrong.");

        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up",
                "Title is wrong.");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(signInButton.isDisplayed(),
                "signIn button is noy displayed on Login page.");
        userEmailField.sendKeys("qwertyuiopqwertyuiiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyyuiopqwertyuiop@bcd.fds");
        userPasswordField.sendKeys("moreThan6signs");
        signInButton.click();

        sleep(3000);

        //не забыть дома проверять тайтл и урл

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit",
                "Home page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"Sign In to LinkedIn",
                "Home page Title is wrong.");

        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(alertMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Alert message text is wrong.");
        WebElement alertMessageLongEmail = driver.findElement(By.xpath("//span[@id='session_key-login-error']"));
        Assert.assertEquals(alertMessageLongEmail.getText(),
                "The text you provided is too long (the maximum length is 128 characters, your text contains 140 characters).",
                "Alert message (loginField) text is wrong.");
    }

    @Test ///(priority = 1)
    public void longPasswordLoginTest() throws InterruptedException {


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/",
                "Login page URL is wrong.");

        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up",
                "Title is wrong.");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(signInButton.isDisplayed(),
                "signIn button is noy displayed on Login page.");
        userEmailField.sendKeys("getjman1@meta.ua");
        userPasswordField.sendKeys("qwertyuiopqwertyuiiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyyuiopqwertyuiopqwertyuiopqwertyuiiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyyuiopqwertyuiopqwertyuiopqwertyuiiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyyuiopqwertyuiopqwertyuiopqwertyuiiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyyuiopqwertyuiop");
        signInButton.click();

        sleep(3000);

        //не забыть дома проверять тайтл и урл

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit",
                "Home page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"Sign In to LinkedIn",
                "Home page Title is wrong.");

        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(alertMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Alert message text is wrong.");
        WebElement alertMessageLongPassword = driver.findElement(By.xpath("//span[@id='session_password-login-error']"));
        Assert.assertEquals(alertMessageLongPassword.getText(),
                "The password you provided must have at most 400 characters.",
                "Alert message (passwordField) text is wrong.");
    }



}
