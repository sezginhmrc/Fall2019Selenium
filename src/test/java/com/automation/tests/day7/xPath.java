package com.automation.tests.day7;

import com.automation.utilities.BrowserUtilites;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class xPath {


    static String userNameLocator = "//label[text()='Username']/following-sibling::input";
    static String passwordLocator = "//label[text()='Username']/following-sibling::input";

    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtilites.wait(2);

        driver.findElement(By.xpath(userNameLocator));
        BrowserUtilites.wait(2);
        driver.quit();












    }
}
