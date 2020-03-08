package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementPractice
{
    public static void main(String[] args ) throws  Exception
    {
        // will write a method that will give us webdriver itself in utilities package DriverFactory
        // this is old approach
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();

        // THIS IS NEW APPROACH
        // one line of code instead of 2
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        // in order to find element we use locator
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mister Twister");

        Thread.sleep(3000);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("sdet@cybertek.com");

        WebElement signUp = driver.findElement(By.name("wooden_spoon"));
        signUp.click();

        // when you see type="submit" you can see submit() instead of click()


        String expected = "Thank you for signing up. Click the button below to return to the home page." ;

        WebElement message = driver.findElement(By.className("subheader"));

        String actual = message.getText();

        if(expected.equals(actual)){
            System.out.println("Test passed");
        } else {
            System.out.println("TEST FAILED");
        }

        //<h3 class is by.TagName
        // name is by.Name signup_message
        Thread.sleep(3000);
        driver.quit(); // to close everything

    }
}
