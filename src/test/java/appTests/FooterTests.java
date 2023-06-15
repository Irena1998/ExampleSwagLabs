package appTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;

public class FooterTests extends BaseTest{

    pages.HomePage homePageObject=new pages.HomePage(driver);
    pages.LogInPage logInPageObject=new pages.LogInPage(driver);


    @Before
    public void setUp() throws Exception {
        driver.get("https://www.saucedemo.com/");
        logInPageObject.successfulLogIn();
    }

    @Test
    public void TwitterLink() {
        js.executeScript("window.scrollBy(0,10000)","");
        driver.findElement(homePageObject.twitterLink).click();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        String expectedURL="https://twitter.com/saucelabs";
        String actualURL=driver.getCurrentUrl();
        Assert.assertTrue("Twitter page not loaded",expectedURL.equals(actualURL) );
        driver.close();
        driver.switchTo().window(newTab.get(0));
        String expURL="https://www.saucedemo.com/inventory.html";
        String actURL=driver.getCurrentUrl();
        Assert.assertTrue("Home page was not reloaded", expURL.equals(actURL));
    }

    @Test
    public void FacebookLink() {
        js.executeScript("window.scrollBy(0,10000)","");
        driver.findElement(homePageObject.facebookLink).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        String expectedURL="https://www.facebook.com/saucelabs";
        String actualURL=driver.getCurrentUrl();
        Assert.assertTrue("Facebook page not loaded",expectedURL.equals(actualURL) );
        driver.close();
        driver.switchTo().window(newTab.get(0));
        String expURL="https://www.saucedemo.com/inventory.html";
        String actURL=driver.getCurrentUrl();
        Assert.assertTrue("Home page was not reloaded", expURL.equals(actURL));
    }

//    @Test
//    public void LinkedInLink() {
//        js.executeScript("window.scrollBy(0,10000)","");
//        driver.findElement(homePageObject.linkedInLink).click();
//        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(newTab.get(1));
////        String expectedURL="https://www.linkedin.com/company/sauce-labs/";
//        String expectedURL="https://www.linkedin.com/authwall?trk=bf&trkInfo=AQG2sWYBeVE8NAAAAYjAPFNY_oKwFXl4CYo03okJP0-K4p0wK_JuuRLEWgkm3R7YrbF9GLes6OD8M15dCOalHIXtH5b1pm_IaREeNTWGOFvowhB8LlXkkhSLfMDCW35xeFNdrcs=&original_referer=&sessionRedirect=https%3A%2F%2Fwww.linkedin.com%2Fcompany%2Fsauce-labs%2F";
//        String actualURL=driver.getCurrentUrl();
//        Assert.assertTrue("LinkedIn page not loaded",expectedURL.equals(actualURL) );
//        Assert.assertTrue("LinkedIn page not loaded", expectedURL.equals(actualURL));
//        driver.close();
//        driver.switchTo().window(newTab.get(0));
//        String expURL="https://www.saucedemo.com/inventory.html";
//        String actURL=driver.getCurrentUrl();
//        Assert.assertTrue("Home page was not reloaded", expURL.equals(actURL));
//    }


    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        homePageObject.logOut();
    }
}
