package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PracticeTests {

    private WebDriver driver ;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        chromeOptions.setAcceptInsecureCerts(true);
        // to ignore "Your connection is not private issue"
        // Certifaced website or not ? http : https
        // SSL certifacate
        // provice chromeOptions object into chromeDriver constructor
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(description = "login test display message")
    public void forgotPasswordTest(){

        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();


        WebElement message = driver.findElement(By.className("subheader"));
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = message.getText();

        Assert.assertEquals(actual,expected);
        // if assertion fails - it will throw exception and message will be printed
        // 3 parameters : expected ,actual , message in case of error ....

    }
// Test Scenario
    /** TASK for 5 minutes
     * Given user is on the practice landing page
     * When user navigates to "Forgot password" page
     * Then user enters his email
     * And clicks "Retrieve password" button
     * Then user verifies that message "Your e-mail's been sent!" is displayed*/
    @Test
    public void test1 (){

        driver.navigate().to("http://practice.cybertekschool.com/forgot_password");
        driver.findElement(By.name("email")).sendKeys("seze@asdas.com",Keys.ENTER);

        String actual = driver.findElement(By.tagName("h4")).getText();
        String expected = "Your e-mail's been sent!" ;

       Assert.assertEquals(actual,expected);

    }

    // Task for 5 min
    // Given user is on the practice page
    // When user navaiagtes "Checkboxe" page
    // and clicks on checkbox #1
    // Then user verifies that checkbox #1 is selected
    @Test
    public void checkBoxTest1(){

        driver.findElement(By.linkText("Checkboxes")).click();

       WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
       checkbox1.click();

        Assert.assertTrue(checkbox1.isSelected(),"CheckBox #1 is not selected");

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}



// @Test -> we put this test annotation to make methods executable as tests
// no need main
// Before method we setup driver
// After method we quit
// requirement says so

// HOW TO HANDLE SSL ISSUE IN SELENIUM
// create chrome options and setAccepInsecureCertifacate(true)
// and add it in your driver
