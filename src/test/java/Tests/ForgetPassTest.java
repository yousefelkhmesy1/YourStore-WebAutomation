package Tests;

import Pages.ConfMsgForgetPassPage;
import Pages.ForgetPassPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgetPassTest extends TestBase {
    ForgetPassPage forgetPassPage;
    ConfMsgForgetPassPage confMsgForgetPassPage;

    @BeforeMethod
    public void StepPage() {
        forgetPassPage = new ForgetPassPage(driver);
        confMsgForgetPassPage = new ConfMsgForgetPassPage(driver);
    }
    @Test
    public void EnterValidEmail(){
        forgetPassPage.openPage();
        forgetPassPage.AddEmail("FakeAccAhmedTest01@gmai.com");
        forgetPassPage.ContinueBtn();

        Assert.assertTrue(confMsgForgetPassPage.CurrentUrl().contains("account/login"));
        Assert.assertTrue(confMsgForgetPassPage.ConfirmationMassage().contains("confirmation link has been sent"));

    }
    @Test
    public void EnterInvalidEmail(){
        forgetPassPage.openPage();
        forgetPassPage.AddEmail("FakeAccAhm1@gmai.com");
        forgetPassPage.ContinueBtn();

        Assert.assertTrue(forgetPassPage.InvalidEmail().contains("Warning"), "Message is missing!");
    }
    @Test
    public void EnterEmailWithoutDomainName(){
        forgetPassPage.openPage();
        forgetPassPage.AddEmail("FakeAccAhm1");
        forgetPassPage.ContinueBtn();

        Assert.assertTrue(forgetPassPage.InvalidEmail().contains("Warning"), "Message is missing!");
    }
    @Test
    public void ClickContinueWithoutAddEmail(){
        forgetPassPage.openPage();
        forgetPassPage.AddEmail("");
        forgetPassPage.ContinueBtn();

        Assert.assertTrue(forgetPassPage.InvalidEmail().contains("Warning"), "Message is missing!");
    }
    @Test
    public void AddingPhoneNumber(){
        forgetPassPage.openPage();
        forgetPassPage.AddEmail("12345678910");
        forgetPassPage.ContinueBtn();

        Assert.assertTrue(forgetPassPage.InvalidEmail().contains("Warning"), "Message is missing!");
    }


}

