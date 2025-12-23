package stepDefinition;

import java.time.Duration;

import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;

public class LoginStepDefinitions {

    WebDriver driver;

    WebDriverWait wait;

    @Before
    //@Given("I open the browser")
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @And("I am on the Login Page")
    public void openLoginPage() {
        driver.get("https://openlibrary.org/account/login");
    }

    @When("I enter the email zk7832456@gmail.com")
    public void enterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
    }

    @And("I enter the password zk7832456pw") 
    public void enterPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void clickLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();
    }

    @Then("I am logged in")
    public void userIsLoggedIn() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isUserAvatarDisplayed(), "Avatar should be visible after login");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
    
}
