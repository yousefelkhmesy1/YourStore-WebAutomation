package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;

    By searchBox = By.cssSelector("input.form-control");
    By searchButton = By.cssSelector("button.btn.btn-default.btn-lg");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForProduct(String product) {
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
    }
}
