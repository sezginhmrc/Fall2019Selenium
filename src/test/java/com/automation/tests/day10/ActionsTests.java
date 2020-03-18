package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class ActionsTests {
    private WebDriver driver;
    private Actions actions ;


    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createADriver("chrome");
        actions = new Actions(driver);


    }

    @Test
    public void hoverOnImage() {
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);

        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        // paranthesis means elements itslef, not child
        // surroundedd element with paranthesis aand index
        // it will show you specific one
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));


        actions.moveToElement(img1).
                pause(1000).moveToElement(img2).
                pause(1000).moveToElement(img3).
                build().perform();
        //build() is needed when you couple of actions
        // always end with perform
        // perfom is what do yo do with action
        // pause(1000) like Thread.sleep(1000)




    }



    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}
