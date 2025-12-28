package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage { 

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    By authorName = By.xpath("//ul[contains(@class, 'authorList')]//li[1]//a");
    By bookName = By
            .xpath("//div[@id='searchResults']//li[contains(@class, 'searchResultItem')][1]//a[@class='results']");
    By errorMsg = By.cssSelector("div[class='red']");
    By bookItems = By.cssSelector("ul.list-books > li.searchResultItem");
    By filterBtn = By.cssSelector("summary[class='tool-button']");
    By topRatedFilterBtn = By.xpath("//span[@class='sort-content-inner']//a[5]");
    By paginationBtn = By.xpath("//div[@class='pagination']//a[@class='ChoosePage'][1]");
    By wantToReadBtn = By
            .xpath("(//li[contains(@class, 'searchResultItem')]//form[contains(@class, 'reading-log')])[1]");
    By searchDropDownBtn = By
            .xpath("(//li[contains(@class, 'searchResultItem')]//a[@class= 'generic-dropper__dropclick'])[1]");
    By alreadyReadDropDownBtn = By
            .xpath("(//li[contains(@class,'searchResultItem')])[1]//div[contains(@class,'read-statuses')]//form[4]");
    By wantToReadDropDownBtn = By
            .xpath("(//li[contains(@class,'searchResultItem')])[1]//div[contains(@class,'read-statuses')]//form[2]");
    By bookStatus = By.xpath("//li[contains(@class, 'searchResultItem')][1]//span[@class='btn-text']");
    By borrowBookBtn = By.cssSelector("a[title='Borrow ebook from Internet Archive']");

    By searchResults = By.cssSelector("li.searchResultItem");

    public List<Double> getAllBookRatings() {
        List<WebElement> results = driver.findElements(searchResults);
        List<Double> ratings = new ArrayList<>();
 
        for (WebElement result : results) {
            List<WebElement> meta = result.findElements(By.cssSelector("meta[itemprop='ratingValue']"));

            if (!meta.isEmpty()) {
                ratings.add(
                        Double.parseDouble(meta.get(0).getAttribute("content")));
            }
        }
        return ratings;
    }

    // Methods

    public String getAuthorName() {
        return getText(authorName);
    }

    public String getBookName() {
        return getText(bookName);
    }

    public String getErrorMsg() {
        return getText(errorMsg);
    }

    public void clickFilterBtn() {
        click(filterBtn);
    }

    public void clickTopRatedFilterBtn() {
        click(topRatedFilterBtn);
    }

    public void clickWantToReadBtn() {
        click(wantToReadBtn);
    }

    public void clickSearchDropDownBtn() {
        click(searchDropDownBtn);
    }

    public void clickAlreadyReadDropDownBtn() {
        click(alreadyReadDropDownBtn);
    }

    public void clickWantToReadDropDownBtn() {
        click(wantToReadDropDownBtn);
    }

    public String getBookStatus() {
        return getText(bookStatus);
    }

    public void clickBookName() {
        click(bookName);
    }

    public void clickBorrowBookBtn() {
        click(borrowBookBtn);
    }

    public int getDisplayedBooksCount() {
        return waitForAllElementsPresent(bookItems).size();
    }

    public void goToNextPage() {
        click(paginationBtn);
        waitForAllElementsPresent(bookItems);
    }
}
