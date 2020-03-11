package com.automation.tests.day6;

import com.automation.utilities.BrowserUtilites;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Randomly
{
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("https://www.etsy.com/");
        BrowserUtilites.wait(2);
        WebElement element = driver.findElement(By.id("global-enhancements-search-query"));
        element.sendKeys("personalized necklace", Keys.ENTER);
        BrowserUtilites.wait(2);


        driver.navigate().to("https://www.amazon.com/");




    }
}
