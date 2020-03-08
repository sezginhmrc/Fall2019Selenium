package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicNavigation {


    public static void main(String[] args) throws Exception {

        // main method is trigger in any  java program
        // it is a entry point in java program


        // to start selenium script we need :
        // setup webdriver (browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.chrom.driver","chromerdriver");
        // this is another way manually call the chromdriver


        ChromeDriver driver = new ChromeDriver();
        // in selenium everything starts from webrdiver it is abstartc class
        // everything will be based on this driver object..

        driver.get("https://www.google.com/");
        // first we use get method to open a website.

        driver.manage().window().maximize();
        // to maximize browser (


        Thread.sleep(3000);
        // it will put a hold on run for 3 second



        String tittle = driver.getTitle(); //returns tittle of website

        // Expected data coming from test case.
        // We provided expected tittle.
        String expectedTittle = "Google";

        System.out.println("Tittle is " +tittle);


        // Testing google tittle expected resulted..
        if(expectedTittle.equals(tittle)){
            System.out.println("TEST PASSED!");
        } else{
            System.out.println("TEST FAILED!");
        }


        // go to another website within the same window
        driver.navigate().to("http://amazon.com");
        Thread.sleep(3000);
        if(driver.getTitle().toLowerCase().contains("amazon")){
            // get tittle is getting title of webpage
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        // come back to google
        driver.navigate().back();
        Thread.sleep(3000);
        //checking if page tittle is equals to google

        verifyEquals(driver.getTitle(),"Google");
        // TESTING THE TITTLE OF GOOGLE.

        driver.navigate().forward();
        // go back to amazon again
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        // this means it goes back to amazon

        System.out.println("URL" + driver.getCurrentUrl());
        // GetCurrentURl returns string version of url
        //  display  the url of webpage
        // shouldnt be mixed with getTittle...

        driver.navigate().refresh();
        // to reload page
        // it just refreshing the page.
        Thread.sleep(3000);

        //DIFFERERNT BETWEEN QUIT AND CLOSE ?
        // quit close all windows opened by browser
        // close closes only one window

        driver.close();
        // to close to browser


    }

    public static void verifyEquals(String arg1, String arg2){
// created logic to compare expected and actual
// static method to be called in static main
// static way ...
        if(arg1.equals(arg2)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");

        }
    }
}


// SUMMARRY

// LEARNED HOW TO CREATE WEB DRIVER OBJECT TO START SELENIUM ON DESIRED BROWSER
// LEARNED BASIC COMMANDS
// GET (URL) GET TITTLE NAVIAGATE BACK FORWARD CLOSE. JUMPT TO ANOTHER URL IN SAME WINDOW ETC.
// WE ADDED JAVA METHOD IN SELENIUM
// USING JAVA IN DEVELOPING SOLUTIONS
// WRITING CODE TO CREATE AUTOMATION SCRIPT

// DIFFERENT BETWEEN CLOSE AND QUIT ?
// QUIT CLOSE ALL WINDOWS OPENED BY BROWSER
// CLOSE CLOSE THE ONLY WINDOW

// DIFFERENCE BETWEEN getTittle and getCurrentUrl ?
// GETTTILE IS RETURNS PAGE TITTLE
// GETCURRENT URL IS RETURN STRING VERSION OF URL