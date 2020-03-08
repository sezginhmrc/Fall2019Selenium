package com.automation.tests.day6;

import com.automation.utilities.BrowserUtilites;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtilites.wait(2);

        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        BrowserUtilites.wait(2);

        Select select = new Select(simpleDropdown);
        // We created select object.
        // we pass webElemet as a parameter
        // select option 2
        select.selectByVisibleText("Option 2");
        BrowserUtilites.wait(2);
        select.selectByVisibleText("Option 1");
        BrowserUtilites.wait(2);

        // if i need to find another dropdown i need to create another select object

        //SELECT your DOB
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));


        // SelectByVisibleText
        selectYear.selectByVisibleText("1994");
        selectMonth.selectByVisibleText("February");
        // once we select month day goes 1 ? bug !!!
        selectDay.selectByVisibleText("2");

      //  selectMonth.selectByVisibleText("1");
      //  BrowserUtilites.wait(2);
        // this will thorow noSuchElementException since month visible is text not number.

        //SelectByValue
        selectYear.selectByValue("1994");
        selectMonth.selectByValue("1");
        // value is number for month
        selectDay.selectByValue("2");


        // LETS SELECT ALL MONHS ONE BY ONE
        // getOptions - retuns all options from dropdowns as List<WebElemet>

        List<WebElement> months = selectMonth.getOptions();
        for (WebElement month : months){
            //get the month name and select based on that
            String monthName = month.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtilites.wait(2);
        }




        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("Connecticut");

        // how we can verify that selected option is correct ?

        String selected = stateSelect.getFirstSelectedOption().getText();
        // getFirstSelectedOption() - this appears option that currently opened
        // so we selec the CT in above
        // getFirstSelectedOption() - returns a webelement, thats why we need to call getText()

        if(selected.equals("Connecticut")){
            System.out.println("PASSED");
        } else {
            System.out.println("FAIL");
        }

        // lets print out all states

        List <WebElement> states = stateSelect.getOptions();

        for(WebElement statesOption : states){
            System.out.println(statesOption.getText());
        }


        BrowserUtilites.wait(1);
        driver.quit();







    }
}
