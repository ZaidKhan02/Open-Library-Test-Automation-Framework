package tests;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    // mayb add dummy data providers here

    @Test
    public void logoutSuccessfully() {
        loginPage.loginUser("zaidlovesmath@gmail.com", "Louiscathat123!");
        homePage.clickHamburgerIcon();
        homePage.clickLogoutBtn();
        Assert.assertTrue(homePage.isLoginBtnDisplayed(), "Login button should be displayed after logging out");
    }

}
