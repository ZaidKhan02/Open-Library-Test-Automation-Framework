package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    // protected WebDriver driver;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected String url;

    protected WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({ "BaseURL" })
    public void launchBrowser(@Optional("https://openlibrary.org/account/login") String baseURL) {
        this.url = baseURL;
        driver.set(pickBrowser(System.getProperty("browser", "chrome")));
        getDriver().manage().window().maximize();
        getDriver().get(url);
    }

    public WebDriver pickBrowser(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--remote-allow-origins=*");
                firefoxOptions.addArguments("--disable-notifications");
                return new FirefoxDriver(firefoxOptions);

            case "edge":
            case "microsoftedge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                edgeOptions.addArguments("--disable-notifications");
                return new EdgeDriver(edgeOptions);

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-notifications");
                return new ChromeDriver(chromeOptions);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}