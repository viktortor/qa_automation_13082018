package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LinkedInLoginPage;

/**
 * LinkedIn Base Test Object class. Contains common elements of all Tests
 */
public class LinkedInBaseTest {
    WebDriver driver;
    LinkedInLoginPage linkedInLoginPage;

    /**
     * preconditions for all tests:
     * - initialise new ChromeDriver
     * - Navigate to linkedin.com
     * - initialise LinkedIn Login Page
     */
    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();//эти две строки это переключатель - это свич-кейс
        driver = new FirefoxDriver();//
        driver.get("https://www.linkedin.com/");
        linkedInLoginPage = new LinkedInLoginPage(driver);
    }

    /**
     * final conditions:
     * - close browser
     */
    @AfterMethod(alwaysRun = true)
    public void afterMethod(){driver.quit();}

}
