package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsTest {



    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");

        Thread.sleep(3000);



        // how to find links and store them as a list on website of practice cybertekSchool


        List<WebElement> links  = driver.findElements(By.tagName("a"));
        ////HOW TO COLLECT ALL LINKS FROM THE PAGE
        // WE USED findElements ---> with 's' at the end
        // <a is defined as a link and is common for all websites

        // List -> findElements
        // WebElemet ->findElement


        for(WebElement link : links){
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
            // we get text and attribute for the links
            // we created for each logic to print all links


        }

        // lets try to open every single link and cgo back

        for (int i = 1; i <links.size() ; i++) {
            links.get(i).click();
            // clicked the link

            driver.navigate().back();


            //REFRESH LIST
            // PAGES UPDATED
            links = driver.findElements(By.tagName("a"));
            // WHENEVER YOU  REFREHS OR NAVIAGATE SOMEWHERE
            // THAT LIST BECAMOS OUT DATED
            //  LOCATORS EVEN CORRET EVERY ELEMENT SOME ID
            // EVERYTIME WE NAVIAGTE BACK WE NEED FIND ELEMENTS AGAIN AND AGAIN

        }

         // selenium is autmation toool .
        // selenium is makes testers life easier
        driver.quit();


    }

}
// WHEN DO I HAVE TO USE FOR LOOP AND FOR EACH LOOP ?

// FOR EACH LOOP -> WE CAN USE FOR COLLECTIONS
// AND DONT CARE ABOUT ORDER AND WHEN YOU STOP WHEN YOU START

// FOR LOOP WE CAN START REVERSE ORDER ALSO FROM MIDDLE
// CARE ABOUT INDEX