package Tests;

import Pages.WishlistPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishlistTest extends TestBase {

    @Test
    public void testAddItemToWishlist() {
        openProductPage(43);

        driver.findElement(By.cssSelector("button[data-original-title='Add to Wish List']")).click();
    }

    @Test
    public void testRemoveItemFromWishlist() {
        openWishlistPage();
        WishlistPage wishlistPage = new WishlistPage(driver);

        wishlistPage.verifyWishlistPageOpened();
        wishlistPage.removeFirstItem();
    }

    @Test
    public void testAddProductToCartFromWishlist() {
        openWishlistPage();
        WishlistPage wishlistPage = new WishlistPage(driver);

        wishlistPage.verifyWishlistPageOpened();
        wishlistPage.addFirstItemToCart();
    }

    @Test
    public void testWishlistItemPersistsAfterLogout() {
        openWishlistPage();
        WishlistPage wishlistPage = new WishlistPage(driver);

        wishlistPage.verifyWishlistPageOpened();
        int beforeCount = wishlistPage.getWishlistItemsCount();

        logout();
        loginUser();
        openWishlistPage();

        WishlistPage wishlistPageAfterLogin = new WishlistPage(driver);
        int afterCount = wishlistPageAfterLogin.getWishlistItemsCount();

        Assert.assertTrue(afterCount >= 1 && afterCount >= beforeCount,
                "Wishlist item did not persist after logout/login");
    }
}
