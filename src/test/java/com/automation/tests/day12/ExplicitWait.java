package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait {
    private WebDriver driver ;

@BeforeMethod
    public void setup() {
    driver = DriverFactory.createADriver("chrome");

}
    @Test
            public void waitForTitle(){
        driver.get("https://www.google.com/");
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.titleContains("Google"));
        // expected condition failed
        // driver tried to check if title contains Amazon in 10 seconds
        // it didnt match and threw the TimeOutException
        // titles is not Amazon on Aamazon

        // ExpectedCondition has several condistions
        // we can create webdriverwait object once
        // and we can use it multiple time with condiitions

        driver.navigate().to("https://amazon.com");
        wait.until(ExpectedConditions.titleIs("Amazon"));
        // since title is not amazon it tried 5 seconds and thres timeoutexception

    }

    @Test
    public void waitForVisibility(){
    driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.findElement(By.tagName("button")).click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));

        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("tomsmith");
        // if username element display if it displayed it will move forward
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("SuperSecretPassword");
        wait.until(ExpectedConditions.visibilityOf(submit));

        wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
        // it waits if submit element clickalbe


        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();

        Assert.assertEquals(actual, expected);


    }

    @Test
    public void elementToBeClickableTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");

        WebDriverWait wait = new WebDriverWait(driver,10);

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));


         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));
         // okay this is the focus of this class
        // we check if is there an element before our elemenets
        // we put this condiiton here it handles this element
        //  it is overlay loading
        // it waits for that element is invisibile otherwise we are not able to move forward.
        // it would throw ElementClickInterceptedException

        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));


        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");
        submitBtn.click();

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();

        Assert.assertEquals(actual,expected);

        // ElementClickInterceptedException is means that something else was clicked instead of your element

    }

    @AfterMethod
    public void teardown(){
    driver.quit();
    }
}

