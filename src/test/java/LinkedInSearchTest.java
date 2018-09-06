import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedInSearchTest {
    WebDriver driver;
    LinkedInLoginPage linkedInLoginPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        linkedInLoginPage = new LinkedInLoginPage(driver);
    }

    @AfterMethod
    public void afterMethod(){
   //     driver.quit();
    }

    @Test
    public void successfullSearchTest () {

        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login("getjman1@meta.ua", "Qwertyu-1");
        Assert.assertTrue(linkedInHomePage.isPageLoaded(),"Home page is not loaded");

        LinkedInSearchPage linkedInSearchPage = linkedInHomePage.insertTextToSearchField("hr");
        try {
            sleep (3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        Assert.assertTrue(linkedInSearchPage.isPageLoaded(),"SearchPage is not loaded");

        Assert.assertTrue(linkedInSearchPage.isNumberSearchResultTrue(10), "the number of search results is incorrect");

        Assert.assertEquals(linkedInSearchPage.isSearchTermFound(), "1111111111", "Not all results contain the SearchTerm");

    }




}
