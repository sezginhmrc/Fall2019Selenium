package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementsIsGone {

    public static void main(String[] args) throws Exception {

        // how to check element is does not exist anymore in DOM (document object model) -> html code



        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);

        if(driver.findElements(By.id("disappearing_button")).size()==0){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        // since this element no more existing is size == 0 and passed
        List<WebElement>  list = driver.findElements(By.id("disaapearing_butoon"));
        if(list.size()==0){
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        Thread.sleep(2000);

        List <WebElement> button = driver.findElements(By.tagName("button"));
        for (WebElement buttons : button){
            buttons.click();
            Thread.sleep(2000);
        }

        driver.quit();

        // findElement(s) -> with s
        // since we click it it is gone no more existing
        // it size == 0 anymore


    }
}
// SUMMARY
// FindElements() ---> to find lots of element at once --> Returns List <WebElement>
// NoSuchElementException

// in case of findElements ---> you can get 0+ elements, if locator is wrong or element is gone already
// you will get empty list
// all links have <a> tag

// StaleElementReferenceException ---> Selenium cannot use webelement anymore. Element is old.