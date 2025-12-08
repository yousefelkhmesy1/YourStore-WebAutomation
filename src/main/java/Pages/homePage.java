package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class homePage {
    WebDriver driver;
    WebDriverWait wait ;


    public homePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickonCompareThisProduct(){
        driver.findElement(By.cssSelector("[data-original-title='Compare this Product']")).click();
    }

    public void clickonAddproducttocart(){
        driver.findElement(By.cssSelector("[class='button-group'] i.fa-shopping-cart")).click();
    }


    public void clickontheCart(){
        By cart = By.id("cart-total");

        WebElement cartbutton = wait.until(ExpectedConditions.elementToBeClickable(cart));
        cartbutton.click();
    }

    public void clickonremovefromCart(){
        By removebutton = By.cssSelector(".btn-danger");
        WebElement Removebutton = wait.until(ExpectedConditions.visibilityOfElementLocated(removebutton));
        Removebutton.click();
    }

    public void verifyAppearingOfSuccessMessage() {
        By successAlert =By.cssSelector(".alert-success");
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert));
        Assert.assertTrue(successMessage.isDisplayed());
    }
}
