package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfMsgForgetPassPage {
    WebDriver driver;
    WebDriverWait wait ;


    public ConfMsgForgetPassPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    public String CurrentUrl() {
        return driver.getCurrentUrl();
    }
    public String ConfirmationMassage() {
        return driver.findElement(By.cssSelector(".alert-success")).getText();
    }
}
