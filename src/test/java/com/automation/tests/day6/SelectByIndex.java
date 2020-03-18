package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {

    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        Select stateSelect = new Select(driver.findElement(By.id("state")));

        // index start from 0
        stateSelect.selectByIndex(5);
        // should select at 5th index
        System.out.println("stateSelect.getFirstSelectedOption().getText() = " + stateSelect.getFirstSelectedOption().getText());
        System.out.println("stateSelect.getFirstSelectedOption().getAttribute(\"value\") = " + stateSelect.getFirstSelectedOption().getAttribute("value"));



        // selecting last option
        stateSelect.selectByIndex(stateSelect.getOptions().size()-1);



        BrowserUtils.wait(2);
        driver.quit();



    }
}
