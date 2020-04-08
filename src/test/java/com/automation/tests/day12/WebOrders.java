package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createADriver("chrome");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
    }

    // got web orders page
    // click on ' check all' utton
    //verify taht all checkboxes are selected
    @Test
    public void checkBoxTest() {

        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        BrowserUtils.wait(2);
        List<WebElement> checkBoxes = driver.findElements(By.xpath("input[@type='checkbox']"));

        for (WebElement boxes : checkBoxes) {
            Assert.assertTrue(boxes.isSelected());
        }
    }
    // go to web orders page
    // verify that Steve Johns zip code is 21233
    // then update zip code to 2002
    // then verify tjat zip code is match as updated
   @Test
   public void verifyzipcode(){

        WebElement zipcode = driver.findElement(By.xpath("//table//tr[4]//td[9]"));
       Assert.assertEquals(zipcode.getText(),"21233");
       //verified defoult zip code


        driver.findElement(By.xpath("//table//tr[4]//td[13]")).click();
        // find edit button and clicked

        WebElement zipcodeinput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        // find zipcode input
        zipcodeinput.clear();
        // deleted current value
        zipcodeinput.sendKeys("20002");
        // enter to update

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
        // clicked update

        zipcode = driver.findElement(By.xpath("//table//tr[4]//td[9]"));
        // we find find element again since it is updated
        Assert.assertEquals(zipcode.getText(),"20002");



   }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}


