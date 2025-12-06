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

    public boolean isNotDisplayed(By locator) {
        return driver.findElements(locator).isEmpty();
    }

    /*
     * protected boolean isElementDisplayed(By locator) {
     * try {
     * return waitForVisible(locator).isDisplayed();
     * } catch (Exception e) {
     * return false;
     * }
     * }
     * 
     * protected void waitForInvisibility(By locator) {
     * wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
     * }
     * 
     * protected void hoverOver(By locator) {
     * WebElement element = waitForVisible(locator);
     * actions.moveToElement(element).perform();
     * }
     */

}
