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

    // if we referenece our dirver as a remotewebdriver
    // we dont upcasting
    // since RemoteWebDriver is implement all the interfaces
    // reference type decides what is accesible

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
        BrowserUtils.wait(5);

       // JavascriptException js = (JavascriptException) driver ;
        // since JSE is interface we cannot create object
        // upcating driver

        // since we changed our driver objet as RemoteWebDriver
        // we dont need casting it implements all interfaces
        // i need upcasting  if refrence type is a WEBDRIVER..


      //  driver.executeScript("window.scrollBy(0,250");
        // scroll down 250 pixels
        // x, y coordinates

        // we can scroll 250 pixes 10 times
       for (int i = 0; i <10 ; i++) {
            driver.executeScript("window.scrollBy(0, 250)");
            BrowserUtils.wait(3);
        }
        BrowserUtils.wait(3);
    }

    // scrolldownUntilElementVisible task
    @Test
    public void scrollToElementTest(){
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        // argument[0] -> means 1st element after comma
        driver.executeScript("arguments[0].scrollIntoView(true)",link);
        BrowserUtils.wait(3);
        // scrollintoview is javascript method

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
