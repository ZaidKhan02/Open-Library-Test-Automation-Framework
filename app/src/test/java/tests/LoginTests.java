package tests;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dataproviders.AuthDataProviders;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void setUpPages() {
        loginPage = new LoginPage(getDriver());
        /* homePage = new HomePage(getDriver()); */
    }

    @Test(groups = { "smoke", "login" })
    public void loginValidEmailValidPassword() {
        /* loginPage.loginUser("zk7832456@gmail.com", "zk7832456pw"); */
        HomePage homePage = loginPage.loginUser("zk7832456@gmail.com", "zk7832456pw");
        Assert.assertTrue(homePage.isUserAvatarDisplayed(), "Avatar should be visible after login");
    }

    @Test(groups = { "regression", "login" })
    public void loginEmailWithWhitespaceValidPassword() {
        HomePage homePage = loginPage.loginUser("  zk7832456@gmail.com  ", "zk7832456pw");
        Assert.assertTrue(homePage.isUserAvatarDisplayed(), "Avatar should be visible after login");
    }

    @Test(groups = { "regression",
            "login-negative" }, dataProvider = "negativeLoginData", dataProviderClass = AuthDataProviders.class)
    public void negativeLoginTests(String email, String password, String expectedMsg) {
        loginPage.loginUser(email, password);

        if (expectedMsg != null) {
            Assert.assertEquals(loginPage.getInvalidErrorMsg(), expectedMsg,
                    "Actual error message should match expected error message");
        } else {
            // Generic safe assertions for cases with native browser validation
            Assert.assertEquals(getDriver().getCurrentUrl(), url,
                    "Should remain on login page after invalid login attempt");
            Assert.assertTrue(loginPage.isLoginBtnDisplayed(),
                    "Login button should still be visible");
            Assert.assertTrue(loginPage.isUserNotAvatarDisplayed(),
                    "User avatar should not be visible");
        }
    }

    /*
     * 
     * @Test(groups = { "regression", "login-negative" })
     * public void loginValidEmailInvalidPassword() {
     * String expectedInvalidErrorMsg = "Wrong password. Please try again";
     * loginPage.loginUser("zaidlovesmath@gmail.com", "zaidkhanpw123!");
     * Assert.assertEquals(loginPage.getInvalidErrorMsg(), expectedInvalidErrorMsg,
     * "actual error message should match with expected error message");
     * }
     * 
     * @Test(groups = { "regression", "login-negative" })
     * public void loginInvalidEmailValidPassword() {
     * String expectedInvalidErrorMsg =
     * "No account was found with this email. Please try again";
     * loginPage.loginUser("zaidkhan@gmail.com", "Louiscathat123!");
     * Assert.assertEquals(loginPage.getInvalidErrorMsg(), expectedInvalidErrorMsg,
     * "actual error messages should match with expected error message");
     * }
     * 
     * @Test(groups = { "regression", "login-negative" })
     * public void loginEmptyEmailEmptyPassword() {
     * loginPage.loginUser("", "");
     * Assert.assertEquals(driver.getCurrentUrl(), url,
     * "Should remain on login page after login attempt");
     * Assert.assertTrue(loginPage.isLoginBtnDisplayed(),
     * "Login button should be visible after login attempt");
     * Assert.assertTrue(homePage.isUserNotAvatarDisplayed(),
     * "user avatar should not be visible after login attempt");
     * }
     * 
     * @Test(groups = { "regression", "login-negative" })
     * public void loginValidEmailEmptyPassword() {
     * loginPage.loginUser("zaidlovesmath@gmail.com", "");
     * Assert.assertEquals(driver.getCurrentUrl(), url,
     * "Should remain on login page after login attempt");
     * Assert.assertTrue(loginPage.isLoginBtnDisplayed(),
     * "Login button should be visible after login attempt");
     * Assert.assertTrue(homePage.isUserNotAvatarDisplayed(),
     * "user avatar should not be visible after login attempt");
     * }
     * 
     * @Test(groups = { "regression", "login-negative" })
     * public void loginEmailWithInvalidFormatValidPassword() {
     * loginPage.loginUser("zaidlovesmath@", "Louiscathat123!");
     * Assert.assertEquals(driver.getCurrentUrl(), url,
     * "Should remain on login page after login attempt");
     * Assert.assertTrue(loginPage.isLoginBtnDisplayed(),
     * "Login button should be visible after login attempt");
     * Assert.assertTrue(homePage.isUserNotAvatarDisplayed(),
     * "user avatar should not be visible after login attempt");
     * }
     */
}
