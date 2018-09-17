package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LinkedInLoginPage;


/**
 * LinkedIn Base Test Object class. Contains common elements of all Tests
 */
public class LinkedInBaseTest {
    WebDriver driver;
    LinkedInLoginPage linkedInLoginPage;
    private String browserName = "Chrome";

    /**
     * preconditions for all tests:
     * - initialise new ChromeDriver
     * - Navigate to linkedin.com
     * - initialise LinkedIn Login Page
     */
    @BeforeMethod
    public void beforeMethod() {

        switch (browserName) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "FireFox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
        }

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
