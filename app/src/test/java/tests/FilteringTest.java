package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

public class FilteringTest extends BaseTest {

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

    @Test(groups = { "regression" })
    public void firstBookRatingShouldBeGreaterThanOrEqualToSecondBookRating() {
        homePage.enterSearchInput("Harry Potter and the Order of the Phoenix");
        homePage.clickSearchBtn();

        List<Double> ratings = searchPage.getAllBookRatings(); 

        // Guard clause to prevent false failures
        Assert.assertTrue(ratings.size() >= 2, "Less than two rated books were found in search results");

        // Assert ratings are sorted in descending order
        for (int i = 0; i < ratings.size() - 1; i++) {
            Assert.assertTrue(
                    ratings.get(i) >= ratings.get(i + 1),
                    "Ratings not sorted at index " + i + ": " + ratings.get(i) + " < " + ratings.get(i + 1));
        }

        /*
         * double firstRating = ratings.get(0);
         * double secondRating = ratings.get(1);
         * 
         * Assert.assertTrue(firstRating >= secondRating,
         * "Expected first rating >= second rating but got " + firstRating + " < " +
         * secondRating);
         */

    }
}
