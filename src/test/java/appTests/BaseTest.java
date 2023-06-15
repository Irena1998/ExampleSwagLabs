package appTests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public static WebDriver driver;
    Faker fake=new Faker();
    JavascriptExecutor js=(JavascriptExecutor) driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.quit();
    }
    public String randomUserName(){
        return fake.name().username();
    }
    public String randomPassword(){
        return fake.animal().name();
    }
    public String randomFirstName(){
        return fake.name().firstName();
    }
    public String randomLastName(){
        return fake.name().lastName();
    }
    public int getRandomNummber(){
        return (int) (Math.random()*100000);
    }
    public String randomPostalCode(){
        return getRandomNummber()+"";
    }


}
