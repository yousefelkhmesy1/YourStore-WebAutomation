package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage2 {

    WebDriver driver;

    public LoginPage2(WebDriver driver) {
        this.driver = driver;
    }

    By emailField = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginButton = By.cssSelector("input[type='submit'][value='Login']");
    By myAccountHeading = By.xpath("//h2[text()='My Account']");
    By errorMessage = By.cssSelector(".alert-danger");

    // Login action
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    // Verify successful login
    public void verifyLoginSuccessful() {
        Assert.assertTrue(driver.findElement(myAccountHeading).isDisplayed());
    }

    // Verify failed login
    public void verifyLoginFailed() {
        Assert.assertTrue(driver.findElement(errorMessage).getText().contains("Warning"));
    }
}
