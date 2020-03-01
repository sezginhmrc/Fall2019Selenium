package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicNavigation {

    public static void main(String[] args) {

        // to start selenium script we need :
        // setup webdriver (browser driver) and create webdriver object

        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();
        // in selenium everything starts from webrdiver interface

        driver.get("http://google.com");
        // first we use get method to open a website.

    }
}
