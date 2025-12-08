package Tests;

import Pages.homePage;
import org.testng.annotations.Test;

public class cartTest extends TestBase{
    @Test
    public void addproducttocart(){
        homePage homepage = new homePage(driver);
        homepage.clickonAddproducttocart();
        homepage.clickontheCart();
        homepage.clickonremovefromCart();
    }
}
