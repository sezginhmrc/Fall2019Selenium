package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    // we will create a static method in order to call webdriver right away
    // that will give us webdriver object
    // return type Webdriver..
    // if you want to use chrome browser just provide chrome as a parameter

    public  static WebDriver createADriver(String browserName){

        if(browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    }
}