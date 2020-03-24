package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UnderstandingJavaScriptExecuter {

    @Test(description = "Send text to search box on etsy")
    public void test1() {
        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("https://www.etsy.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // polymorphisim..... tell the inteviers i was using poly here mandotory

        js.executeScript("document.getElementById('global-enhancements-search-query').value='java'");
        // we can put the element path here ( what we got from console)
    }

}
