package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

// this more advanced Driver utility
// THIS IS SINGLENTON DRIVER
// ANY SPOT ON PROJECT WILL  USE THIS DRIVER
public class Driver {
    // whenever we call the DriverFactory it gives the new driver object
    // whenever we call it we getting every time new driver (creating new driver object)
    // now we will implement one driver object for everyone who calls this class

    // same for everyone
    private static WebDriver driver ;

    // no one can create object of driver class
    // everyone should  u  se  static getter method instead
    private Driver(){
    }

    public static WebDriver getDriver(){
        // how do we make sure web driver created once at the beginning
        // if webDriver object doesn't exists
        if(driver==null){
            // specify browser type in configuration.properties file
            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().version("79").setup();
                    // this is alternative way how we can force our driver to maximized
                    // alternative for Driver.getrdriver.manage.window.maximize ;
                    // time can be saved
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    break ;
                case "chromeHeadless":
                    // to run Chrome without interface (headless mode)
                    // headles is faster than regular browser
                    // it does not spend time to dowloand html code (interface)
                    WebDriverManager.chromedriver().version("79").setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break ;
                default:
                    throw new RuntimeException("Wrong browser name!");
            }
        }
        return driver ;
    }
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
