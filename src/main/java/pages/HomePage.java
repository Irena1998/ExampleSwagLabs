package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public WebDriver driver;
    public By products=By.xpath("//*[text()='Products']");
    public By addToCartButton=By.xpath("//*[text()='Add to cart']");
    public By TShirtButton=By.xpath("//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']");
    public By BackPackButton=By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']");
    public By shoppingCart=By.xpath("//a[@class='shopping_cart_link']");
    public By shoppingCartBadge=By.xpath("//*[@class='shopping_cart_badge']");
    public By removeButton=By.xpath("//button[@data-test='remove-sauce-labs-bolt-t-shirt']");

    public By twitterLink=By.xpath("//a[@href='https://twitter.com/saucelabs']");
    public By facebookLink=By.xpath("//a[@href='https://www.facebook.com/saucelabs']");
    public By linkedInLink=By.xpath("//a[@href='https://www.linkedin.com/company/sauce-labs/']");
   public By openMenu=By.xpath("//*[text()='Open Menu']");
   public By logOutButton=By.xpath("//*[text()='Logout']");


    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public boolean homePageLoaded(){
        if (driver.findElement(products).isDisplayed()&& driver.findElement(addToCartButton).isDisplayed()){
            return true;
        }
        else {
            return false;
        }
    }
    public void addBackPackToCart(){
        driver.findElement(BackPackButton).click();
    }
    public void addTShirtToCart(){
        driver.findElement(TShirtButton).click();
    }
    public void goToCart(){
        driver.findElement(shoppingCart).click();
    }
    public boolean shoppingCartFull(){
         return  driver.findElement(shoppingCartBadge).isDisplayed();
    }

    public boolean addToCartButtonChangesToRemoveButton(){
        return driver.findElement(removeButton).isDisplayed();
    }
    public void logOut(){
        driver.findElement(openMenu).click();
        driver.findElement(logOutButton).click();
    }



}
