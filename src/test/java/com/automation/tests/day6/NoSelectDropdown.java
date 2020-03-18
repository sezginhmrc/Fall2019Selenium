package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectDropdown {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        driver.findElement(By.id("dropdownMenuLink")).click();
        BrowserUtils.wait(2);

      //  driver.findElement(By.linkText("Google")).click();
        //BrowserUtilites.wait(3);
        //driver.navigate().back();

        // linkText is link (href) attribut
        //INTERVIEW QUESTION
        // There are 2 types of drop-downs ;
        // dropdown select and other
        // To handle select drop-downs use Select class from Selenium
        // HOW TO DETERMINE WHICH OPTION IS DROP DOWN AND WHICH IS NOT ?
        // in case of any other dropdown just click on wait until options become visible and click on the option
        // just look at the tag name , if it is select than dropdown type is select


        // how to get all options on non-select element ?
        // we need something comman to get all of them
        // the have same class name(dropdown item)
        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        for (WebElement link: allLinks){
            System.out.println(link.getText()+" : " +link.getAttribute("href"));
        }

        driver.findElement(By.linkText("Etsy")).click();
        BrowserUtils.wait(2);


        BrowserUtils.wait(3);
        driver.quit();
    }
}
