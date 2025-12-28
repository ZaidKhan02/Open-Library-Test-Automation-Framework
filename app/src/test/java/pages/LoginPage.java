package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[id='password']");

    By showPasswordBtn = By.xpath("//a[contains(@class, 'password-visibility-toggle')]");

    By loginBtn = By.cssSelector("button[type='submit']");

    By errorMsg = By.xpath("//div[@class='flash-messages']//span");

    By forgotEmailLink = By.cssSelector("a[href='/account/email/forgot-ia']");
    By forgotPasswordLink = By.cssSelector("a[href='https://archive.org/forgot-password']");

    public void enterEmail(String email) {
        type(emailField, email);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLogin() { 
        click(loginBtn);
    }

    public void toggleShowPasswordBtn() {
        click(showPasswordBtn);
    }

    public String getPasswordInputType() {
        return getAttribute(passwordField, "type");
    }

    public String getInvalidErrorMsg() {
        return getText(errorMsg);
    }

    public void clickForgotEmail() {
        click(forgotEmailLink);
    }

    public void clickForgotPassword() {
        click(forgotPasswordLink);
    }

    public boolean isLoginBtnDisplayed() {
        return isDisplayed(loginBtn);
    }

    public void loginUser(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

}