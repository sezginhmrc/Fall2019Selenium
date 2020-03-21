package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {

    private WebDriver driver ;

    @Test
    // in test we will focus on testing part
    public void googleSearchTest(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);


        List<WebElement> listOfLinks = driver.findElements(By.tagName("h3"));

        for(WebElement each : listOfLinks){
           String var = each.getText() ;
           // if there is a text -> print it
            if(!var.isEmpty()){
                System.out.println(var);
                // verify that every search result contains java
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }
    }




    @Test (description = "search text Java Book on amazon")
    public  void amazonSearchTest(){
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        // to avoid unclickible links always make window maximize

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        BrowserUtils.wait(2);

        //find
        List <WebElement> searchIteams = driver.findElements(By.tagName("h2"));
        // h2 is cooman  tagname for all search item

        // click on the firs item
        searchIteams.get(0).click();
        BrowserUtils.wait(2);

        WebElement producTitle = driver.findElement(By.id("title"));

        String productTitleString = producTitle.getText();

        System.out.println(productTitleString);

        Assert.assertTrue(productTitleString.contains("Java"));


    }


    @BeforeMethod
    public void setup(){
        // to setup driver We used @Beforemethod annotation
        // it is like pre condtion
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void teardown(){
        // will close browser and destroy webdriver object
        driver.quit();
    }
}

// Annotations are neccesary for test.
// beforeMethod is setup driver
// Test is googlesearctest
// aftermethod is quit the driver
// they all related each other

/// Assortion what makes test a test ..

// this how we create testNg in real work
// Google Test


   /*  My day to day activities in team ?

 -When i go to work, I usually chechk the smoke test results, which is escheduled to execute early in morning
 in case of test result are failed
 I would try get deep into issue to learn if the issuse is from environment or from my script,
 or If it is a bug i would let developer know it so they can take care of it .
 - then i check my emails to make sure nothing left from yesterday
 - then i open jira board and getting ready for daily Standup meeting which takes a place every day around 1o am
 - in daily standup meeting we discuss what we did yesterday ? what we will do today ? and if there is an impediment
 - so after the meeting i go to my desk and start working on my tasks
 - My task are different depending on which part of sprint our team is
 -
   *
   *
   *
   *
   *
   *
   *
   *
   *
   *
   * */
