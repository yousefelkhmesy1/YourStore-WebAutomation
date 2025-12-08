package Tests;

import Pages.comparePage;
import Pages.homePage;
import org.testng.annotations.Test;

public class compareTest extends TestBase{
    @Test
    public void verifyAddingProductTOComparePage() throws InterruptedException {
        comparePage comparepage = new comparePage(driver);
        homePage homepage = new homePage(driver);
        homepage.clickonCompareThisProduct();
        homepage.verifyAppearingOfSuccessMessage();
        comparepage.clickoncomparepage();
        comparepage.clickonremove();
    }
}
