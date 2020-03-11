package com.automation.tests.day6;

import com.automation.utilities.BrowserUtilites;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;

import java.util.List;

public class NoSelectDropdown {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtilites.wait(2);
        driver.findElement(By.id("dropdownMenuLink")).click();
        BrowserUtilites.wait(2);

        // linkText is link (href) attribut
        //INTERVIEW QUESTION
        // There are 2 types of drop-downs ;
        // dropdown select and other
        // To handle select drop-downs use Select class from Selenium
        // in case of any other dropdown just click on wait until options become visible and clikc on the option
        // HOW TO DETERMINE WHICH OPTION IS DROP DOWN AND WHICH IS NOT ?
        // just llok at the tag name , if it is select than dropdown type is select


        // we need something comman to et all of them
        // the have same class name(dropdown item)
        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        for (WebElement link: allLinks){
            System.out.println(link.getText()+" : " +link.getAttribute("href"));
        }


        driver.findElement(By.linkText("Etsy")).click();
        BrowserUtilites.wait(2);


        BrowserUtilites.wait(3);
        driver.quit();
    }
}
