import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.Keys.ENTER;

public class LinkedInHomePage extends LinkedInBasePage {

    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;


    @FindBy(xpath = "//*[@placeholder='Поиск']")
    private WebElement searchField;




    public LinkedInHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isPageLoaded(){
        return getCurrentUrl().equals("https://www.linkedin.com/feed/")
                && getCurrentTitle().contains("LinkedIn")
                && profileNavItem.isDisplayed();
    }


    public LinkedInSearchPage insertTextToSearchField (String searchText) {
        searchField.sendKeys(searchText);
        searchField.sendKeys(ENTER);
        return new LinkedInSearchPage(driver);
    }
}
