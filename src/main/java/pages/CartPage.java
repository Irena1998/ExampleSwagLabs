package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    public WebDriver driver;
    public By removeProduct1Button=By.xpath("//button[@name='remove-sauce-labs-bolt-t-shirt']");
    public By checkoutButton=By.xpath("//*[text()='Checkout']");
    public By firstNameInputField=By.xpath("//input[@placeholder='First Name']");
    public By lastNameInputField=By.xpath("//input[@placeholder='Last Name']");
    public By postalCodeInputField=By.xpath("//input[@placeholder='Zip/Postal Code']");
    public By continueButton=By.xpath("//input[@type='submit']");
    public By finishButton=By.xpath("//*[text()='Finish']");
    public By successfulOrderMessage=By.xpath("//*[text()='Thank you for your order!']");
    public By verificationSign=By.xpath("//img[@alt='Pony Express']");
    public By itemTotalPrice=By.xpath("//*[@class='summary_subtotal_label']");
    public By cartBadge1=By.xpath("//*[@class='shopping_cart_badge'][text()='1']");
    public By cartBadge2=By.xpath("//*[@class='shopping_cart_badge'][text()='2']");
    public CartPage (WebDriver driver){
        this.driver=driver;
    }

    public void checkout(){
        driver.findElement(checkoutButton).click();
    }
    public void enterFirstName(String enterFirstName){
        driver.findElement(firstNameInputField).sendKeys(enterFirstName);
    }
    public void enterLastName (String enterLastName){
        driver.findElement(lastNameInputField).sendKeys(enterLastName);
    }
    public void enterPostalCode (String enterPostalCode){
        driver.findElement(postalCodeInputField).sendKeys(enterPostalCode);
    }
    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }

    public void clickRemoveButton(){
        driver.findElement(removeProduct1Button).click();
    }
    public String orderMessage(){
        return driver.findElement(successfulOrderMessage).getText();
    }
    public boolean displayedVerificationSign(){
        return driver.findElement(verificationSign).isDisplayed();
    }
    public String acctualURLCompleteShopping(){
        return driver.getCurrentUrl();
    }


    public double finalAccount() {
        double firstProductPrice = 29.99;
        double secondProductPrice= 15.99;
        return firstProductPrice+secondProductPrice;
    }
    public String finalSum(){
        return "Item total: $"+finalAccount();
    }




    }













