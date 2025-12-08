package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class productPage {
    WebDriver driver;
    WebDriverWait wait;

    public productPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void gotoProductPage(){
        driver.get("https://awesomeqa.com/ui/index.php?route=product/category&path=20_27");
    }

    public void clickonAddProducttoCart(){
        By addtocart = By.cssSelector("[class='button-group'] i.fa-shopping-cart");
        WebElement addtocartbutton = wait.until(ExpectedConditions.elementToBeClickable(addtocart));
        addtocartbutton.click();
    }
}
