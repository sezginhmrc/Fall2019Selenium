package com.automation.tests.VyTack.Login;

import com.automation.pages.LoginPage;
import com.automation.tests.VyTack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;


import com.automation.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdvancedLoginTests extends AbstractTestBase {

    // inherited neccesary setup and teardown from TestBase

    @Test
    public void verifyPageTitle(){
        // we must add to every test at the beginning
        // it will show in reports in first line
        test = report.createTest("Verify page title");



        LoginPage loginPage = new LoginPage();
        // This is how we implement the login page object class in here out test cases
        // this more advanced version and maintanble and easy to understand
        loginPage.login();// logged in as a sales manager

        test.info("Login as store manager") ;
        // info dispalys when test passes

        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
        // if assertion passed it will set test status in report to passed
        // if assertion fails it will take screen shot and send the screenshot into file
        // WE added Test Base class our screenshot logic
        // whenever test fails it will capture screenshot right away and save it into file


        // if test  pass it will display as well
         test.pass("Page title Dashboard was verified");


    }

    @Test
    public  void verifyWarningMessage(){

        // we must add to every test at the beginning
        // it is like a title for test report.
        test = report.createTest("Verify warning mesaage");

        LoginPage login = new LoginPage();
        login.login("wrong","wrong");

        test.info("Login with wrong credentials");
        Assert.assertEquals(login.getWarningMessageText(),"Invalid user name or password.");

   //     BrowserUtils.getScreenshot("warning_message");
        // This screenshot will be taken no matter it pass or fails

        test.pass("Warning message was displayed");

    }

    @Test(dataProvider = "credentials")
    public void loginWithDDT(String userName, String password ){

        test = report.createTest("Veryify Login Page");

        LoginPage loginPage = new LoginPage();
        loginPage.login(userName,password);
        test.info("Login as a " + userName);

        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
        test.pass("Page title was verified");
        // We have one test here but it will run 3 times with Data Driven Testing
    }

    // Object [] 1 columnd with a data
    // Object [][] 2+
    @DataProvider
    public Object[][] credentials (){
        return new Object[][] {
                {"storemanager85","UserUser123"},
                {"salesmanager110","UserUser123"},
                {"user16","UserUser123"},
                // this data is here hard coded, it can be read by excel file
        };
    }


   @DataProvider
    public Object [][] credentialsFromExcel(){
        String path = "VytrackTestUsers.xlsx";
        String spreadhSheet = "QA3-short" ;
        ExcelUtil excelUtil = new ExcelUtil(path,spreadhSheet);
        return excelUtil.getDataArray();

    }


    @Test(dataProvider = "credentialsFromExcel")
     // DATA DRIVER TESTING  ! ! ! WUTH EXCEL FIL.
    public void loginTestsWithExcel (String execute, String username, String password, String firstname, String lastname,String result) {
        test = report.createTest("Login test for " + username);
        if (execute.equals("y")) {
            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password); // username password given her e
            test.info("Login as " + username); // log some steps
            test.info(String.format("First name: %s, Last name: %s, Username: %s", firstname, lastname, username));
            test.pass("Successfully logged in as " + username);
            // % is more readable
        } else {
            test.skip("Test was skipped for user: " + username);
            throw new SkipException("Tes was skipped for user: " + username);
            //skip exception you can throw when you want to skip some tests in testNG.
            // skipException not means it is failling
        }
    }
}
