package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.Keys.ENTER;

/**
 * LinkedInHomePage Page Object class
 */
public class LinkedInHomePage extends LinkedInBasePage {

    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;


    @FindBy(xpath = "//input[@placeholder and @role='combobox']")
    private WebElement searchField;


    /**
     * Constructor for LinkedInHomePage.
     *
     * @param driver - driver instance from tests.
     */
    public LinkedInHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementVisible(profileNavItem, 10);
    }

    /**
     * Verify is expected Page Loaded
     *
     * @return true if page loaded and false if page doesn't load
     */
    public boolean isPageLoaded(){
        return getCurrentUrl().equals("https://www.linkedin.com/feed/")
                && getCurrentTitle().contains("LinkedIn")
                && profileNavItem.isDisplayed();
    }


    /**
     * Enter searchTerm into searchField and start search
     *
     * @param searchTerm - String with searchTerm
     *
     * @return PageObject LinkedInSearchPage
     */
    public LinkedInSearchPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(ENTER);

        return new LinkedInSearchPage(driver);
    }
}
