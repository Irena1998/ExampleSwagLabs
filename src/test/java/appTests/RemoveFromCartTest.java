package appTests;

import org.junit.*;

public class RemoveFromCartTest extends BaseTest{
    pages.LogInPage logInPageObject=new pages.LogInPage(driver);
    pages.HomePage homePageObject=new pages.HomePage(driver);
    pages.CartPage cartPageObject=new pages.CartPage(driver);

    @Before
    public void setUp() throws Exception {
        driver.get("https://www.saucedemo.com/");
        logInPageObject.successfulLogIn();
    }
    @Test
    public void RemoveProductFromCart() {
        homePageObject.addBackPackToCart();
        homePageObject.addTShirtToCart();
        homePageObject.goToCart();
        String cartBadgeBeforeDelete=driver.findElement(cartPageObject.cartBadge2).getText();
        cartPageObject.clickRemoveButton();
        String cartBadgeAfterDelete=driver.findElement(cartPageObject.cartBadge1).getText();
        Assert.assertFalse("Shopping cart badge shows up 2 products in the cart", cartBadgeBeforeDelete.equals(cartBadgeAfterDelete) );
    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        homePageObject.logOut();
    }
}
