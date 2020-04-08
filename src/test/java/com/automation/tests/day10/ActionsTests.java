package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class ActionsTests {

    private WebDriver driver;
    private Actions actions ;


    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createADriver("chrome");
        driver.manage().window().maximize();
        actions = new Actions(driver);


    }

    @Test
    public void hoverOnImage() {
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);

        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        // paranthesis means elements itslef, not child
        // surroundedd element with paranthesis aand index
        // it will show you specific one
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));


        actions.moveToElement(img1).
                pause(1000).moveToElement(img2).
                pause(1000).moveToElement(img3).
                build().perform();
        //build() is needed when you couple of actions
        // always end with perform
        // perfom is what do yo do with action
        // pause(1000) like Thread.sleep(1000)

        // so far we clicked all image and texted are displayed
        // lets verify displayed texts
        // "name; user1' is displayed..

        actions.moveToElement(img1).perform();
        WebElement imgTxt1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        Assert.assertTrue(imgTxt1.isDisplayed());

        System.out.println(imgTxt1.getText());


        //move to second image and verify text is dispayed
        actions.moveToElement(img2).perform();
        WebElement imgTxt2 = driver.findElement(By.xpath("//*[text()='name: user2']"));
        Assert.assertTrue(imgTxt2.isDisplayed());
    }

    // Another test on different practice link
    // hover on "enabled"
    // hover on 'dowloand'
    // click on pdf

    @Test(description = "jqueryMenuTest")
    public void jqueryMenuTest() {

        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        BrowserUtils.wait(4);

        WebElement enabled = driver.findElement(By.xpath("//ul[@id='menu']/*[2]"));
        WebElement downloads = driver.findElement(By.cssSelector("a[id='ui-id-4']"));
        WebElement pdf = driver.findElement(By.cssSelector("a[id='ui-id-5']"));

        BrowserUtils.wait(5);

        actions.moveToElement(enabled).pause(1000).moveToElement(downloads).pause(1000).click(pdf).build().perform();

        // We found elements by their xml and used action method -> moveToelement
        // added some wait -> pause
        // Actions class build method allows us to take more actions like above
        // and clicked on Pdf since we didnt moveto Pdf it is already visible

    }

    // ANOTHER TEST ON DRAG AND DROP
    @Test
    public void dragandDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        BrowserUtils.wait(5);

        driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();
        // to accep cookie
        BrowserUtils.wait(4);

        //WebElement cookies = driver.findElement(By.id("alert-box-message"));
        //driver.switchTo().alert().accept();
        WebElement earth  =driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));

        actions.dragAndDrop(moon,earth).pause(1000).perform();

        String expected ="You did great!";
        String actual = earth.getText();

        Assert.assertEquals(actual,expected);
    }



    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}

// bad thing is in my current project
// We have couple teams and i had to switch another team
// i had to create test cases on something that i dont know at all
// manual testing is not cool
// stackoverflow is my best frined
