package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class PaginationTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    SearchPage searchPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        searchPage = new SearchPage(getDriver());
        loginPage.loginUser("zk7832456@gmail.com", "zk7832456pw");

    }

    @Test(groups = { "pagination" })
    public void searchResultsPaginationShouldDisplayUpToTwentyBooksPerPage() {
        homePage.enterSearchInput("Harry Potter and the Order of the Phoenix");
        homePage.clickSearchBtn();

        int page1Count = searchPage.getDisplayedBooksCount();
        Assert.assertTrue( 
                page1Count > 0 && page1Count <= 20,
                "Page 1 should display up to 20 books, but found " + page1Count);

        searchPage.goToNextPage();

        int page2Count = searchPage.getDisplayedBooksCount();
        Assert.assertTrue(
                page2Count > 0 && page2Count <= 20,
                "Page 2 should display up to 20 books, but found " + page2Count);
    }
}
