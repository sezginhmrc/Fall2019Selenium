package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForiFrame {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(3);

        // before loooking for that element we need to jump to frame
        // you can specify ; name, id, index or webelement of the frame
        // its like we are jumping to another layer
        driver.switchTo().frame("mce_0_ifr");
        // Another Html doucument that is not visible to Selenium
        // until you switch, Think about this as a another layer of HTML document

        // now this content will be visible
       WebElement textInput =  driver.findElement(By.id("tinymce"));
       // we found that element by id
        System.out.println(textInput.getText());

        BrowserUtils.wait(2);

        textInput.clear();
        // we deleted the text from content

        textInput.sendKeys("Hello, World!");
        // typed some words
        BrowserUtils.wait(2);
        System.out.println(textInput.getText());
        // got the text


        driver.switchTo().defaultContent();
        // switched to default in order to get text outside of frame


        WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println("heading.getText() = " + heading.getText());
        driver.quit();


    }
}
// SUMMARY
//LEARNED HOW TO SWITCH FRAME AND FIND ELEMENT IN FRAME
// AND THEN WE NEED TO TURN BACK TO DEFAULT CONTENT
// METHODS LEARNED -> driver.swithTo().frame ("id")
// -> driver.switchTo().defaultContent

// iFrame
// Html document inside a frame
// element that receives text input
// mostly used for ads
// google setIframe ads