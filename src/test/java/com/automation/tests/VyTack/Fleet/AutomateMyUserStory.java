package com.automation.tests.VyTack.Fleet;

import com.automation.pages.LoginPage;
import com.automation.pages.fleet.VehiclesPageBase;
import com.automation.tests.VyTack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AutomateMyUserStory extends AbstractTestBase {


    @Test
    public void verifyVehicleOdometersPage(){

        LoginPage  loginpage = new LoginPage();


        loginpage.login("user24","UserUser123");

        BrowserUtils.waitForPageToLoad(15);

        VehiclesPageBase page = new VehiclesPageBase();

        page.navigateTo("Fleet","Vehicle Odometer");


        // Verify that as a truck driver i should able to see odometer informations on the grid

        List<WebElement> odometer = Driver.getDriver().findElements(By.xpath("//table//tbody//tr//td[2]"));

        for(WebElement each : odometer){
            System.out.println(each.getText());
            Assert.assertTrue(each.isDisplayed());
        }

    }
}