package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
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
                // it other version implict wait wait 10 second
                pollingEvery(Duration.ofSeconds(5)).
                 // keep checking 3 seconds
                ignoring(NoSuchElementException.class).
                ignoring(ElementClickInterceptedException.class);

        WebElement submitBtn = wait.until(driver->driver.findElement(By.cssSelector("button[type='submit']")));
       /* WebElement submitBtn = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.cssSelector("button[text()='Submit']"));
            }
        });*/
        // apply method is overridden from Function IF
        // and we basically finding elemnt

         driver.findElement(By.name("username")).sendKeys("tomsmith");
         driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

            submitBtn.click();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
