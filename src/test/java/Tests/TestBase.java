package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);

        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/ui/index.php?route=common/home");
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void typeText(WebElement element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }

    public boolean isElementDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public void hoverOverElement(WebElement element) {
        actions.moveToElement(element).perform();
    }


    protected void openProductPage(int productId) {
        String url = "https://awesomeqa.com/ui/index.php?route=product/product&product_id=" + productId;
        driver.get(url);
    }

    protected void openWishlistPage() {
        String url = "https://awesomeqa.com/ui/index.php?route=account/wishlist";
        driver.get(url);
    }
    protected void logout() {
        String url = "https://awesomeqa.com/ui/index.php?route=account/logout";
        driver.get(url);
    }

    protected void loginUser() {
        String url = "https://awesomeqa.com/ui/index.php?route=account/login";
        driver.get(url);

        driver.findElement(By.id("input-email")).sendKeys("test@test.com");
        driver.findElement(By.id("input-password")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[type='submit'][value='Login']")).click();
    }
}
