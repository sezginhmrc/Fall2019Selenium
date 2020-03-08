package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class MyFirstSeleniumScript
{
    public static void main(String[] args) {

        // to run tests on the Chrome

        WebDriverManager.firefoxdriver().setup();

        // We need to create Chrome Object using ChromeDriver
        FirefoxDriver driver = new FirefoxDriver();

        driver.get("http://google.com");
        // copy the url
        // created driver chrome object
        // every webbrowser has its own driver



    }
}
