package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

    public static void main(String[] args)throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // we will develop framework where we will place this code into reusable code
        // instead of writing again and agagin we will have one place
        // whenever we need driver we call the method
        // we will not repeat ourself.




        driver.get("https://www.google.com/");
        Thread.sleep(2000);

        WebElement search = driver.findElement(By.name("q"));
        // we can store elements by their name as a webelemet
        // every function on webpages are called
        //WEBELEMENT
        // Webelement represent one particular element from the page.
        // Why do we find them ?
        // to perform some actions, like : click ,enter text , read text

        // once we found an element . How to enter text ?
        // to enter text we use
        // senKeys() method

        search.sendKeys("SELENIUM HINTS", Keys.ENTER);

        // how to click enter without clicking google search on the page
        // Keys.ENTER -perfrom keyboard click

        Thread.sleep(2000);

        WebElement news = driver.findElement(By.linkText("News"));
        // if you see <a> element it calls link
        // visible text of this linkg can be used by selenium to find this element

        news.click();
        Thread.sleep(4000);



        driver.quit();
    }
}

// SUMMARYY
// FIRST WE NEED TO FIND LOCATOR MANUALLY BY LOOKING AT SOURCE CODE OF WEBPAGE
// AND WE NEED TO FIND ELEMENT
// AND STORE AS WEBELEMENT VARIABLE
// AND PERFORM THE ELEMENT
// SENKEYS (TO ENTER TEXT)
// KEYS.ENTER ( TO USE KEYBOARD CLICK)

