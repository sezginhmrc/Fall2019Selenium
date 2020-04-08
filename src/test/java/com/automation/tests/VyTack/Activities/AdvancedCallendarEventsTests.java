package com.automation.tests.VyTack.Activities;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalenderEventsPage;
import com.automation.tests.VyTack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AdvancedCallendarEventsTests extends AbstractTestBase {

    // AbstractTestBase is what we want in the beginning
    // every essential part to be able to create test cases based on AbstractTestBase
    // setup environment, driver, close driver


    /*//Test Case: Default options
    //Login as sales manager
    //Go to Activities --> Calendar Events
    //Click on Create Calendar Event
    //Default owner name should be current user*/

    LoginPage loginPage = new LoginPage();
    CalenderEventsPage calenderEventsPage = new CalenderEventsPage();


    @Test
    public void defaultOptionsTests() {

        test = report.createTest("Verify default login options");

        LoginPage loginPage = new LoginPage();
        CalenderEventsPage calenderEventsPage = new CalenderEventsPage();

        loginPage.login();
        calenderEventsPage.navigateTo("Activities", "Calendar Events");
        calenderEventsPage.clickToCreateCalendarEvent();

        Assert.assertEquals(calenderEventsPage.getCurrentUserName().trim(), calenderEventsPage.getOwnerName().trim());

        Assert.assertTrue(calenderEventsPage.getTitleContent().isEmpty());

        Assert.assertEquals(calenderEventsPage.getStartDate(), DateTimeUtilities.getCurrentDate("MMM d, yyyy"));

        test.pass("Default options verified");
    }


    ///**
    // * 15 minutes until 3:45
    // * Test Case: Time difference
    // * Login as sales manager
    // * Go to Activities --> Calendar Events
    // * Click on Create Calendar Event
    // * Verify that difference between start and end time is 1 hour
    // **/
    @Test
    public void defaultOptionsTest1() {

        test = report.createTest("Verify time difference");

        LoginPage loginPage = new LoginPage();
        CalenderEventsPage calenderEventsPage = new CalenderEventsPage();

        loginPage.login();
        calenderEventsPage.navigateTo("Activities", "Calendar Events");
        calenderEventsPage.clickToCreateCalendarEvent();
        String startTime = calenderEventsPage.getStartTime();
        String endTime = calenderEventsPage.getEndTime();
        System.out.println(endTime);
        String format = "h:mm a";
        long actualDifferent = DateTimeUtilities.getTimeDifference(startTime, endTime, format);
        Assert.assertEquals(actualDifferent, 1, "Time difference is not correct");
    }

    @Test

    public void verifyColumnNames() {

        test = report.createTest("Verifying Column Names ");

        LoginPage loginPage = new LoginPage();
        CalenderEventsPage calenderEventsPage = new CalenderEventsPage();

        loginPage.login();
        calenderEventsPage.navigateTo("Activities", "Calendar Events");
        BrowserUtils.waitForPageToLoad(15);

        List<String> expected = Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");
        Assert.assertEquals(calenderEventsPage.getColumnNames(), expected);
        // so as you can see no element no wait in test
        // we try to follow this approact  to maintable test scripts
        // all about wait issues learn wait topic very well..
        test.pass("Column names were verified");

    }

    @Test(dataProvider = "calendarEvents")
    public void createCalendarEvenTest(String title, String description) {
        // this is extent report feature not TESTNG !!!
        LoginPage loginPage = new LoginPage();
        CalenderEventsPage calenderEventsPage = new CalenderEventsPage();
        test = report.createTest("Create calendar event" +title);
        loginPage.login();
        calenderEventsPage.navigateTo("Activities", "Calendar Events");
        calenderEventsPage.clickToCreateCalendarEvent();
        calenderEventsPage.enterTitle(title);
        calenderEventsPage.enterADescription(description);
        calenderEventsPage.clickOnSaveAndClose();

        Assert.assertEquals(calenderEventsPage.getGeneralInfoTitleText(), title);
        Assert.assertEquals(calenderEventsPage.getGeneralInfoDescriptionText(), description);


        test.pass("Calender event was created succesfully!");
        // for extend report only executes if test passes.

    }

    @DataProvider
    public Object[][] calendarEvents() {
        return new Object[][]{
                {"Daily stand-up", "Scrum meeting to provide updates"},
                {"Sprint planning", "Scrumm meeting where team discussing o userstories "},
                {"Sprin Review", "meeting where team discuss prevois sprint"},
                // this data is here hard coded, it can be read by excel file
        };
    }


}

