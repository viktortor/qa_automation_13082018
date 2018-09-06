import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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
        driver.quit();
    }

/*    - Open login page
- Verify login page is loaded
- Login with valid credentials
- Verify home page is loaded
- Search for 'hr' Searchterm
- Verify Search page is loaded
- Verify 10 results displayed on search page
- Verify each result item contains searchterm*/

    @Test
    public void successfullSearchTest () {

        String userEmail = "getjman1@meta.ua";
        String userPassword = "Qwertyu-1";
        String searchTerm = "HR";

        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login(userEmail, userPassword);
        Assert.assertTrue(linkedInHomePage.isPageLoaded(),"Home page is not loaded");

        LinkedInSearchPage linkedInSearchPage = linkedInHomePage.search(searchTerm);
        Assert.assertTrue(linkedInSearchPage.isPageLoaded(),"SearchPage is not loaded");

        Assert.assertEquals(linkedInSearchPage.getSearchResultsNumber(), 10, "Wrong number of searchResults on Search page");

        List<String> searchResultsList=linkedInSearchPage.getSearchResultsList();
        for (String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()), "SearchTerm "+searchTerm+" not found in:\n"+searchResult);
        }
    }




}
