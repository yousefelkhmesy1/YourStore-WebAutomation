package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void clickButton(WebElement element) {
        element.click();
    }
}
