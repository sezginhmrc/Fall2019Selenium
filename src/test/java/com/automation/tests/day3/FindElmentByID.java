package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElmentByID {

    public static void main(String[] args) throws Exception{

      //  WebDriver driver = DriverFactory.createADriver("chrome");
      //  driver.get("http://practice.cybertekschool.com/login");
      //  WebElement id = driver.findElement(By.id("wooden_spoon"));


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");


        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(3000);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");

        Thread.sleep(3000);
        driver.findElement(By.id("wooden_spoon")).click();


        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();

        if(expected.equals(actual)){
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        // lets click on loggout button it looks lile a buutton
        // but its actually a link
        // every element with <a> tag is a link..
        // if you have spaces in the text
        // just se partialLinkText instead of LinkTest
        // liktext basically -> equals()
        // partialLinkText is contains() not complete match

        WebElement logout = driver.findElement(By.linkText("Logout"));

        String href = logout.getAttribute("href");

        String className = logout.getAttribute("class");

        System.out.println(href);
        System.out.println(className);
        logout.click();
        Thread.sleep(2000);
        // Let's do negative testing
        // put invalid essentiaals

        driver.findElement(By.name("username")).sendKeys("wrong input");
        driver.findElement(By.name("password")).sendKeys("wrong input");
        driver.findElement(By.id("wooden_spoon")).click();



        Thread.sleep(3000);

        WebElement errorMessage = driver.findElement(By.id("flash-messages"));
        // this is By_id locator/
        // be careful while finding elements by their name
        // you might get an No such element exception

        System.out.println("errorMessage.getText() = " + errorMessage.getText());

        Thread.sleep(2000);
        driver.quit();
    }
}
// SUMMARAY OF TODAY CLASS
/* Webelement is any Html element on the page for Selenium
* name, tagName, linkText,
*Locators -> the best locator is and ID.
*sendKeys("text) is used to enter the text
* getText() is used to read the text
* getAttribute("attribute_name") is used to read some attribute
* What if your locator is wrong ???
* you will get nosuchElement exception
* submit() is used for buttons that hava a type ="submit"
* it used for alternative of click() method
* if click() method does not work we can use submit()
* */