package com.automation.tests.WarpUp;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayAmazonWikipediaSearchTests {

   static WebDriver driver;


    public static void main(String[] args) throws Exception {

   //  ebayTest();
   //amazonTest();
        wikiTest();


    }


    public static void ebayTest() throws Exception{

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");

        driver.findElement(By.name("_nkw")).sendKeys("Macbook");
        Thread.sleep(2000);
        driver.findElement(By.id("gh-btn")).click();

        String result = driver.findElement(By.tagName("h1")).getText();
        WebElement saerchresults = driver.findElement(By.tagName("h1"));
        System.out.println(result);
        System.out.println(saerchresults.getText().split(" ")[0]);
        // splitted by space and get the first text


        BrowserUtils.wait(2);
        driver.quit();

    }

    public  static  void amazonTest() throws  Exception{

        driver = DriverFactory.createADriver("chrome");
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);

        // to verify tittle contains seacr term

        String tittle = driver.getTitle();
        if(tittle.contains("java book")){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        BrowserUtils.wait(4);
        driver.quit();




    }

    public static void wikiTest(){

        driver = DriverFactory.createADriver("Chrome");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.id("searchInput")).sendKeys("Selenium (software)", Keys.ENTER);

        String link = driver.getCurrentUrl();

        if(link.endsWith("Selenium_(software)")){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        driver.quit();
    }


    // selenium bigget problem is synchronoziont
    // selenium never wait
    // sometimes element can be delayed
    // you can get error.

    // some elements may delay because of internet
    // Thread.sleep purpose stopping exexustion
    // Expiclity wait implicity wait




}
