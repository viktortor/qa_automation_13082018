package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
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
    @Parameters({"browserName", "envURL"})
    @BeforeMethod
    public void beforeMethod(@Optional ("chrome") String browserName, @Optional ("https://www.linkedin.com/") String envURL) throws Exception {

        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new Exception("Browser " + browserName + " is not supported");
        }

        driver.get(envURL);
        linkedInLoginPage = new LinkedInLoginPage(driver);
    }

    /**
     * final conditions:
     * - close browser
     */
    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.quit();
    }

}
