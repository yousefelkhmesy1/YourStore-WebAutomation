package Tests;

import Pages.RegisterPage;
import Pages.SuccessRegistertionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest extends TestBase {
    RegisterPage registerPage;
    SuccessRegistertionPage successRegistertionPage;

    @BeforeMethod
    public void setupRagister() {
        registerPage = new RegisterPage(driver);
        successRegistertionPage = new SuccessRegistertionPage(driver);
    }

    @Test
    public void EnterValidDataForRegistertion() {
        registerPage.openRegPage();
        registerPage.typeFirstName("Ahmed");
        registerPage.typeLastname("Ibrahim");
        registerPage.typeEmail("ZXA211BG001FD@gmail.com");
        registerPage.typeTelephone("01234567891");
        registerPage.typePassword("Yousef213@");
        registerPage.typeConfPassword("Yousef213@");
        registerPage.ClickSubscribeYes();
        registerPage.policy();


        registerPage.clickContinue();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        Assert.assertEquals(successRegistertionPage.getHeaderText(), "Your Account Has Been Created!");
        Assert.assertTrue(successRegistertionPage.getParagraphText().contains("Congratulations!"));
        Assert.assertTrue(successRegistertionPage.getCurrentUrl().contains("account/success"));

    }

    @Test
    public void FillAllFieldsWithoutAgreeToPolicy() {
        registerPage.openRegPage();
        registerPage.typeFirstName("Ahmed");
        registerPage.typeLastname("Ibrahim");
        registerPage.typeEmail("RedAndBlue00001@gmail.com");
        registerPage.typeTelephone("01234567891");
        registerPage.typePassword("Yousef213@");
        registerPage.typeConfPassword("Yousef213@");
        registerPage.ClickSubscribeYes();
        //regPage.policy();

        registerPage.clickContinue();

        Assert.assertTrue(registerPage.getWarningMessage().contains("Warning"), "Message is missing!");
    }

    @Test
    public void AddLetterInTelephoneField() {
        registerPage.openRegPage();
        registerPage.typeFirstName("Ahmed");
        registerPage.typeLastname("Ibrahim");
        registerPage.typeEmail("RedAndBlue@gmail.com");
        registerPage.typeTelephone("assdqwwer"); // invalid telephone
        registerPage.typePassword("Yousef213@");
        registerPage.typeConfPassword("Yousef213@");
        registerPage.ClickSubscribeYes();
        registerPage.policy();
        registerPage.clickContinue();

        Assert.assertTrue(
                registerPage.isWarningMessageDisplayed(),
                "Expected warning when telephone contains letters, but no warning appeared!");
    }

    @Test
    public void PasswordNotMatched() {
        registerPage.openRegPage();
        registerPage.typeFirstName("Ahmed");
        registerPage.typeLastname("Ibrahim");
        registerPage.typeEmail("RedAndBlue@gmail.com");
        registerPage.typeTelephone("assdqwwer");
        registerPage.typePassword("Yousef213@");
        registerPage.typeConfPassword("qwer1234@");
        registerPage.ClickSubscribeYes();
        registerPage.policy();

        registerPage.clickContinue();

        String actualMessage = registerPage.PasswordNotMatched();
        System.out.println("Actual message: " + actualMessage);

        Assert.assertTrue(
                actualMessage.contains("Password confirmation does not match password!"),
                "Expected 'Password confirmation does not match password!' but got: " + actualMessage);
    }
    @Test
    public void LetLastNameFieldWithData() {
        registerPage.openRegPage();
        registerPage.typeFirstName("Ahmed");
        registerPage.typeLastname("");
        registerPage.typeEmail("RedAndBlue@gmail.com");
        registerPage.typeTelephone("12345678910");
        registerPage.typePassword("Yousef213@");
        registerPage.typeConfPassword("Yousef213@");
        registerPage.ClickSubscribeYes();
        registerPage.policy();

        registerPage.clickContinue();

        String actualMessage = registerPage.getLastNameWarningMessage();
        System.out.println("Actual message: " + actualMessage);

        Assert.assertTrue(
                actualMessage.contains("Last Name must be between 1 and 32 characters!"),
                "Expected 'Last Name must be between 1 and 32 characters!' but got: " + actualMessage);
    }
    @Test
    public void LetFirstNameFieldWithData() {
        registerPage.openRegPage();
        registerPage.typeFirstName("");
        registerPage.typeLastname("Ziad");
        registerPage.typeEmail("RedAndBlue@gmail.com");
        registerPage.typeTelephone("12345678910");
        registerPage.typePassword("Yousef213@");
        registerPage.typeConfPassword("Yousef213@");
        registerPage.ClickSubscribeYes();
        registerPage.policy();

        registerPage.clickContinue();

        String actualMessage = registerPage.getFirstNameWarningMessage();
        System.out.println("Actual message: " + actualMessage);

        Assert.assertTrue(
                actualMessage.contains("First Name must be between 1 and 32 characters!"),
                "Expected 'First Name must be between 1 and 32 characters!' but got: " + actualMessage);
    }
    @Test
    public void LetTelephoneFieldWithData() {
        registerPage.openRegPage();
        registerPage.typeFirstName("Ahmed");
        registerPage.typeLastname("Ziad");
        registerPage.typeEmail("RedAndBlue@gmail.com");
        registerPage.typeTelephone("");
        registerPage.typePassword("Yousef213@");
        registerPage.typeConfPassword("Yousef213@");
        registerPage.ClickSubscribeYes();
        registerPage.policy();

        registerPage.clickContinue();

        String actualMessage = registerPage.getTelephoneWarningMessage();
        System.out.println("Actual message: " + actualMessage);

        Assert.assertTrue(
                actualMessage.contains("Telephone must be between 3 and 32 characters!"),
                "Expected 'Telephone must be between 3 and 32 characters! ' but got: " + actualMessage);
    }
}
