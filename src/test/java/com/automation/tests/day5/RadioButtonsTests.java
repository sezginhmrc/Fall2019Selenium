package com.automation.tests.day5;

import com.automation.utilities.BrowserUtilites;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTests {

    public static void main(String[] args) {

        // how to test particular button isEnabled and isSelected ?

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtilites.wait(2);

        WebElement blackButton =  driver.findElement(By.id("black"));
        // be aware findElement not with the 's'

        if(blackButton.isDisplayed() && blackButton.isEnabled()){
            blackButton.click();
        }

        System.out.println("button.getAttribute(\"id\") = " + blackButton.getAttribute("id"));

        //How to verify that button is eligible to be clicked
        // returns true if button clicked
        if(blackButton.isSelected()){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        System.out.println(blackButton.isEnabled());
        System.out.println(blackButton.isSelected());





        BrowserUtilites.wait(2);



        // will check disable button

        WebElement greenButton = driver.findElement(By.id("green"));

        if(greenButton.isDisplayed() & greenButton.isEnabled()){
            greenButton.click();
        }
        // since greenbutton is not visible
        // it is not isDisplayed

        System.out.println("greenButton.getAttribute(\"id\") = " + greenButton.getAttribute("id"));
        System.out.println("greenButton.isDisplayed() = " + greenButton.isDisplayed());
        System.out.println("greenButton.isEnabled() = " + greenButton.isEnabled());
        System.out.println("greenButton.isSelected() = " + greenButton.isSelected());





        BrowserUtilites.wait(2);
        driver.quit();

    }
}
