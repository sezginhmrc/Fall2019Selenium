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

public class PracticeTests {
    private WebDriver driver ;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        // to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        // provice chromeOptions objecto into chromeDriver constructor
       // driver = new ChromeDriver(chromeOptions);
      //  driver.get("http://practice.cybertekschool.com/");
      //  driver.manage().window().maximize();

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
@Test(description = "login test display message")
    public void test(){

        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        BrowserUtils.wait(2);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        BrowserUtils.wait(2);
        driver.findElement(By.id("wooden_spoon")).click();

        WebElement message = driver.findElement(By.className("subheader"));
        String actaul = message.getText();

        // if assertion fails - it will throw exception and message will be printed
    // 3 parameters : expected ,actual , message in case of error ....

        Assert.assertEquals(actaul,"Welcome to the Secure Area. When you are done click logout below.");

    }

    @Test
    public void test1 (){

        driver.navigate().to("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("seze@asdas.com",Keys.ENTER);
        BrowserUtils.wait(2);
        String actual = driver.findElement(By.tagName("h4")).getText();
        String expected = "Your e-mail's been sent!" ;

        System.out.println(actual);


       Assert.assertEquals(actual,expected);

    }

    @Test
    public void test2(){
        driver.navigate().to("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Checkboxes")).click();
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        BrowserUtils.wait(2);
        checkBoxes.get(0).click();

        Assert.assertTrue(checkBoxes.get(0).isSelected(),"CheckBox #1 is not selected");

    }
}



// @Test -> we put this test annotation to make methods executable as tests
// no need main
// Before method we setup driver
// After method we quit
// requirement says so

// HOW TO HANDLE SSL ISSUE IN SELENIUM
