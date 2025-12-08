package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    WebDriver driver;
    WebDriverWait wait;


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void openRegPage() {
        driver.get("https://awesomeqa.com/ui/index.php?route=account/register");
    }

    public void typeFirstName(String firstname) {
        driver.findElement(By.id("input-firstname")).sendKeys(firstname);
    }

    public void typeLastname(String lastname) {
        driver.findElement(By.id("input-lastname")).sendKeys(lastname);
    }

    public void typeEmail(String email) {
        driver.findElement(By.id("input-email")).sendKeys(email);
    }

    public void typeTelephone(String num) {
        driver.findElement(By.id("input-telephone")).sendKeys(num);
    }

    public void typePassword(String pass) {
        driver.findElement(By.id("input-password")).sendKeys(pass);
    }

    public void typeConfPassword(String confPass) {
        driver.findElement(By.id("input-confirm")).sendKeys(confPass);
    }

    public void ClickSubscribeYes() {
        driver.findElement(By.cssSelector("input[name='newsletter'][value='1']")).click();
    }

    public void ClickSubscribeNo() {
        driver.findElement(By.cssSelector("input[name='newsletter'][value='0']")).click();
    }

    public void policy() {
        driver.findElement(By.cssSelector("input[name='agree']")).click();
    }

    public void clickContinue() {
        driver.findElement(By.cssSelector("input[type='submit'][value='Continue']")).click();
    }

    public String getWarningMessage() {
        return driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
    }

    public boolean isWarningMessageDisplayed() {
        try {
            WebElement warning = driver.findElement(By.cssSelector(".alert-danger"));
            return warning.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String PasswordNotMatched() {
        return driver.findElement(By.cssSelector(".required.has-error")).getText();
    }
    public String getLastNameWarningMessage() {
        WebElement warning = driver.findElement(By.cssSelector("#account > div:nth-child(4) .text-danger"));
        return warning.getText();
    }
    public String getFirstNameWarningMessage() {
        WebElement warning = driver.findElement(By.cssSelector("#account > div:nth-child(3) .text-danger"));
        return warning.getText();
    }
    public String getTelephoneWarningMessage() {
        WebElement warning = driver.findElement(By.cssSelector("#account > div:nth-child(6) .text-danger"));
        return warning.getText();
    }
}



