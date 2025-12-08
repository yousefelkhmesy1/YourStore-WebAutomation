package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class cartPage {
    WebDriver driver;
    WebDriverWait wait;

    public cartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void gotoCartpage(){

        driver.get("https://awesomeqa.com/ui/index.php?route=checkout/cart");
    }

    public void clickonCheckout(){
        By checkout = By.linkText("Checkout");
        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(checkout));
        checkoutBtn.click();
    }
}
