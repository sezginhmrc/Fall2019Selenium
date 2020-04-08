package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createADriver("chrome");
    }

    @Test
    public void fluentWaitTest(){

        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(10)).
                // it will check for 10 second
                pollingEvery(Duration.ofSeconds(5)).
                //keep checking to find element on page at evey 3 seconds up to 10 seconds
                ignoring(NoSuchElementException.class).
                ignoring(ElementClickInterceptedException.class);

        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));



        WebElement submitBtn = wait.until(driver->driver.findElement(By.cssSelector("button[type='submit']")));
        // this is the lambda expression version of below code

       /* WebElement submitBtn = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.cssSelector("button[text()='Submit']"));
            }
        });*/
        // apply method is overridden from Function IF
        // and we basically finding elemnet

         driver.findElement(By.name("username")).sendKeys("tomsmith");
         driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

            submitBtn.click();

            // so it didnt work on page
            // we are gonna add epxlict wait and invisiblitofelement condition in above to make it pass
           // from previous class
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
