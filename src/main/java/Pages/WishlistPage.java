package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class WishlistPage {

    WebDriver driver;

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    By wishlistItems = By.cssSelector(".table-responsive tbody tr");
    By pageHeading = By.xpath("//h2[contains(text(),'My Wish List')]");
    By firstProductName = By.cssSelector("table tbody tr td:nth-child(2) a");
    By firstRemoveButton = By.cssSelector("table tbody tr td a.btn-danger");
    By firstAddToCartButton = By.cssSelector("table tbody tr td button.btn-primary");

    // Count wishlist items
    public int getWishlistItemsCount() {
        List<WebElement> items = driver.findElements(wishlistItems);
        return items.size();
    }

    // Verify Wishlist page opened
    public void verifyWishlistPageOpened() {
        Assert.assertTrue(driver.findElement(pageHeading).isDisplayed());
    }

    // Remove first item
    public void removeFirstItem() {
        driver.findElement(firstRemoveButton).click();
    }

    // Add first item to cart
    public void addFirstItemToCart() {
        driver.findElement(firstAddToCartButton).click();
    }

    // Get first product name
    public String getFirstProductName() {
        return driver.findElement(firstProductName).getText();
    }
}
