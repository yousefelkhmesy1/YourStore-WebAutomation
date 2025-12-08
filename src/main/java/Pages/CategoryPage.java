package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CategoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By mainCategories = By.cssSelector("nav#menu ul.nav.navbar-nav > li > a");
    private By subCategories = By.cssSelector("div.dropdown-menu a");

    public String selectRandomMainAndSubCategory() {
        List<WebElement> mains = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("nav#menu ul.nav.navbar-nav > li")));
        WebElement mainLi = mains.get(new Random().nextInt(mains.size()));

        WebElement mainLink = mainLi.findElement(By.tagName("a"));
        String mainName = mainLink.getText();


        Actions actions = new Actions(driver);
        actions.moveToElement(mainLink).perform();

        List<WebElement> subs = mainLi.findElements(By.cssSelector("div.dropdown-menu a"));
        if (subs.isEmpty()) {
            return "The main category is "+mainName+" and no have sub categories ";
        }


        WebElement subChosen = subs.get(new Random().nextInt(subs.size()));
        String subName = subChosen.getText();

        wait.until(ExpectedConditions.elementToBeClickable(subChosen)).click();

        return "Selected MAIN Category: " + mainName + " | SubCategory: " + subName;
    }
}
