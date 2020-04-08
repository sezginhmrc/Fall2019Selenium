package com.automation.tests.day13;

import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverTest {

    @Test
    public void googleTest(){

        // How we get driver directly.

        // ConfigurationReader.getProperty("browser")
        //  WebDriverManager.chromedriver().version("79").setup();
        //  driver = new ChromeDriver();
        Driver.getDriver().get("http://google.com");
        Assert.assertEquals(Driver.getDriver().getTitle(),"Google");
        Driver.closeDriver();

    }
}
