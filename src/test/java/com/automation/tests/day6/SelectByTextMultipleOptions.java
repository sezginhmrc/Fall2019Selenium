package com.automation.tests.day6;

import java.util.Date;

import com.automation.utilities.BrowserUtilites;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {

    public static void main(String[] args) {



        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtilites.wait(2);
        // WE WENT DROPDOWN PRACTICE


        Select selectByLanguage = new Select(driver.findElement(By.name("Languages")));
        // WE CREATEAD SELECT OPTION AND WE WENT SELECT MULTIPLE OPTION
        // BY.NAME (LANGAUGES)
        // SINCE THERE IS NO ID FOR SELECT OPTION WE WENT THROUH NAME

        boolean isMultiple = selectByLanguage.isMultiple();
        System.out.println(isMultiple);
        // returns if this select element has nultiple options at the same time
        // it is checking multiple attribute


        selectByLanguage.selectByVisibleText("Java");
        // AND WE SELECTED THE JAVA OPTION BY VISIBLE TEXT
        selectByLanguage.selectByVisibleText("JavaScript");
        // WE ALSO SELECTED JAVASCRIPT SINCE IT IS ALLOWS MUTLIPLE OTPIONS

        // We would also select by value like below....
        // selectByLanguage.selectByValue("ruby");
        // selectByLanguage.selectByValue("c");
        // selectByLanguage.selectByValue("java");



        // WE GET ALL SELECTED OPTIONS LIKE BELOW
        List<WebElement> selecTedLanguages = selectByLanguage.getAllSelectedOptions();

        for(WebElement selectedOnes : selecTedLanguages){
            System.out.println(selectedOnes.getText());
        }
        BrowserUtilites.wait(2);

        /// THIS IS HOW TO DESELECTED BACK THE SELECTED OPTION.
        selectByLanguage.deselectByVisibleText("JavaScript");

        // TESTING
        String selected = selectByLanguage.getFirstSelectedOption().getText();
        if(selected.equals("Java")){
            System.out.println("PASSED");
        } else {
            System.out.println("FAIL");
        }


        BrowserUtilites.wait(2);
        driver.quit();
    }
}
