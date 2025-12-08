package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class checkoutPage {
    WebDriver driver;
    WebDriverWait wait;

    public checkoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void enterEmailandPassword(String email , String password) throws InterruptedException {
        By usernamefield = By.id("input-email");
        WebElement usernamefield2 = wait.until(ExpectedConditions.visibilityOfElementLocated(usernamefield));

        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("button-login")).click();
    }

    public void clickonbuttonpaymentaddress(){
        By continuebtn = By.id("button-payment-address");
        WebElement continuebutton = wait.until(ExpectedConditions.elementToBeClickable(continuebtn));
        continuebutton.click();
    }
    public void clickonbuttonshippingaddress(){
        By continuebtn = By.id("button-shipping-address");
        WebElement continuebutton = wait.until(ExpectedConditions.elementToBeClickable(continuebtn));
        continuebutton.click();
    }

    public void clickonbuttonshippingmethod(){
        By continuebtn = By.id("button-shipping-method");
        WebElement continuebutton = wait.until(ExpectedConditions.elementToBeClickable(continuebtn));
        continuebutton.click();
    }
    public void clickonagreefortermsandconditions(){
        By termsandconditions = By.cssSelector("[name='agree']");
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(termsandconditions));
        checkbox.click();
    }

    public void clickonbuttonpaymentmethod(){
        By continuebtn = By.id("button-payment-method");
        WebElement continuebutton = wait.until(ExpectedConditions.elementToBeClickable(continuebtn));
        continuebutton.click();
    }

    public void clickonbuttonconfirm(){
        By continuebtn = By.id("button-confirm");
        WebElement continuebutton = wait.until(ExpectedConditions.elementToBeClickable(continuebtn));
        continuebutton.click();
    }

    public void assertonorderplaced(){
        By success = By.linkText("Success");
        WebElement successatheader = wait.until(ExpectedConditions.visibilityOfElementLocated(success));
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"Your order has been placed!");
    }
}
