package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecuter {

    private WebDriver driver ;



        @BeforeMethod
        public void setup(){
            driver = DriverFactory.createADriver("chrome");
            driver.get("http://practice.cybertekschool.com/");
            driver.manage().window().maximize();
        }

        @Test
        public void verifyTitle (){
            String exptexted = "Practice" ;
            // we gonna get title using JSE
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String actual = (String ) js.executeScript("return document.title");
            // ExecuteScript method execute javascript code
            // We provide actual as astring
            // return.document.title always like this

            Assert.assertEquals(actual,exptexted);

        }


        @AfterMethod
        public void teardown(){
            BrowserUtils.wait(2);
            driver.quit();
        }
}
