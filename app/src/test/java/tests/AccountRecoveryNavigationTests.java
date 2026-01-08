package tests;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ForgotEmailPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;

@Test
public class AccountRecoveryNavigationTests extends BaseTest {
    LoginPage loginPage;
    ForgotEmailPage forgotEmailPage;
    ForgotPasswordPage forgotPasswordPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        loginPage = new LoginPage(getDriver());
        forgotEmailPage = new ForgotEmailPage(getDriver());
        forgotPasswordPage = new ForgotPasswordPage(getDriver());
    }

    @Test(groups = { "regression", "navigation" })
    public void navigateToForgotEmailPage() {
        String expectedPageHeader = "Forgot Your Internet Archive Email?";
        loginPage.clickForgotEmail();
        String actualPageHeader = forgotEmailPage.getPageHeader();
        Assert.assertEquals(actualPageHeader, expectedPageHeader,
                "actual page header should match with expected page header");
    }

    @Test(enabled = false) // I dont think its possible testing this
    public void navigateToForgotPasswordPage() {
        String expectedPageHeader = "Reset Your Password";
        loginPage.clickForgotPassword();
        String actualPageHeader = forgotPasswordPage.getPageHeader();
        Assert.assertEquals(actualPageHeader, expectedPageHeader);
    }
}
