package com.automation.tests.day5;

import com.automation.utilities.BrowserUtilites;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrame {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/nested_frames");
        BrowserUtilites.wait(2);

        driver.switchTo().frame("frame-top");
        // we got the top frame first
        driver.switchTo().frame("frame-middle");
        // we can find frames by either ID or NAME...

        WebElement content = driver.findElement(By.id("content"));
        System.out.println(content.getText());
        // it is content inside a child frame
        // body has content i just got text from this text.

        driver.switchTo().parentFrame(); // go to the top frame

        driver.switchTo().frame("frame-right");
        BrowserUtilites.wait(2);
        // switch to the bottom frame aftr go back to parentFrame


        // how to get content of right frame
        // since there is no id or name
        WebElement body = driver.findElement(By.tagName("body"));
        System.out.println(body.getText());


        // to go to buttom frame. i need to switch to the defaul content
        // because top frame is sibling for buttom
        driver.switchTo().defaultContent();


        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());


        driver.quit();


    }
}
// NESTED FRAME divide pages into couple frames
// it is like russian doll
/*      NESTED FRAME
* driver.switchTo().frame (id or name)
* driver.swithcTo. defaultContent ; to exit from the frame
* driver.switchTo. parentFrame ;to go back to Top frame in nested frames
*
*
*
*
*
* */