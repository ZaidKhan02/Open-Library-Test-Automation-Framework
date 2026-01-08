package tests;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dataproviders.SearchAuthorDataProviders;
import dataproviders.SearchBookDataProvider;
import pages.*;

public class SearchTests extends BaseTest {
    HomePage homePage;
    SearchPage searchPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        homePage = new HomePage(getDriver());
    }

    @Test(groups = { "smoke" })
    public void searchByValidAuthorName() {
        String expectedAuthorName = "J. K. Rowling";
        homePage.clickAuthorTypeBtn();
        homePage.enterSearchInput("JK Rowling");
        // homePage.clickSearchBtn();
        SearchPage searchPage = homePage.clickSearchBtn();
        String actualAuthorName = searchPage.getAuthorName();
        Assert.assertEquals(actualAuthorName, expectedAuthorName,
                "Actual author name should match expected author name");
    }

    /*
     * @Test(groups = { "regression" })
     * public void searchByValidAuthorNameWithWhiteSpacing() {
     * String expectedAuthorName = "J.K. Rowling";
     * loginPage.loginUser("zaidlovesmath@gmail.com", "Louiscathat123!");
     * homePage.clickAuthorTypeBtn();
     * homePage.enterSearchInput("  JK Rowling  ");
     * homePage.clickSearchBtn();
     * searchPage.getAuthorName();
     * Assert.assertEquals(searchPage.getAuthorName(), expectedAuthorName,
     * "Actual author name should match expected author name");
     * }
     * 
     * @Test(groups = { "regression" })
     * public void searchByInvalidAuthorName() {
     * String expectedErrorMsg = "No authors directly matched your search";
     * loginPage.loginUser("zaidlovesmath@gmail.com", "Louiscathat123!");
     * homePage.clickAuthorTypeBtn();
     * homePage.enterSearchInput("14232433");
     * homePage.clickSearchBtn();
     * searchPage.getErrorMsg();
     * Assert.assertEquals(searchPage.getErrorMsg(), expectedErrorMsg,
     * "Actual error message should match expected error message");
     * }
     */

    @Test(groups = {
            "regression" }, dataProvider = "authorSearchData", dataProviderClass = SearchAuthorDataProviders.class)
    public void searchByAuthorRegression(String input, String expectedResult) {
        searchPage = new SearchPage(getDriver());
        homePage.clickAuthorTypeBtn();
        homePage.enterSearchInput(input);
        homePage.clickSearchBtn();

        if (expectedResult.startsWith("No")) {
            Assert.assertEquals(searchPage.getErrorMsg(), expectedResult);
        } else {
            Assert.assertEquals(searchPage.getAuthorName(), expectedResult);
        }
    }

    @Test(groups = { "smoke" })
    public void searchByValidBookName() {
        String expectedBookName = "Harry Potter and the Order of the Phoenix";
        homePage.enterSearchInput("Harry Potter and the Order of the Phoenix");
        homePage.clickSearchBtn();
        String actualBookName = searchPage.getBookName();
        Assert.assertEquals(actualBookName, expectedBookName,
                "Actual book name should match expected book name");
    }

    @Test(groups = { "regression" }, dataProvider = "bookSearchData", dataProviderClass = SearchBookDataProvider.class)
    public void searchByBookRegression(String input, String expectedResult) {
        homePage.enterSearchInput(input);
        homePage.clickSearchBtn();
        if (expectedResult.startsWith("No")) {
            Assert.assertEquals(searchPage.getErrorMsg(), expectedResult);
        } else {
            Assert.assertEquals(searchPage.getBookName(), expectedResult);
        }
    }

    /*
     * @Test(groups = { "regression" })
     * public void searchByValidBookNameWithWhiteSpacing() {
     * String expectedBookName = "Harry Potter and the Order of the Phoenix";
     * loginPage.loginUser("zaidlovesmath@gmail.com", "Louiscathat123!");
     * homePage.enterSearchInput("   Harry Potter and the Order of the Phoenix  ");
     * homePage.clickSearchBtn();
     * searchPage.getBookName();
     * Assert.assertEquals(searchPage.getBookName(), expectedBookName,
     * "Actual book name should match expected book name");
     * }
     * 
     * @Test(groups = { "regression" })
     * public void searchByValidBookNameWithCaseSensitivity() {
     * String expectedBookName = "Harry Potter and the Order of the Phoenix";
     * loginPage.loginUser("zaidlovesmath@gmail.com", "Louiscathat123!");
     * homePage.enterSearchInput("HARRY POTTER AND THE ORDER OF THE PHOENIX");
     * homePage.clickSearchBtn();
     * searchPage.getBookName();
     * Assert.assertEquals(searchPage.getBookName(), expectedBookName,
     * "Actual book name should match expected book name");
     * }
     * 
     * @Test(groups = { "regression" })
     * public void searchByInvalidBookName() {
     * String expectedErrorMsg =
     * "No books directly matched your search. Add a new book?";
     * loginPage.loginUser("zaidlovesmath@gmail.com", "Louiscathat123!");
     * homePage.enterSearchInput("thisisnotabookname");
     * homePage.clickSearchBtn();
     * searchPage.getErrorMsg();
     * Assert.assertEquals(searchPage.getErrorMsg(), expectedErrorMsg,
     * "Actual error message should match expected error message");
     * }
     */

}