package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UnderstandingJavaScriptExecuter {

    @Test(description = "Send text to search box on etsy")

    public void test1() {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.etsy.com/");


        JavascriptExecutor js = (JavascriptExecutor) driver;
        // polymorphisim..... tell the inteviers i was using poly here mandotory

        String pagetitle = js.executeScript("return document.title").toString();

        System.out.println(pagetitle);

        js.executeScript("document.getElementById('global-enhancements-search-query').value='java'");
        // we can put the element path here ( what we got from console)

    }
    @Test
    public void test2(){
        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("https://www.etsy.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver ;
        // casting poly..

        js.executeAsyncScript("document.getElementById('catnav-primary-link-891').click();");
        // this AsyncScripts litt bit faster than regular one


    }
    @Test
    public void test3(){

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String pageUrl = js.executeScript("return document.URL").toString();

        System.out.println(pageUrl);
    }

    @Test
    public void test4(){

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript("return document.getElementById('catnav-primary-link-891').innerHTML");

    }

}
