package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTestNG {
    @Test(priority = 0, description = "Verify that message is displayed : 'This page returned a 200 status code'")
    public void test9(){

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Status Codes")).click();
        // xpath -> //a[text()='Status Codes']
        // xpath -> //a[contains(text(),'Status Code')]
        // partialLinkText -> ("Status")
        // xpath -> siblings to parent ->//ul/li[46]
        // We can also find element and store into WebElement variable more felxible codes
        WebElement statucode = driver.findElement(By.linkText("200"));
        statucode.click();
        // xpath -> //a[text()='200']

        String expected = "This page returned a 200 status code.";
        WebElement displayMessageElement = driver.findElement(By.xpath("//p"));
        String actual = displayMessageElement.getText();

        if(actual.contains(expected)){
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        BrowserUtils.wait(2);
        driver.quit();
    }

    @DataProvider(name="testData")
    public Object [] testData(){
        return new Object[] {"200","301"} ;
    }
    @Test (priority = 1 , dataProvider = "testData")
    public void TestCase10(){

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.linkText("301")).click();

        String expected = "This page returned a 301 status code.";
        String actual = driver.findElement(By.xpath("//p")).getText();

        if(actual.contains(expected)){
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        BrowserUtils.wait(2);
        driver.close();
    }
}
