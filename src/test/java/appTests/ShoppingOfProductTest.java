package appTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShoppingOfProductTest extends BaseTest{
    pages.LogInPage logInPageObject=new pages.LogInPage(driver);
    pages.HomePage homePageObject=new pages.HomePage(driver);
    pages.CartPage cartPageObject=new pages.CartPage(driver);

    @Before
    public void setUp() throws Exception {
        driver.get("https://www.saucedemo.com/");
        logInPageObject.successfulLogIn();
    }

    @Test
    public void SuccessfulShopping() {
        homePageObject.addBackPackToCart();
        homePageObject.goToCart();
        cartPageObject.checkout();
        cartPageObject.enterFirstName(randomFirstName());
        cartPageObject.enterLastName(randomLastName());
        cartPageObject.enterPostalCode(randomPostalCode());
        cartPageObject.clickContinueButton();
        cartPageObject.clickFinishButton();
        String expectedMessage = "Thank you for your order!";
        String expectedURL = "https://www.saucedemo.com/checkout-complete.html";
        Assert.assertTrue("Thank you for your order!-message did not appear", expectedMessage.equals(cartPageObject.orderMessage()));
        Assert.assertTrue("Thank you for your order!-message did not appear", cartPageObject.displayedVerificationSign());
        Assert.assertTrue("Thank you for your order!-message did not appear", expectedURL.equals(cartPageObject.acctualURLCompleteShopping()));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        homePageObject.logOut();
    }
}
