package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgetPassPage {
    WebDriver driver;
    WebDriverWait wait;


    public ForgetPassPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void openPage() {
        driver.get("https://awesomeqa.com/ui/index.php?route=account/forgotten");
    }

    public void AddEmail(String email) {
        driver.findElement(By.id("input-email")).sendKeys(email);
    }

    public void ContinueBtn() {
        driver.findElement(By.cssSelector("[value='Continue']")).click();
    }

    public String InvalidEmail() {
        return driver.findElement(By.cssSelector("#account-forgotten > div.alert.alert-danger")).getText();
    }

    public String ClickContinueNoData() {
        return driver.findElement(By.cssSelector(".alert-dismissible")).getText();
    }
}
