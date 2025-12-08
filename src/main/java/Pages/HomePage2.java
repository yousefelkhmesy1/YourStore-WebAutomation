package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomePage2 {

    WebDriver driver;
    Actions actions;

    public HomePage2(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    // My Account dropdown & login
    By myAccountDropdown = By.cssSelector("a[title='My Account']");
    By loginLink = By.linkText("Login");

    // Main Categories
    public By desktopsCategory = By.linkText("Desktops");
    public By laptopsCategory = By.linkText("Laptops & Notebooks");
    public By componentsCategory = By.linkText("Components");

    // Wishlist
    By wishlistButtons = By.cssSelector("button[data-original-title='Add to Wish List']");
    By wishlistIcon = By.id("wishlist-total");

    // Sample product
    public By palmTreoProduct = By.linkText("Palm Treo Pro");

    public void clickMyAccount() {
        driver.findElement(myAccountDropdown).click();
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void clickCategory(By category) {
        driver.findElement(category).click();
    }

    public void hoverOnCategory(By category) throws InterruptedException {
        WebElement element = driver.findElement(category);
        actions.moveToElement(element).perform();
        Thread.sleep(1500);
    }

    public void addProductsToWishlist(int count) throws InterruptedException {
        List<WebElement> buttons = driver.findElements(wishlistButtons);
        for (int i = 0; i < count && i < buttons.size(); i++) {
            buttons.get(i).click();
            Thread.sleep(1000);
        }
    }

    public void clickWishlistIcon() {
        driver.findElement(wishlistIcon).click();
    }
}
