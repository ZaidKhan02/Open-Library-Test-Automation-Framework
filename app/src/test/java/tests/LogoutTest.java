package tests;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        loginPage = new LoginPage(getDriver());
    }

    @Test(groups = { "smoke", "logout" })
    public void logoutSuccessfully() {
        // loginPage.loginUser("zk7832456@gmail.com", "zk7832456pw");
        HomePage homePage = loginPage.loginUser("zk7832456@gmail.com", "zk7832456pw");
        homePage.clickUserAvatar();
        homePage.clickLogoutBtn();
        Assert.assertTrue(homePage.isLoginBtnDisplayed(), "Login button should be displayed after logging out");
    }

}