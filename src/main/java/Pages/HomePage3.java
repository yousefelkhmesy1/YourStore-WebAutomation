package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage3 {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage3(WebDriver driver) {
        this.driver = driver;   // ← مهم جداً
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getDisplayedPrice() {
        WebElement priceElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".price"))
        );
        return priceElement.getText();
    }

    public void selectCurrency(String currency) {
        WebElement currencyDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("form-currency"))
        );
        currencyDropdown.click();

        switch (currency.toUpperCase()) {
            case "USD":
                wait.until(ExpectedConditions.elementToBeClickable(By.name("USD"))).click();
                break;
            case "EUR":
                wait.until(ExpectedConditions.elementToBeClickable(By.name("EUR"))).click();
                break;
            case "GBP":
                wait.until(ExpectedConditions.elementToBeClickable(By.name("GBP"))).click();
                break;
            default:
                System.out.println("Currency not supported: " + currency);
        }
    }
}
