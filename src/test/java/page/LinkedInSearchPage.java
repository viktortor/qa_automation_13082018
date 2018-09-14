package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * LinkedInSearchPage Page Object class
 */
public class LinkedInSearchPage extends LinkedInBasePage {

    @FindBy(xpath = "//h3[contains(@class,'search-results__total')]")
    private WebElement searchResultsTotal;

    @FindBy(xpath = "//li[contains(@class,'search-result search-result__occluded-item')]")
    private List<WebElement> searchResults;


    /**
     * Constructor for LinkedInSearchPage.
     *
     * @param driver - driver instance from tests.
     */
    public LinkedInSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementVisible(searchResultsTotal, 10);
    }

    /**
     * Verify is expected Page Loaded
     *
     * @return true if page loaded and false if page doesn't load
     */
    public boolean isPageLoaded() {
        return getCurrentUrl().contains("/search/results/")
                && getCurrentTitle().contains("Поиск | LinkedIn")
                && searchResultsTotal.isDisplayed();
    }

    /**
     * counts the number of search results on the page
     *
     * @return int number of search results
     */
        public int getSearchResultsNumber () {
            return searchResults.size();
        }


    /**
     * get search results text
     *
     * @return List<String> with searchResults Text
     */
        public List<String> getSearchResultsList () {
            List<String> searchResultsList = new ArrayList<String>();
            for (WebElement searchResult : searchResults) {
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", searchResult);
                searchResultsList.add(searchResult.getText());
            }
            return searchResultsList;
        }



}







