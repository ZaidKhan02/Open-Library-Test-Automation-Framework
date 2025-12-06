package tests;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import dev.failsafe.internal.util.Assert;
import pages.ForgotEmailPage;
import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;

public class AuthenticationTests extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    // I will remove bottom 2 to move to their own file, using it here for testing
    ForgotEmailPage forgotEmailPage;
    ForgotPasswordPage forgotPasswordPage;

    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        forgotEmailPage = new ForgotEmailPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    // mayb add dummy data providers here

    @Test
    public void loginValidEmailValidPassword() {
        // loginPage.enterEmail("zaidlovesmath@gmail.com");
        // loginPage.enterPassword("Louiscathat123!");
        // loginPage.clickLogin();
        loginPage.loginUser("zaidlovesmath@gmail.com", "Louiscathat123!");
        Assert.assertTrue(homePage.isUserAvatarDisplayed(), "Avatar should be visible after login");
    }

    @Test
    public void loginValidEmailInvalidPassword() {
        String expectedInvalidErrorMsg = "Wrong password. Please try again";
        loginPage.loginUser("zaidlovesmath@gmail.com", "zaidkhanpw123!");
        Assert.assertEquals(loginPage.getInvalidErrorMsg(), expectedInvalidErrorMsg,
                "actual error message should match with expected error message");
    }

    @Test
    public void loginInvalidEmailValidPassword() {
        String expectedInvalidErrorMsg = "No account was found with this email. Please try again";
        loginPage.loginUser("zaidkhan@gmail.com", "Louiscathat123!");
        Assert.assertEquals(loginPage.getInvalidErrorMsg(), expectedInvalidErrorMsg,
                "actual error messages should match with expected error message");
    }

    @Test
    public void loginEmailWithWhitespaceValidPassword() {
        loginPage.loginUser("  zaidlovesmath@gmail.com  ", "Louiscathat123!");
        Assert.assertTrue(homePage.isUserAvatarDisplayed(), "Avatar should be visible after login");
    }

    @Test
    public void loginEmptyEmailEmptyPassword() {
        loginPage.loginUser("", "");
        Assert.assertEquals(driver.getCurrentUrl(), url, "Should remain on login page after login attempt");
        Assert.assertTrue(loginPage.isLoginBtnDisplayed(), "Login button should be visible after login attempt");
        Assert.assertTrue(homePage.isUserNotAvatarDisplayed(), "user avatar should not be visible after login attempt");
    }

    @Test
    public void loginValidEmailEmptyPassword() {
        loginPage.loginUser("zaidlovesmath@gmail.com", "");
        Assert.assertEquals(driver.getCurrentUrl(), url, "Should remain on login page after login attempt");
        Assert.assertTrue(loginPage.isLoginBtnDisplayed(), "Login button should be visible after login attempt");
        Assert.assertTrue(homePage.isUserNotAvatarDisplayed(), "user avatar should not be visible after login attempt");
    }

    @Test
    public void passwordVisibilityToggleShowsPasswordText() {
        loginPage.enterPassword("thisisapassword");
        // Before clicking: should be hidden
        Assert.assertEquals(loginPage.getPasswordInputType(), "password",
                "Password should initially be hidden.");

        loginPage.toggleShowPasswordBtn();

        // After clicking: should be visible
        Assert.assertEquals(loginPage.getPasswordInputType(), "text",
                "Password should be visible after clicking show password.");
    }

    @Test
    public void loginEmailWithInvalidFormatValidPassword() {
        loginPage.loginUser("zaidlovesmath@", "Louiscathat123!");
        Assert.assertEquals(driver.getCurrentUrl(), url, "Should remain on login page after login attempt");
        Assert.assertTrue(loginPage.isLoginBtnDisplayed(), "Login button should be visible after login attempt");
        Assert.assertTrue(homePage.isUserNotAvatarDisplayed(), "user avatar should not be visible after login attempt");
    }

    @Test
    public void logoutSuccessfully() {
        loginPage.loginUser("zaidlovesmath@gmail.com", "Louiscathat123!");
        homePage.clickHamburgerIcon();
        homePage.clickLogoutBtn();
        Assert.assertTrue(homePage.isLoginBtnDisplayed(), "Login button should be displayed after logging out");
    }

    // remove these 2 into their own files after testing if they work (or stay
    // here?)
    @Test
    public void navigateToForgotEmailPage() {
        String expectedPageHeader = "Forgot Your Internet Archive Email?";
        loginPage.clickForgotEmail();
        Assert.assertEquals(forgotEmailPage.getPageHeader(), expectedPageHeader,
                "actual page header should match with expected page header");
    }

    @Test // I dont think its possible testing this
    public void navigateToForgotPasswordPage() {
        String expectedPageHeader = "Reset Your Password";
        loginPage.clickForgotPassword();
        Assert.assertEquals(forgotPasswordPage.getPageHeader(), expectedPageHeader);
    }
}