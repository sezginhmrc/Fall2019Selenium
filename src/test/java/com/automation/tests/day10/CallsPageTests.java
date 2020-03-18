package com.automation.tests.day10;

import com.automation.utilities.BrowserUtilites;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class CallsPageTests {
    // which model will i automate ?

 //Scenario: Verify for store manager
//        //Login as story manager
//        //Go to Activities --> Calls
//        //Verify that Log Call button is displayed

    // second task
    //Go to Activities --> Calendar Events
    //Verify that Create Calendar Event button is displayed



    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private String storeManagerUsername = "storemanager85";
    private String storeManagerPassword = "UserUser123";

    private WebDriver driver ;
    private Actions actions ;

    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");

    private By logCallBtnBy = By.cssSelector("a[title='Log call']");
    // for call locator


    @BeforeMethod
    public void setup(){

    driver = DriverFactory.createADriver("chrome");
    driver.get("https://qa2.vytrack.com/user/login");
    driver.manage().window().maximize();

    BrowserUtilites.wait(3);
    actions = new Actions(driver);


    driver.findElement(usernameBy).sendKeys(storeManagerUsername);
    driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
    BrowserUtilites.wait(3);

    //hover over actieives
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtilites.wait(3);
        driver.findElement(By.linkText("Calls")).click();
        BrowserUtilites.wait(4);

    }


    @Test
    public void verifyLogButton(){

        WebElement logCallBtnElement = driver.findElement(logCallBtnBy);

        Assert.assertTrue(logCallBtnElement.isDisplayed());
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }










       }

