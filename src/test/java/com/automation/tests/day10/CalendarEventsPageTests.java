package com.automation.tests.day10;

import com.automation.utilities.BrowserUtilites;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class CalendarEventsPageTests {


    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private WebDriver driver;
    private Actions actions;

    private String storeManagerUserName = "storemanager85";
    private String storeManagerPassword = "UserUser123";
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By createCalendarEventBtnBy = By.cssSelector("a[title='Create Calendar event']");

    private By currentUserBy = By.cssSelector("#user-menu > a");
    private By ownerBy = By.className("select2-chosen");
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");

    private By startdateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By starttimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");


    @BeforeMethod
    public void setup() {

        driver = DriverFactory.createADriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        actions = new Actions(driver);
        BrowserUtilites.wait(3);

        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
        BrowserUtilites.wait(4);

        //hover over Activities
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtilites.wait(3);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtilites.wait(3);
    }

    @Test
    public void verifyCreateButton() {
        WebElement createCalendarEventBtn = driver.findElement(createCalendarEventBtnBy);
        Assert.assertTrue(createCalendarEventBtn.isDisplayed());
    }


    //Test Case: Default options
    //Login as sales manager
    //Go to Activities --> Calendar Events
    //Click on Create Calendar Event
    //Default owner name should be current user
    //Default title should be blank
    //Default start date should be current date
    //Default start time should be current time

    @Test(description = "Default options")
    public void verifyDefaultValues(){
        // click on create calendar event
        driver.findElement(createCalendarEventBtnBy).click();
        BrowserUtilites.wait(4);

        String currentUsername = driver.findElement(currentUserBy).getText().trim();
        //Default owner name should be current user
        String defaultOwnerName = driver.findElement(ownerBy).getText().trim();

        Assert.assertEquals(currentUsername,defaultOwnerName);

        //Default title should be blank
        WebElement titleElement = driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());


        //Default start date should be current date
        // this is actual date  on element
        String actualDate = driver.findElement(startdateBy).getAttribute("value");
        // how we get current date
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyy"));

        Assert.assertEquals(actualDate,expectedDate);

        String expectedTime = LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime = driver.findElement(starttimeBy).getAttribute("value");

        Assert.assertEquals(actualTime,expectedTime);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}


