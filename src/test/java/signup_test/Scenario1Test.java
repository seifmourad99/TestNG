package signup_test;

import base.BaseSteps;
import org.openqa.selenium.*;
import org.testng.Assert;
import pages.SignupPage;

import static org.testng.Assert.assertTrue;
public class Scenario1Test extends BaseSteps {

    @org.testng.annotations.Test
    public void testvalidCredential() throws InterruptedException {
        SignupPage signupPage = homePage.clickOnSignupLink();
        Thread.sleep(2000);
        signupPage.insertUsername("seiffseiff");
        signupPage.insertPassword("12341234");
        Thread.sleep(1000);
        signupPage.clickSignUpButton();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        String actualResult = signupPage.getSinupAlertMessageText();
        String expectedResult = "Sign up successful";
        Assert.assertTrue(actualResult.contains(expectedResult));
        signupPage.acceptAlert();
    }
}