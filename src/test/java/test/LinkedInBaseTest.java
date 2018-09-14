package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        linkedInLoginPage = new LinkedInLoginPage(driver);
    }

    /**
     * final conditions:
     * - close browser
     */
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

}
