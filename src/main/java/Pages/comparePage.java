package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class comparePage {
    WebDriver driver;
    WebDriverWait wait;

    public comparePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }



    public void clickoncomparepage(){
        By productComparison = By.partialLinkText("product comparison");
        WebElement productComparison2 = wait.until(ExpectedConditions.elementToBeClickable(productComparison));
        productComparison2.click();
    }

    public void clickonremove(){
        By removebutton = By.cssSelector(".btn-danger");
        WebElement Removebutton = wait.until(ExpectedConditions.visibilityOfElementLocated(removebutton));
        Removebutton.click();
        By alretsuccess = By.cssSelector(".alert-success");
        WebElement Alertsuccuss = wait.until(ExpectedConditions.visibilityOfElementLocated(alretsuccess));
        Assert.assertTrue(Alertsuccuss.isDisplayed());
    }
}
