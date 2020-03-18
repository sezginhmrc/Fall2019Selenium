package com.automation.tests.day5;

import com.automation.utilities.BrowserUtilites;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtilites.wait(2);

        // how to collect all checkboxes ?

        List<WebElement> allBoxes = driver.findElements(By.tagName("input"));
        allBoxes.get(0).click();
        BrowserUtilites.wait(2);

        // use all methods that been learned so far
        if(allBoxes.get(1).isDisplayed() && allBoxes.get(1).isEnabled() && (!allBoxes.get(1).isSelected())){
            allBoxes.get(1).click();
            System.out.println("allBoxes.get(1).getAttribute(\"type\") = " + allBoxes.get(1).getAttribute("type"));
        } else {
            System.out.println("FAILED TO CLICK ");
        }

        BrowserUtilites.wait(2);
        driver.quit();




    }
}
