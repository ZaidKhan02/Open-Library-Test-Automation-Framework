package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected final WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.actions = new Actions(driver);
    }

    /*
     * public WebElement findElement(By locator) {
     * return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
     * }
     */

    By userAvatar = By.cssSelector("img[class='account__icon']");
    // By hamburgerIcon = By.cssSelector("img[class='hamburger__icon logged']");
    By logoutBtn = By.cssSelector("form[name='hamburger-logout']");
    By loginBtn = By.xpath("//li[@class='hide-me']//a[@href='/account/login']");
    By searchBar = By.xpath("//form[@class='search-bar-input']//input[@type='text']");
    By searchTypeBtn = By.xpath("//div[@class='search-facet']");
    By authorTypeBtn = By.xpath("//label[@class='search-facet-selector']//option[3]");
    By searchIcon = By.cssSelector("input[class=search-bar-submit]");

    protected WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        // something like click(loginBtn)
        waitForClickable(locator).click();
    }

    protected void type(By locator, String text) {
        // in LoginPage, it will be like type(emailField, "zaidlovemath@gmail.com")
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    protected String getAttribute(By locator, String attr) {
        return waitForVisibility(locator).getAttribute(attr);
    }

    protected boolean isDisplayed(By locator) {
        return waitForVisibility(locator).isDisplayed();
    }

    protected boolean isNotDisplayed(By locator) {
        return driver.findElements(locator).isEmpty();
    }

    // added these public methods into basepage since they are visible in all pages
    // after login
    public boolean isUserAvatarDisplayed() {
        return isDisplayed(userAvatar);
    }

    public boolean isUserNotAvatarDisplayed() {
        return isNotDisplayed(userAvatar);
    }

    public void clickUserAvatar() {
        click(userAvatar);
    }

    public void clickLogoutBtn() {
        click(logoutBtn);
    }

    public boolean isLoginBtnDisplayed() {
        return isDisplayed(loginBtn);
    }

    // searching
    public void clickSearchTypeBtn() {
        click(searchTypeBtn);
    }

    public void clickAuthorTypeBtn() {
        click(authorTypeBtn);
    }

    public void enterSearchInput(String input) {
        type(searchBar, input);
    }

    public void clickSearchBtn() {
        click(searchIcon);
    }

    public void search(String input) { // rename later
        clickSearchTypeBtn();
        clickAuthorTypeBtn();
        enterSearchInput(input);
        clickSearchBtn();
    }

}
