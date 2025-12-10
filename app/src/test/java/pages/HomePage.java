package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /*
     * By userAvatar = By.cssSelector("img[class='account__icon']");
     * By hamburgerIcon = By.cssSelector("img[class='hamburger__icon logged']");
     * By logoutBtn = By.cssSelector("form[name='hamburger-logout']");
     * By loginBtn = By.xpath("//li[@class='hide-me']//a[@href='/account/login']");
     * 
     * public boolean isUserAvatarDisplayed() {
     * return isDisplayed(userAvatar);
     * }
     * 
     * public boolean isUserNotAvatarDisplayed() {
     * return isNotDisplayed(userAvatar);
     * }
     * 
     * public void clickHamburgerIcon() {
     * click(hamburgerIcon);
     * }
     * 
     * public void clickLogoutBtn() {
     * click(logoutBtn);
     * }
     * 
     * public boolean isLoginBtnDisplayed() {
     * return isDisplayed(loginBtn);
     * }
     */
}