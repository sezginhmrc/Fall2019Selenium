package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class warmUpTask {

    private WebDriver driver ;


    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    // go to tables and click
    // click on 'last name'
    //verify that table is sorted by last name in alphapetic order
    @Test
    public void test(){

        driver.findElement(By.linkText("Sortable Data Tables")).click();
        BrowserUtils.wait(2);

        // last name
       driver.findElement(By.xpath("//table[1]//tr//th[1]")).click();
        // table[1]//*[text()='Last Name']"


        List<WebElement> lastNames =driver.findElements(By.xpath("//table[1]//tr//td[1]"));

        for (int i = 0; i <lastNames.size()-1 ; i++) {
            String value = lastNames.get(i).getText();
            String nextValue  = lastNames.get(i+1).getText();
            Assert.assertTrue(value.compareTo(nextValue)<=0);
        }
        // compare to logic is comparing based 0,1,-1
        // if the difference is negative it is sorted ........!!
        // if the difference is positive order value is after nextValue
        // if the difference 0 - value and nextvalue are equals



        // we dont even need this.
       // List<String> expected = Arrays.asList("Bach","Conway","Doe","Smith");
        // Hint ; asci numbers of chracters to compare to them in alpahabetic order ...


    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}
