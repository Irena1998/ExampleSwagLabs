package appTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddToCartTest extends BaseTest{
   pages.HomePage homePageObject=new pages.HomePage(driver);
   pages.LogInPage logInPageObject=new pages.LogInPage(driver);

    @Before
    public void setUp() throws Exception {
        driver.get("https://www.saucedemo.com/");
        logInPageObject.successfulLogIn();
    }

    @Test
    public void SuccssesfulyAddedToCart() {
        homePageObject.addBackPackToCart();
        Assert.assertTrue("Cart is empty", homePageObject.shoppingCartFull());
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        homePageObject.logOut();
    }
}
