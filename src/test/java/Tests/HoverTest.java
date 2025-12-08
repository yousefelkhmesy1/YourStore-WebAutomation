package Tests;

import Pages.HomePage2;
import org.testng.annotations.Test;

public class HoverTest extends TestBase {

    @Test
    public void HoverMainCategories() throws InterruptedException {
        HomePage2 homePage = new HomePage2(driver);


        homePage.hoverOnCategory(homePage.desktopsCategory);
        homePage.hoverOnCategory(homePage.laptopsCategory);
        homePage.hoverOnCategory(homePage.componentsCategory);

    }
}
