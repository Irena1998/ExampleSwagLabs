package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.security.SecureRandom;

public class LogInPage {

    public WebDriver driver;

    public By userNameInputField= By.xpath("//input[@placeholder='Username']");
    public By passwordInputField= By.xpath("//input[@placeholder='Password']");
    public By logInButton= By.xpath("//input[@type='submit']");
    public By logInError= By.xpath("//h3[@data-test='error']");

    public LogInPage(WebDriver driver){
        this.driver=driver;
    }
    public void enterUserName (String enterUserName){
        driver.findElement(userNameInputField).sendKeys(enterUserName);
    }
    public void enterPassword (String enterPassword){
        driver.findElement(passwordInputField).sendKeys(enterPassword);
    }
    public void clickOnLogInButton(){
        driver.findElement(logInButton).click();
    }
    public String homePageNotLoaded(){
        return driver.findElement(logInError).getText();
    }
    public void successfulLogIn(){
        driver.findElement(userNameInputField).sendKeys("standard_user");
        driver.findElement(passwordInputField).sendKeys("secret_sauce");
        driver.findElement(logInButton).click();
    }











}
