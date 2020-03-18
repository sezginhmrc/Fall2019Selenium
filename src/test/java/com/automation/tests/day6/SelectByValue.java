package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue {

    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        // Select object is  the selected by id
        stateSelect.selectByValue("CT");

        // add verification
        String expexted = "Connecticut" ;
        String actual = stateSelect.getFirstSelectedOption().getText();
        // getFirstSelectedOption returns webelement
        // thats why we need to call gettext method
        // most people use byVisibleText
        // how we get first selected option text which is Connecticut...


        if(expexted.equals(actual)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }



        BrowserUtils.wait(2);
        driver.quit();
    }
}
