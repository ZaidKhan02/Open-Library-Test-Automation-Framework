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
