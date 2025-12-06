package tests;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ForgotEmailPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;

public class AccountRecoveryNavigationTests extends BaseTest {
    LoginPage loginPage;
    ForgotEmailPage forgotEmailPage;
    ForgotPasswordPage forgotPasswordPage;

    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver);
        forgotEmailPage = new ForgotEmailPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    // mayb add dummy data providers here

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
