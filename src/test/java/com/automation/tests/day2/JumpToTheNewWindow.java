package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {


    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);


        //every window has some id, this id calls window handle
        // based on window handle, we can switch in between windows
        String windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);
        // result is window Id it represent particular window

        Set <String> windowHandles = driver.getWindowHandles();
        // THIS IS HOW WE GET ALL ID
        // returns id's of all currently opened windows
        // set doesnt allow duplicate.
        System.out.println(windowHandles);
        // // IT WILL PRINT ALL  IDS CURRENTLY OPENED WIDOWS


        System.out.println("Before switch : " +driver.getCurrentUrl());
        // since we have all windows and
        // we know id of original window
        // we can say to somethings that is not equals to old

        // how to
        for (String windowId : windowHandles){
            // if it is not an old window then swicth
            if(!windowId.equals(windowHandle)){
                // this method to jump tp new window
                driver.switchTo().window(windowId);
                // we switched to windows
            }
        }
        System.out.println("After switch : " +driver.getCurrentUrl());

        driver.quit();

        switchToWindowBasedOnTittle("practice",driver);

                // selenium consider everyting in page is as a element
                // find element by locators.


    }
    // this method helps to switch in between windows based on page tittle
    public static  void switchToWindowBasedOnTittle(String pageTittle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for(String window : windows){
            driver.switchTo().window(window);
            if(driver.getTitle().equals(pageTittle)){
                break;
            }
        }
    }
}
// SUMMARRY
// LEARNED HOW TO SWITCH BETWEEN WINDOWS (while you have more than one window with one url)
// CREATED LOGIC (METHOD)  if first window ids not equal other one id’s (always unique ids)
// Driver.switchto.window(windowed)
