package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage1 {
    WebDriver driver;
    WebDriverWait wait ;

    public HomePage1(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    public String getHeaderText1() {
        return driver.findElement(By.tagName("h2")).getText();
    }
    public String getCurrentUrl1() {
        return driver.getCurrentUrl();
    }

}
