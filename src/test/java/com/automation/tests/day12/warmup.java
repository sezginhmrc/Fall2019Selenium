package com.automation.tests.day12;

import com.automation.utilities.Driver;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class warmup {



    @Test
    public void test(){

    WebDriver driver = DriverFactory.createADriver("chrome");
    driver.get("http://practice.cybertekschool.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.linkText("Sortable Data Tables")).click();

        WebElement element = driver.findElement(By.xpath("//table[1]//thead//th[1]"));
        element.click();

        // How we check WebElements is Sorted ?
        List<WebElement> lastNames = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));
        for (int i = 0; i <lastNames.size()-1 ; i++) {
            String value = lastNames.get(i).getText();
            String nextValue = lastNames.get(i+1).getText();
            Assert.assertTrue(value.compareTo(nextValue)<0);

        }

       driver.close();
        }

    }