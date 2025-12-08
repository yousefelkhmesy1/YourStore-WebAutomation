package Tests;

import Pages.HomePage1;
import Pages.LoginPage1;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

    public class LogTest extends TestBase {
        LoginPage1 loginPage1;
        HomePage1 homePage1;

        @BeforeMethod
        public void setupPage() {
            loginPage1 = new LoginPage1(driver);
            homePage1 = new HomePage1(driver);
        }

        @Test
        public void ValidEmailAndPassword() {

            loginPage1.openLoginPage();
            loginPage1.typeEmailAndPassword("FakeAccAhmedTest01@gmai.com", "qwer1234@");

            loginPage1.CheckLoginBtn();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));

            Assert.assertEquals(homePage1.getHeaderText1(), "My Account");
            Assert.assertTrue(homePage1.getCurrentUrl1().contains("account/account"));

        }
        @Test
        public void ValidEmailAndInvalidPassword() {

            loginPage1.openLoginPage();
            loginPage1.typeEmailAndPassword("FakeAccAhmedTest01@gmai.com", "qwer1234@@");

            loginPage1.CheckLoginBtn();
            Assert.assertTrue(loginPage1.InvalidPassOrEmail().contains("Warning"), "Message is missing!");

        }
        @Test
        public void EnterEmailWithEmptyPasswordField() {

            loginPage1.openLoginPage();
            loginPage1.typeEmailAndPassword("FakeAccAhmedTest01@gmai.com", "");

            loginPage1.CheckLoginBtn();
            Assert.assertTrue(loginPage1.InvalidPassOrEmail().contains("Warning"), "Message is missing!");

        }
        @Test
        public void ClickLoginWithoutFillAnyField() {

            loginPage1.openLoginPage();
            loginPage1.typeEmailAndPassword("", "");

            loginPage1.CheckLoginBtn();
            Assert.assertTrue(loginPage1.FillAllDate().contains("Warning"), "Message is missing!");

        }
        @Test
        public void AddEmailWithoutDomainName() {

            loginPage1.openLoginPage();
            loginPage1.typeEmailAndPassword("FakeAccAhmedTest01", "qwer1234@");

            loginPage1.CheckLoginBtn();
            Assert.assertTrue(loginPage1.FillAllDate().contains("Warning"), "Message is missing!");

        }


    }


