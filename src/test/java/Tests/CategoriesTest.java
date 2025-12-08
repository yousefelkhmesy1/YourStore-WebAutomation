package Tests;

import Pages.HomePage2;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CategoriesTest extends TestBase{
    @Test(priority = 1)
    public void LoggedUserDifferentCategories() throws InterruptedException {
        HomePage2 homePage = new HomePage2(driver);


        homePage.clickCategory(homePage.desktopsCategory);
        driver.findElement(By.partialLinkText("Show All")).click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("path=20"));

        homePage.clickCategory(homePage.laptopsCategory);
        driver.findElement(By.partialLinkText("Show All")).click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("path=18"));
    }

    @Test(priority = 2)
    public void OpenProductFromCategory() throws InterruptedException {
        HomePage2 homePage = new HomePage2(driver);

        homePage.clickCategory(homePage.desktopsCategory);
        driver.findElement(By.partialLinkText("Show All")).click();
        Thread.sleep(1000);

        driver.findElement(homePage.palmTreoProduct).click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().contains("Palm Treo"));
    }
}
