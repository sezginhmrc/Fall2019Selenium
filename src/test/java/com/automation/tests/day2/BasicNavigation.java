package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception {
        // main method is trigger in java
        // it is a entry point in java program


        // to start selenium script we need :
        // setup webdriver (browser driver) and create webdriver object

        WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.chrom.driver","chromerdriver");
        // this is another way nanually call the chromdriver


        ChromeDriver driver = new ChromeDriver();
        // in selenium everything starts from webrdiver interface

        driver.get("http://google.com");
        // first we use get method to open a website.
        driver.manage().window().maximize();
        // to maximize browser

        Thread.sleep(3000);
        // for demo, wait 3 seconds


        String tittle = driver.getTitle(); //returns <title> some title</title> text
        String expectedTittle = "Google";
        System.out.println("Tittle is " +tittle);


        if(expectedTittle.equals(tittle)){
            System.out.println("TEST PASSED!");
        } else{
            System.out.println("TEST FAILED!");
        }

        // go to another website within the same window
        driver.navigate().to("http://amazon.com");
        Thread.sleep(3000);
        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        // comeback to google
        driver.navigate().back();
        Thread.sleep(3000);
        //checking if page tittle is equals to google

        verifyEquals(driver.getTitle(),"Google");

        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        // this means it goes back to amazon


        System.out.println(driver.getTitle());

        driver.close();
        // to close to browser


    }

    public static void verifyEquals(String arg1, String arg2){

        if(arg1.equals(arg2)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }
}
