package appTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LogInPage;

public class LogInPageTest extends BaseTest{
    
    pages.LogInPage logInPageObject=new pages.LogInPage(driver);
    pages.HomePage homePageObject=new pages.HomePage(driver);

    @Before
    public void setUp() throws Exception {
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void LogInWithValidUserNameValidPassword() {
        logInPageObject.successfulLogIn();
        String expectedURL="https://www.saucedemo.com/inventory.html";
        String actualURL=driver.getCurrentUrl();
        Assert.assertTrue("Error message under input fields shows up:Epic sadface:Username and password do not match any user in this service", homePageObject.homePageLoaded());
        Assert.assertTrue("Error message under input fields shows up:Epic sadface:Username and password do not match any user in this service", expectedURL.equals(actualURL));
    }
    @Test
    public void LogInWithInvalidUserNameValidPassword() {
        logInPageObject.enterUserName(randomUserName());
        logInPageObject.enterPassword("secret_sauce");
        logInPageObject.clickOnLogInButton();
        String logInErrorMessage="Epic sadface: Username and password do not match any user in this service";
        Assert.assertTrue("Home page loaded", logInErrorMessage.equals(logInPageObject.homePageNotLoaded()));
    }
    @Test
    public void LogInWithValidUserNameInvalidPassword() {
        logInPageObject.enterUserName("standard_user");
        logInPageObject.enterPassword(randomPassword());
        logInPageObject.clickOnLogInButton();
        String logInErrorMessage="Epic sadface: Username and password do not match any user in this service";
        Assert.assertTrue("Home page loaded", logInErrorMessage.equals(logInPageObject.homePageNotLoaded()));
    }
    @Test
    public void LogInWithInvalidUserNameInvalidPassword() {
        logInPageObject.enterUserName(randomUserName());
        logInPageObject.enterPassword(randomPassword());
        logInPageObject.clickOnLogInButton();
        String logInErrorMessage="Epic sadface: Username and password do not match any user in this service";
        Assert.assertTrue("Home page loaded", logInErrorMessage.equals(logInPageObject.homePageNotLoaded()));
    }
    @Test
    public void LogInWithEmptyFields() {
        logInPageObject.enterUserName("");
        logInPageObject.enterPassword("");
        logInPageObject.clickOnLogInButton();
        String logInErrorMessage="Epic sadface: Username is required";
        Assert.assertTrue("Home page loaded", logInErrorMessage.equals(logInPageObject.homePageNotLoaded()));
    }

}
