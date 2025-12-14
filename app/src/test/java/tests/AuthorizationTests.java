package tests;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.*;

public class AuthorizationTests extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    SearchPage searchPage;
    BookPage bookPage;
    EditBookPage editBookPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        searchPage = new SearchPage(getDriver());
        bookPage = new BookPage(getDriver());
        editBookPage = new EditBookPage(getDriver());
        loginPage.loginUser("zk7832456@gmail.com", "zk7832456pw");

    }

    @Test(groups = { "smoke" })
    public void shouldRedirectToLoginWhenBorrowingBookWhileLoggedOut() {
        homePage.clickUserAvatar();
        homePage.clickLogoutBtn();
        homePage.enterSearchInput("Catharsis in healing, ritual, and drama");
        homePage.clickSearchBtn();
        searchPage.clickBorrowBookBtn();
        Assert.assertTrue(loginPage.isLoginBtnDisplayed(),
                "User should be redirected to login when borrowing while logged out");
    }

    @Test(groups = { "smoke" })
    public void shouldDisplayPermissionDeniedWhenUnauthorizedUserEditsBook() {
        String expectedPageHeader = "Permission denied.";
        homePage.enterSearchInput("Harry Potter and the Order of the Phoenix");
        homePage.clickSearchBtn();
        searchPage.clickBookName();
        homePage.clickUserAvatar();
        homePage.clickLogoutBtn();
        bookPage.clickEditBtn();
        String actualPageHeader = editBookPage.getPageHeader();
        Assert.assertEquals(actualPageHeader, expectedPageHeader,
                "Actual page header should match expected page header");
    }

}
