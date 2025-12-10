package tests;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

@Test
public class LogoutTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void setUpPages() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test(groups = { "smoke", "logout" })
    public void logoutSuccessfully() {
        loginPage.loginUser("zaidlovesmath@gmail.com", "Louiscathat123!");
        homePage.clickUserAvatar();
        homePage.clickLogoutBtn();
        Assert.assertTrue(homePage.isLoginBtnDisplayed(), "Login button should be displayed after logging out");
    }

}

/*
 * package tests;
 * 
 * import org.testng.Assert;
 * import org.testng.SkipException;
 * import org.testng.annotations.BeforeMethod;
 * import org.testng.annotations.Test;
 * 
 * import pages.HomePage;
 * import pages.LoginPage;
 * import utils.Config;
 * 
 * public class LogoutTest extends BaseTest {
 * 
 * LoginPage loginPage;
 * HomePage homePage;
 * 
 * @BeforeMethod(alwaysRun = true)
 * public void setUpPages() {
 * loginPage = new LoginPage(driver);
 * homePage = new HomePage(driver);
 * }
 * 
 * @Test(groups = { "smoke", "logout" })
 * public void logoutSuccessfully() {
 * if (!Config.hasValidCreds()) {
 * throw new SkipException("Valid credentials not provided in env/sys props.");
 * }
 * 
 * loginPage.loginUser(Config.validEmail(), Config.validPassword());
 * homePage.clickHamburgerIcon();
 * homePage.clickLogoutBtn();
 * 
 * Assert.assertTrue(homePage.isLoginBtnDisplayed(),
 * "Login button should be displayed after logging out");
 * }
 * }
 */