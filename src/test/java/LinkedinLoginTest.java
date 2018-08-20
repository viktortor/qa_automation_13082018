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
        // Verify Home page is displayed

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/"); //полный формат адреса (с https....)

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/",
         "Login page URL is wrong.");

        Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up",
                "Title is wrong.");

        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
        Assert.assertEquals(signInButton.getAttribute("id"), "login-submit",
                "Sign In button is absent");


        String loginEmail = "viktortor988@gmail.com";
        String loginPassword = "Qwertyu-1";
        WebElement loginEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        loginEmailField.click();
        loginEmailField.clear();
        loginEmailField.sendKeys(loginEmail);
        //loginEmailField.sendKeys(TAB);

        WebElement loginPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        loginPasswordField.click();
        loginPasswordField.clear();
        loginPasswordField.sendKeys(loginPassword);
       // loginPasswordField.sendKeys(TAB);

        signInButton.click();

       // Thread.sleep(5000);

        WebElement welcomeUserField = driver.findElement(By.xpath("//span[@class='Sans-17px-black-85%-semibold']"));
        Assert.assertEquals(welcomeUserField.getText(), "Добро пожаловать, viktor!",
                "no welcome message");

        WebElement userProfileDropDown = driver.findElement(By.xpath("//button[@id='nav-settings__dropdown-trigger']"));
        userProfileDropDown.click();

        WebElement logoutButton = driver.findElement(By.xpath("//a[@data-control-name='nav.settings_signout']"));
        Assert.assertEquals(logoutButton.getText(), "Выйти",
                "LogOut button is absent");


       // driver.close();
    }

}
