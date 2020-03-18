package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(2);


        // click on button 1

        WebElement btn1 = driver.findElement(By.xpath("//*[@onclick='button1()']"));
        // copy from element -> //*[@id="content"]/div[1]/button[1]
        btn1.click();
        BrowserUtils.wait(2);

        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());


        //click on button 2

        WebElement btn2 = driver.findElement(By.xpath("//button[@name='button2']"));
        // tih is another way -> //button[text()='Button 2']
        // xPath ->  // tagname[@Select attirbute='value']
        btn2.click();
        System.out.println(result.getText());

        // click on button 3
        // Best way is text()..
        WebElement btn3 = driver.findElement(By.xpath("//button[text()='Button 5']"));
        // another way -/> button[starts-with(@id,'button_')]
        // another way -> //button[contains(@id,'button_')]
        btn3.click();
        System.out.println(result.getText());

        WebElement btn4 = driver.findElement(By.xpath("//button[contains(text(),'4')]"));
        btn4.click();
        System.out.println(result.getText());

        WebElement btn5 = driver.findElement(By.xpath("//button[contains(text(),'5')]"));
        btn5.click();
        System.out.println(result.getText());



        BrowserUtils.wait(2);
        driver.quit();



    }
}
// Absoulte xPath ;
// singe / absolute xpath one by one all locators
// this might get very long
// not very productive since it is a long way to go

// Relative xPath
// double //  relative xPath
// it works through relative locations instead of from beginning to end
// start a designated tag
// tagName [@attrbiute='value']
// <button class="btn btn-primary" onclick="button2()"
// name="button2> Button 2</button>
// //button[@name='button2']
// //button [@class='btn btn-primary']
// //button [@onclick='button2()']
// * start means skip tagName

// Dynamic Elements ? (changing)
// 1. Any tag
// tagName will be replaces with a *
// //*[@attribute='value']
// 2. Operator 'and' (&&)
// combine two different attribues to find a single element
// // tagName [@attribute= 'value' and @attribute2 ='value2']
// // tagName[@attribute='value'] [@attribute2='value2']
//  options to use end operator
// <button class="btn btn-primary" onclick="button2()"
// name="button2> Button 2</button>
// //button [@class='btn btn-primary and @onclick='button2()']

