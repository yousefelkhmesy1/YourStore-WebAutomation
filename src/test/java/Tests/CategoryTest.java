package Tests;

import Pages.CategoryPage;
import Pages.HomePage3;
import org.testng.annotations.Test;

public class CategoryTest extends TestBase{
    @Test
    public void selectMainAndSubCategoriesRandomly() {
        HomePage3 home = new HomePage3(driver);

        CategoryPage cat = new CategoryPage(driver);
        String result = cat.selectRandomMainAndSubCategory();
        System.out.println(result);
    }
}
