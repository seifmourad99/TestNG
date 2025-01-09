package purchase2itemsTest;

import base.BaseSteps;
import org.testng.Assert;
import pages.*;

public class Scenario2 extends BaseSteps {
    @org.testng.annotations.Test

    public void testvalidCredential() throws InterruptedException {

//logintest
        LoginPage loginPage = homePage.clickonLoginLink();
        Thread.sleep(2000);
        loginPage.insertUsernamee("seiffseiff");
        loginPage.insertPasswordd("12341234");
        Thread.sleep(1000);
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        String actualresultx = loginPage.getWelcomeUserText();
        String expectedresultx = "Welcome seiffseiff";
        Assert.assertTrue(actualresultx.contains(expectedresultx));
        System.out.println(actualresultx);

//laptop1
        LaptopsfieldPage laptopsfieldPage=homePage.clickOnLaptopsFieldLink();
        Thread.sleep(2000);
        Laptop1page laptop1page= laptopsfieldPage.clickOnProduct1Page();
        Thread.sleep(2000);
        laptop1page.clickOnAddToCartButton();
        Thread.sleep(2000);
        String actualResult9 = laptop1page.getAddProductText();
        String expectedResult9 = "Product added";
        Thread.sleep(1000);
        Assert.assertTrue(actualResult9.contains(expectedResult9));
        laptop1page.accept1Alert();
        System.out.println(actualResult9);
        laptop1page.clickOnHomeBtn();
        Thread.sleep(2000);
//laptop2
        homePage.clickOnLaptopsFieldLink();
        Thread.sleep(2000);
        Laptop2page laptop2page= laptopsfieldPage.clickOnProduct2Page();
        Thread.sleep(2000);
        laptop2page.clickOnAddToCartButton2();
        Thread.sleep(2000);
        String actualResult8 = laptop2page.getAddProductText();
        String expectedResult8 = "Product added";
        Thread.sleep(1000);
        Assert.assertTrue(actualResult8.contains(expectedResult8));
        laptop2page.accept2Alert();
        System.out.println(actualResult8);
        //validate
        CartPage cartPage = homePage.clickOnCartLink();
        Thread.sleep(2000);
        String actualresult7= cartPage.getLaptop1Title();
        String expectedresult7 = "Sony vaio i5";
        Thread.sleep(1000);
        Assert.assertTrue(actualresult7.contains(expectedresult7));
        //laptop1price
        String actualresult2 = cartPage.getLaptop1Price();
        Integer expectedresult2 = 790;
        Thread.sleep(1000);
        Assert.assertTrue(actualresult2.contains(expectedresult2.toString()));
        //laptop2tittle
        String actualresult3 = cartPage.getLaptop2Tittle();
        String expectedresult3 = "Sony vaio i7";
        Thread.sleep(1000);
        Assert.assertTrue(actualresult3.contains(expectedresult3));
        //laptop2price
        String actualresult4 = cartPage.getLaptop2Price();
        Integer expectedresult4 = 790;
        Thread.sleep(1000);
        Assert.assertTrue(actualresult4.contains(expectedresult4.toString()));

        //verify total amount calculation
        String actualresult5 = cartPage.getTottalPrice();
        Integer expectedresult5 = expectedresult4+expectedresult2;
        Thread.sleep(1000);
        Assert.assertTrue(actualresult5.contains(expectedresult5.toString()));
        Thread.sleep(2000);

        //place order

        PlaceorderPage placeorderPage = cartPage.clickOnPlaceOrderbtn();
        Thread.sleep(2000);
        placeorderPage.insertPurchaseNameField("seif");
        placeorderPage.insertPurchaseCountryField("Egypt");
        placeorderPage.insertPurchaseCityField("Cairo");
        placeorderPage.insertPurchaseCreditCardField("124151242312");
        placeorderPage.insertPurchaseMonthField("11");
        placeorderPage.insertPurchaseYearField("2022");
        placeorderPage.purchaseButton();
        Thread.sleep(2000);


        String actualResult6 = placeorderPage.getSuccessMessageText();
        String expectedResult6= "Thank you for your purchase!";
        Assert.assertTrue(actualResult6.contains(expectedResult6));
    }
}
