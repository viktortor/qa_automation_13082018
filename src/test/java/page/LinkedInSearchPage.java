package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LinkedInSearchPage extends LinkedInBasePage {

    @FindBy(xpath = "//h3[contains(@class,'search-results__total')]")
    private WebElement searchResultsTotal;

    @FindBy(xpath = "//li[contains(@class,'search-result search-result__occluded-item')]")
    private List<WebElement> searchResults;


    public LinkedInSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isPageLoaded() {
        return getCurrentUrl().contains("/search/results/")
                && getCurrentTitle().contains("Поиск | LinkedIn")
                && searchResultsTotal.isDisplayed();
    }

        public int getSearchResultsNumber () {
            return searchResults.size();
        }


        public List<String> getSearchResultsList () {
            List<String> searchResultsList = new ArrayList<String>();
            for (WebElement searchResult : searchResults) {
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", searchResult);
                searchResultsList.add(searchResult.getText());
            }
            return searchResultsList;
        }



}







