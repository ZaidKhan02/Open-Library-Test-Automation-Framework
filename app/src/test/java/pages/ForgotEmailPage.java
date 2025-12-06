package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotEmailPage extends BasePage {

    public ForgotEmailPage(WebDriver driver) {
        super(driver);
    }

    By pageHeader = By.xpath("//div[@id='contentHead']//h2");

    public String getPageHeader() {
        return getText(pageHeader);
    }
}

// we can do same thing where we store expectedmsg string in test file and get
// the actual text here
// regerring to text "forgot your internet archive email"