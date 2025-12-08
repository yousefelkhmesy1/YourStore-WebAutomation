package Tests;

import Pages.cartPage;
import Pages.checkoutPage;
import Pages.homePage;
import Pages.productPage;
import org.testng.annotations.Test;

public class endtoend extends TestBase{
    @Test
    public void EndToEnd() throws InterruptedException {
        productPage productpage = new productPage(driver);
        homePage homepage = new homePage(driver);
        cartPage cartpage = new cartPage(driver);
        checkoutPage checkoutpage = new checkoutPage(driver);

        productpage.gotoProductPage();
        productpage.clickonAddProducttoCart();
        homepage.verifyAppearingOfSuccessMessage();
        cartpage.gotoCartpage();
        cartpage.clickonCheckout();
        checkoutpage.enterEmailandPassword("Mostafaelhadytester@gmail.com","Automation2025@");
        checkoutpage.clickonbuttonpaymentaddress();
        checkoutpage.clickonbuttonshippingaddress();
        checkoutpage.clickonbuttonshippingmethod();
        checkoutpage.clickonagreefortermsandconditions();
        checkoutpage.clickonbuttonpaymentmethod();
        checkoutpage.clickonbuttonconfirm();

        checkoutpage.assertonorderplaced();



    }
}
