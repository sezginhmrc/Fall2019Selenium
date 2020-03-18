package com.automation.tests.Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestScripts {

    private WebDriver driver ;

    @BeforeMethod
    public void setup (){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @Test (description = "registration form")
    public void test1(){

        driver.get("http://practice.cybertekschool.com/");

        List<WebElement> links = driver.findElements(By.className("list-group"));

    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}





/**/