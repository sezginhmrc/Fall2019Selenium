package com.automation.tests.VyTack.Fleet;

import com.automation.pages.LoginPage;
import com.automation.pages.fleet.VehiclesPageBase;
import com.automation.tests.VyTack.AbstractTestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdvancedVehiclesTests extends AbstractTestBase {

    // THIS IS WELL ORGANIZED TEST.
    // POM implemented successfully .

    @Test
    public void verifyTitle(){

        LoginPage loginPage = new LoginPage();
        // first we logged in .
        loginPage.login();

        VehiclesPageBase vehiclesPage = new VehiclesPageBase();
        // we created vehicles page object to use naviagate to vehicles module

        vehiclesPage.navigateTo("Fleet","Vehicles");
    //    vehiclesPage.navigateTo("Activities","Calendar Events");

        String expectedTitle =  "All - Car - Entities - System - Car - Entities - System";

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);




    }
}
