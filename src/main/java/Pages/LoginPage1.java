package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage1 {
    WebDriver driver;
    WebDriverWait wait ;


    public LoginPage1(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void openLoginPage() {
        driver.get("https://awesomeqa.com/ui/index.php?route=account/login");
    }
    public void typeEmailAndPassword(String email, String pass) {
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-password")).sendKeys(pass);
    }

    public void CheckLoginBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Btn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Login']")));
        driver.findElement(By.cssSelector("[value='Login']")).click();
    }

    public String InvalidPassOrEmail() {
        return driver.findElement(By.cssSelector(".alert-danger")).getText();
    }
    public String FillAllDate() {
        return driver.findElement(By.cssSelector(".alert-dismissible")).getText();
    }

}

