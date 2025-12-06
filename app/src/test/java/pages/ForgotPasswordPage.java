package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    By pageHeader = By.cssSelector("div[id='page-container'] h1");

    public String getPageHeader() {
        return getText(pageHeader);
    }
}

// we can do same thing where we store expectedmsg string in test file and get
// the actual text here
// regerring to text "Reset your password"