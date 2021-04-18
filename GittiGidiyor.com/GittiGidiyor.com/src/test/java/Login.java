package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class Login {

    public  WebDriver driver;

    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\gozcan\\Downloads\\MelisaOzcan\\GittiGidiyor\\Proje\\geckodriver.exe");
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drives/chromedriver.exe");
        String url = "https://www.gittigidiyor.com/";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void TestHome(){

        WebElement signbtn= driver.findElement(By.className("btnSignIn"));
        signbtn.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement mailbox= driver.findElement(By.id("email"));
        mailbox.click();
        mailbox.sendKeys("Your Mail Adress");

        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("Your Password");
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.id("loginButton")).click();
    }
    @After
    public void quitDriver(){
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.quit();
    }
}