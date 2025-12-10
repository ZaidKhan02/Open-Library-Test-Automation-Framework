package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    By filterBtn = By.cssSelector("summary[class='tool-button']");
    By topRatedFilterBtn = By.xpath("//span[@class='sort-content-inner']//a[5]");
    // By firstBookRating = By.xpath("//li[contains(@class,
    // 'searchResultItem')][1]//span[@itemprop='ratingValue']");
    By firstBookRating = By.xpath("//li[contains(@class, 'searchResultItem')][1]//meta[@itemprop='ratingValue']");
    By secondBookRating = By.xpath("//li[contains(@class, 'searchResultItem')][2]//meta[@itemprop='ratingValue']");
    // By secondBookRating = By.xpath("//li[contains(@class,
    // 'searchResultItem')][2]//span[@itemprop='ratingValue']");
    By firstPaginationBtn = By.xpath("//div[@class='pagination']//span[@class='this']");
    By secondPaginationBtn = By.xpath("//div[@class='pagination']//a[@class='ChoosePage'][1]");
    By wantToReadBtn = By
            .xpath("(//li[contains(@class, 'searchResultItem')]//form[contains(@class, 'reading-log')])[1]");
    By searchDropDownBtn = By
            .xpath("(//li[contains(@class, 'searchResultItem')]//a[@class= 'generic-dropper__dropclick'])[1]");
    By alreadyReadDropDownBtn = By
            .xpath("(//li[contains(@class,'searchResultItem')])[1]//div[contains(@class,'read-statuses')]//form[4]");
    // (//li[contains(@class,'searchResultItem')])[1]//div[contains(@class,'read-statuses')]//form[contains(.,
    // 'Currently Reading')]
    By wantToReadDropDownBtn = By
            .xpath("(//li[contains(@class,'searchResultItem')])[1]//div[contains(@class,'read-statuses')]//form[2]");

    By bookStatus = By.xpath("//li[contains(@class, 'searchResultItem')][1]//span[@class='btn-text']");

    public void clickFilterBtn() {
        click(filterBtn);
    }

    public void clickTopRatedFilterBtn() {
        click(topRatedFilterBtn);
    }

    public double getFirstBookRating() {
        String value = getAttribute(firstBookRating, "content");
        return Double.parseDouble(value);
    }

    public double getSecondBookRating() {
        String value = getAttribute(secondBookRating, "content");
        return Double.parseDouble(value);
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
}
