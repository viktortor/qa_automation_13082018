import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class LinkedInSearchPage extends LinkedInBasePage {

    @FindBy(xpath = "//*[@data-control-name='all_filters']")
    private WebElement allFiltersButton;

    @FindAll({@FindBy(xpath = "//li[@class[contains(.,'search-result search-result__occluded-item')]]"),})
    List<WebElement> searchResults;

    @FindBy(xpath = "//*[@class='subline-level-1 Sans-15px-black-85% search-result__truncate']")
    private WebElement searchResult;

    @FindBy(xpath = "//*[@class='search-filters-bar__top-filter-text Sans-13px-black-55% flex-shrink-zero ml4']")
    private WebElement staticField;


    public LinkedInSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isPageLoaded() {
        return getCurrentUrl().contains("/search/results/")
                && getCurrentTitle().contains("Поиск | LinkedIn")
                && allFiltersButton.isDisplayed();
    }

    public boolean isNumberSearchResultTrue(int expectedResult) {
        return searchResults.size() == expectedResult;
    }


    public String isSearchTermFound() {
        String result = "";
        staticField.click();
        staticField.sendKeys(Keys.PAGE_DOWN);

         for (WebElement searchResult : searchResults) {
            String searchResultText = searchResult.getText();
            if (searchResultText.toLowerCase().contains("hr")) {
                result=result + "1";
            }
            else {
                result=result + "0";
            }
        }
  return result;
    }




}





