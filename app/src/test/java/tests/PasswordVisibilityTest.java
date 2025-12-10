package tests;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

@Test
public class PasswordVisibilityTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void setUpPages() {
        loginPage = new LoginPage(driver);
    }

    @Test(groups = { "regression", "ui" })
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

}
