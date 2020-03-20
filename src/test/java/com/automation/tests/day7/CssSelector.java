package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssSelector {

    public static void main(String[] args) {

        // in css ;

        // . means class name
        // # means id
        // ^ means starts-with
        //- . means clas name
        //- # means id
        //- * means contains
        //- ^ means starts-with
        //- $ means ends with
        //- :nth-of-type(1) meand by index

        //- no slash and no @ in Css
        //- cssSelector ;
        //- tagName[attribute='vale']


        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement home = driver.findElement(By.cssSelector(".nav-link"));
        WebElement heading = driver.findElement(By.cssSelector(".h3"));
        WebElement btn1 = driver.findElement(By.cssSelector("button[class='btn btn-primary']:nth-of-type(1)"));
        WebElement btn2 = driver.findElement(By.cssSelector("button[name*='ton2']"));
        WebElement btn3 = driver.findElement(By.cssSelector("button[id^='button_']"));
        WebElement btn4 = driver.findElement(By.cssSelector("button[onclick$='ton4()']"));
        WebElement btn5 = driver.findElement(By.cssSelector("button[class='btn btn-primary']:nth-of-type(5)"));
        WebElement dontclick = driver.findElement(By.cssSelector("#disappearing_button"));


     //   home.click();
      //  driver.navigate().back();
      //  BrowserUtils.wait(2);
        btn1.click();
        BrowserUtils.wait(2);
        btn2.click();
        BrowserUtils.wait(2);
        btn3.click();
        BrowserUtils.wait(2);
        btn4.click();
        BrowserUtils.wait(2);
        btn5.click();
        BrowserUtils.wait(2);
        dontclick.click();
        BrowserUtils.wait(2);
        driver.quit();


    }
}
