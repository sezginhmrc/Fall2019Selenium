package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class Alerts {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(2);

        // to find all buttons
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        // TagName is same for all of them

        buttons.get(0).click();
        // once we click button alert will show up on screen
        BrowserUtils.wait(2);
        // to click on the first button

        String popupText = driver.switchTo().alert().getText();
        // to get text on pop-up message
        System.out.println(popupText);

        driver.switchTo().alert().accept();
        // to click ok on pop-up message(window)

        String expected = "You successfuly clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();
        // actual is found by id of text.

        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("EXPECTED = " +expected);
            System.out.println("ACTUAL = " +actual);
        }
        // there is a bug in result text 'successfuly'
        // it will failed -> typoo..
        BrowserUtils.wait(2);

        buttons.get(1).click();
        // to click on the second button
        BrowserUtils.wait(2);

        driver.switchTo().alert().dismiss();
        // to click cancel

        // ACCEPT AND DISMISS
        // ok and cancel

        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();

        if(expected2.equals(actual2)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("EXPECTED = " +expected2);
            System.out.println("ACTUAL = " +actual2);
        }

        // Task for 5 minutes
        // click on button 3
        // enter some text (Hello, World!)
        // verify that resul text ends with Hello, World!
        buttons.get(2).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().sendKeys("Hello, World!");
        BrowserUtils.wait(3);
        driver.switchTo().alert().accept();
        BrowserUtils.wait(2);

        String expected3 = "Hello, World!";
        String actual3 =driver.findElement(By.id("result")).getText();

        if(actual3.endsWith(expected3)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("EXPECTED = " +expected3);
            System.out.println("ACTUAL = " +actual3) ;
        }




        BrowserUtils.wait(2);
        driver.quit();


    }
}
