package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuccessRegistertionPage {
    WebDriver driver;
    WebDriverWait wait ;


    public SuccessRegistertionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    public String getHeaderText() {
        return driver.findElement(By.tagName("h1")).getText();
    }
    public String getParagraphText() {
        return driver.findElement(By.cssSelector("#content p")).getText();
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
