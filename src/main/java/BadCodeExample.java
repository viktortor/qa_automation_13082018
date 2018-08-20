import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class BadCodeExample {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");


        WebElement searchField = driver.findElement(By.xpath("//input[@id='lst-ib']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys("selenium");
        searchField.sendKeys(ENTER);

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));
        System.out.println("Search results count "+ searchResults.size());

        int searchResultsCount = searchResults.size();
        if (searchResultsCount == 10) {
            System.out.println("Search results count is correct: "+searchResultsCount);
        }
        else {
            System.out.println("Search results count is incorrect: "+searchResultsCount);
        }


        for (WebElement searchResult : searchResults) {
            String searchResultText = searchResult.getText();
            System.out.println(searchResultText);
            if (searchResultText.toLowerCase().contains("selenium")) {
                System.out.println("SearchTerm found.");
            }
            else {
                System.out.println("SearchTerm not found.");
            }
        }
        driver.close();
    }
}
