import Pages.HomePage3;
import Tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CurrencyTest extends TestBase {

    @Test
    public void testCurrencySwitchForLoggedUser1() {

        HomePage3 home = new HomePage3(driver);

        // USD
        home.selectCurrency("USD");
        String priceUSD = home.getDisplayedPrice();
        System.out.println("Price in USD: " + priceUSD);
        Assert.assertTrue(priceUSD.contains("$"), "Currency not switched to USD!");
    }
        @Test
        public void testCurrencySwitchForLoggedUser2() {
            HomePage3 home = new HomePage3(driver);
            // EUR
            home.selectCurrency("EUR");
            String priceEUR = home.getDisplayedPrice();
            System.out.println("Price in EUR: " + priceEUR);
            Assert.assertTrue(priceEUR.contains("€"), "Currency not switched to EUR!");
    }
    @Test
    public void testCurrencySwitchForLoggedUser3() {
        HomePage3 home = new HomePage3(driver);

        // GBP
        home.selectCurrency("GBP");
        String priceGBP = home.getDisplayedPrice();
        System.out.println("Price in GBP: " + priceGBP);
        Assert.assertTrue(priceGBP.contains("£"), "Currency not switched to GBP!");
    }
}
