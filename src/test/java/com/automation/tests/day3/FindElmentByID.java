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
        // h4 -> tagname
        // class(subheader) -> className
        // getText() is


        if(expected.equals(actual)){
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }


        // lets click on loggout button it looks lile a buutton
        // but its actually a link
        // every element with <a> tag is a link..

        // if you have spaces in the text
        // just use partialLinkText instead of LinkTest..

        // liktext basically -> equals() (exact match0
        // partialLinkText is contains() (not excact match)


        WebElement logout = driver.findElement(By.linkText("Logout"));
        // We found by linkText by name on link (href);
        // it looks like button but it link
        // <a is link !!!
        // user sees underlyng text(logout button)
        // it is actually link not button !!
        // every element with <a> tag is a link

        String href = logout.getAttribute("href");

        String className = logout.getAttribute("class");

        System.out.println(href);
        System.out.println(className);
        logout.click();


        Thread.sleep(2000);

        // We back to log in page again
        // Let's do negative testing
        // put invalid essentiaals

        driver.findElement(By.name("username")).sendKeys("wrong input");
        driver.findElement(By.name("password")).sendKeys("wrong input");
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(3000);

        // lets try to read error message
        WebElement errorMessage = driver.findElement(By.id("flash-messages"));
        // this is id locator
        // be careful while finding elements by their name
        // you might get an No such element exception

        System.out.println("errorMessage.getText() = " + errorMessage.getText());


        Thread.sleep(2000);
        driver.quit();
    }
}
// SUMMARAY OF TODAY CLASS
/* Webelement is any Html element on the page for Selenium
* id ClassName tagName, Name, linkText, PartialLinkedText, Xpath, CSS
*Locators -> the best locator is and ID.
*
*sendKeys("text) is used to enter the text
* getText() is used to read the text
* getAttribute("attribute_name") is used to read some attribute
*
* What if your locator is wrong ???
* you will get nosuchElement exception
* submit() is used for buttons that hava a type ="submit"
* it used for alternative of click() method
* if click() method does not work we can use submit()
* */

//-> to enter the text -> We use senKeys("text")
//-> to read the text -> We use element.gettext();
//-> to read some attribute, We use ,getAttribute("attirbute name")
// NO SUCHELEMENT EXCEPTION OCCURS WHEN LOCATORS IS WRONG
