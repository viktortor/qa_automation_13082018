import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedinLoginTest {
    //Аннотация - сообщаем компилятору доп инфо - заставляем запускать наш метод
    @Test
    public void successfullLoginTest () throws InterruptedException {
        //Navigate to linkedin.com
        //Verify that login page is loaded //наличие кнопки Войти
        //Enter userEmail
        //Enter userPassword
        //Click on 'Sign in' button
        //Verify Home page is displayed

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/"); //полный формат адреса (с https....)

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/",
         "Login page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up",
                "Title is wrong.");



        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(signInButton.isDisplayed(),
                "signIn button is noy displayed on Login page.");
        userEmailField.sendKeys("linkedin.tsn.yanina@gmail.com");
        userPasswordField.sendKeys("Yanina123");
        signInButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/",
                "Home page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"LinkedIn",
                "Home page Title is wrong.");
        WebElement profileNavItem = driver.findElement(By.xpath("//li[@id='profile-nav-item]"));
        Assert.assertTrue(profileNavItem.isDisplayed(),
                "profileNavItem button is not displayed on Home page.");



    }
    @Test
    public void negativLoginTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/"); //полный формат адреса (с https....)

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/",
                "Login page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up",
                "Title is wrong.");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(signInButton.isDisplayed(),
                "signIn button is noy displayed on Login page.");
        userEmailField.sendKeys("a@b.c");
        userPasswordField.sendKeys("Wrong");
        signInButton.click();

        sleep(3000);

        //не забыть дома проверять тайтл и урл
        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(alertMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Alert message text is wrong.");

    }

    private void sleep(int i) {
    }

}
