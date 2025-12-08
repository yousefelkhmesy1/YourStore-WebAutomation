package Tests;

import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

        @Test
        public void userCanSearchForProduct() {
            SearchPage search = new SearchPage(driver);
            search.searchForProduct("Canon EOS 5D");
            String expectedText = "Search - Canon EOS 5D";
            String actualText = driver.getTitle();
            Assert.assertEquals(actualText, expectedText, "Search result title is incorrect!");

        }
    @Test
    public void userCanSearchForProduct1() {
        SearchPage search = new SearchPage(driver);
        search.searchForProduct("iMac");
        String expectedText = "Search - iMac";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText, expectedText, "Search result title is incorrect!");

    }
    @Test
    public void userCanSearchForProduct2() {
        SearchPage search = new SearchPage(driver);
        search.searchForProduct("MacBook");
        String expectedText = "Search - MacBook";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText, expectedText, "Search result title is incorrect!");

    }
    @Test
    public void userCanSearchForProduct3() {
        SearchPage search = new SearchPage(driver);
        search.searchForProduct("iPhone");
        String expectedText = "Search - iPhone";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText, expectedText, "Search result title is incorrect!");

    }

}


