package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class MyFirstSeleniumScript
{
    public static void main(String[] args) {
       // setup chromeDriver
        WebDriverManager.chromedriver().setup();
        //create chromeDriver object

        ChromeDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        // copy the url
        // created driver chrome object


    }
}
