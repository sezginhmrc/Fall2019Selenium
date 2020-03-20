package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class xPath {

    // this is organized program
    static String userNameLocator = "//label[text()='Username']/following-sibling::input";
    //  this is regular way - > //input[@type='text']
    // input and label sibings we get the input by using label folowing sibling
    // sometimes we cant find locator in input maybe there is not enoguht information
    // in terms of not enoguht information in node we can use other element through sibling to find locator
    static String passwordLocator = "//label[text()='Password']/following-sibling::input";
   //  this regular xpath way -> //input[@type='password']
    static String loginLocator = "//button[contains(text(),'Log')]";
    // this regular xpath way -> //button[text()='Login']
    // this is also works -> // button
    // since there is only one button on document
    // you can check if the elements is unique by 1 of 1 on the rigt..

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(2);

        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath(loginLocator)).click();
        BrowserUtils.wait(2);
        driver.quit();












    }
}
