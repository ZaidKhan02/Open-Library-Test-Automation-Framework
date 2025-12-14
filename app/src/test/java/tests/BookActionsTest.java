package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.*;

public class BookActionsTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    SearchPage searchPage;
    ProfilePage profilePage;
    WantToReadPage wantToReadPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        searchPage = new SearchPage(getDriver());
        profilePage = new ProfilePage(getDriver());
        wantToReadPage = new WantToReadPage(getDriver());
        loginPage.loginUser("zk7832456@gmail.com", "zk7832456pw");
    }

    @Test(groups = { "smoke" })
    public void shouldAddBookToWantToReadAndDisplayInUserProfile() {
        String expectedBookName = "Harry Potter and the Order of the Phoenix";
        homePage.enterSearchInput("Harry Potter and the Order of the Phoenix");
        homePage.clickSearchBtn();
        searchPage.clickWantToReadBtn();
        homePage.clickUserAvatar();
        homePage.clickUserProfile();
        profilePage.clickWantToReadLink();
        String actualBookName = wantToReadPage.getBookName();
        Assert.assertEquals(actualBookName, expectedBookName,
                "Actual book name should match expected book name");
    }

    @Test(groups = { "regression" })
    // after this test, set the status back to want to read for it to work
    public void shouldMarkBookAsAlreadyReadAndReflectStatusInSearchResults() {
        String expectedBookStatus = "Already Read";
        homePage.enterSearchInput("Harry Potter and the Order of the Phoenix");
        homePage.clickSearchBtn();
        searchPage.clickSearchDropDownBtn();
        searchPage.clickAlreadyReadDropDownBtn();
        homePage.clickSearchBtn();
        String actualBookStatus = searchPage.getBookStatus();
        Assert.assertEquals(actualBookStatus, expectedBookStatus,
                "Actual book status should match expected book status");
    }

    // reset book status back to want to read
    @AfterMethod(alwaysRun = true)
    public void resetBookState() {
        homePage.enterSearchInput("Harry Potter and the Order of the Phoenix");
        homePage.clickSearchBtn();

        String currentStatus = searchPage.getBookStatus();

        if ("Already Read".equalsIgnoreCase(currentStatus)) {
            searchPage.clickSearchDropDownBtn();
            searchPage.clickWantToReadDropDownBtn();
            homePage.clickSearchBtn();
        }
    }

}
