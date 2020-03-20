package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JsExecutor {

    private RemoteWebDriver driver;
// better to use RemoteWebdriver beacuse it is bigger than webdriver and has more things


    @BeforeMethod
    public void setup(){

       // driver = DriverFactory.createADriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @Test
    public void scrollTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
       // JavascriptException js = (JavascriptException) driver ;
        // since JSE is interface we cannot create object
        // casting

        for (int i = 0; i <10 ; i++) {
            driver.executeScript("window.scrollBy(0, 250)");
            BrowserUtils.wait(3);
        }
        BrowserUtils.wait(3);
    }

    @Test
    public void scrollToElementTest(){
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        driver.executeScript("arguments[0].scrollIntoView(true)",link);
        BrowserUtils.wait(3);
        // scrollintoview is javascript method
        // it means 1st webelement after comma
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
