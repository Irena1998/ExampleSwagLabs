package appTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckoutPageTest extends BaseTest {
    pages.LogInPage logInPageObject=new pages.LogInPage(driver);
    pages.HomePage homePageObject=new pages.HomePage(driver);
    pages.CartPage cartPageObject=new pages.CartPage(driver);

    @Before
    public void setUp() throws Exception {
        driver.get("https://www.saucedemo.com/");
        logInPageObject.successfulLogIn();
    }

    @Test
    public void FinalAccount() {
        homePageObject.addBackPackToCart();
        homePageObject.addTShirtToCart();
        homePageObject.goToCart();
        cartPageObject.checkout();
        cartPageObject.enterFirstName(randomFirstName());
        cartPageObject.enterLastName(randomLastName());
        cartPageObject.enterPostalCode(randomPostalCode());
        cartPageObject.clickContinueButton();
        js.executeScript("window.scrollBy(0,10000)","");
        String expResult= driver.findElement(cartPageObject.itemTotalPrice).getText();
        Assert.assertTrue("Item total price does not match the result", expResult.equals(cartPageObject.finalSum()));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        homePageObject.logOut();
    }
}
