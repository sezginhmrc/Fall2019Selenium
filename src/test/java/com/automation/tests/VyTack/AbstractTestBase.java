package com.automation.tests.VyTack;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class AbstractTestBase {

    // This class is essential Setup for every test of our project
    // Protected will be visible in the subclass, regardless on subclass location (same package or no)

    protected WebDriverWait wait;
    // for synchronization issue
    // we can use wait object and its conditions in all our test cases .
    protected Actions actions;
    // for hover over on modules
    // so we can use actions object inside all our test cases.


    protected ExtentReports report ;
    protected ExtentHtmlReporter htmlReporter;
    // these classes used for interact and create HTML report
    protected ExtentTest test ;


    //@optional is to make parameter if you dont specify testng will require to specfiy this parameter for every test, in xml runner
    @BeforeTest
    @Parameters("reportName")
    public void setupTest(@Optional String reportName){
        // This will be used to create report for once for all tests
        // Only One Html File
        // We use ExtendReports, ExtendHtmlReporter , ExtentTest object to interact report.html
        // it is here in @BeforeTest it means it will run once for all tests
        System.out.println("Report Name " +reportName);
         reportName = reportName == null ? "report.html" : reportName +".html" ;
         // if the paraemeter is null report.html
        // if parameter is providede and updated in reoprt
        // we can crete different report for differernt purposes
        // BeforeSuite is runs once for all tests
        //
    report = new ExtentReports();
    String reportPath = "";
    // location of report file
    if(System.getProperty("os.name").toLowerCase().contains("win")){
        reportPath = System.getProperty("user.dir") +"\\test-output\\" + reportName;
    } else {
        reportPath = System.getProperty("user.dir") + "/test-output/" +reportName;
        // for mac
    }
    // is a HTML report itself
        htmlReporter = new ExtentHtmlReporter(reportPath);
    // add it to the reporter
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK Test Automation Results");

    }

    @AfterTest
    public void aftertest(){
        report.flush();
        // to release a report
    }


    @BeforeMethod
    public void setup(){
        // Whenever test clases inherit this base class They will get below codes
        // it provides essential setup and cleanup for every test of our project
        // We initialize Driver, WebDriverWait, Actions, Open the Browser
        String URL = ConfigurationReader.getProperty("qa3");
        // all test cases will be open on "CHROME"
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        // All test cases will have "EXPLICIT WAIT"
        actions = new Actions(Driver.getDriver());
        // All test cases will have "ACTIONS CLASS"

    }
    @AfterMethod
    // check test result if it fails takescreen shot and
    // and attach the test name, screenshot, attach error console output into to  REPORT..
    public void teardown(ITestResult iTestResult) throws IOException {
        // itResult is interface that describes the result of a test
        // if the test fails screnshot will be taken right away
        // no failure no screenshot
        if(iTestResult.getStatus()== ITestResult.FAILURE){
            // screent shot will have a name of the test
          String screenShotPath =  BrowserUtils.getScreenshot(iTestResult.getName());
                                                              // this returns name of test

            test.fail(iTestResult.getName());
            // name of test will be shown in report Html in first line
            BrowserUtils.wait(3);
            test.addScreenCaptureFromPath(screenShotPath);
            // Screenshot only will be shown in report Html if test fails
            test.fail(iTestResult.getThrowable());
            // output will be shown in report HTML


            //ScreenSHots only will be taken if test fails
        }

        BrowserUtils.wait(3);
        Driver.closeDriver();
    }
}
