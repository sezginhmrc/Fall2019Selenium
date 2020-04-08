package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.manage().window().maximize();
        BrowserUtils.wait(4);
        driver.findElement(By.name("firstname")).sendKeys("sezgin");
        driver.findElement(By.name("lastname")).sendKeys("hamurcu");
        driver.findElement(By.name("username")).sendKeys("sezohamurc");
        driver.findElement(By.name("email")).sendKeys("sezo@hotmail.com");
        driver.findElement(By.name("password")).sendKeys("esmaesma");
        driver.findElement(By.name("phone")).sendKeys("123-123-1233");
        // all above are single element found it sent the Keys

        // now i have Gender button 3 types

        List<WebElement> genders = driver.findElements(By.name("gender"));

        genders.get(1).click();
        // select male
        // selected first button

        driver.findElement(By.name("birthday")).sendKeys("02/02/1994");

        Select departmentSelect = new Select(driver.findElement(By.name("department")));

        departmentSelect.selectByIndex(1);
        BrowserUtils.wait(4);

        Select jobSelect = new Select(driver.findElement(By.name("job_title")));
        jobSelect.selectByIndex(4);
        BrowserUtils.wait(4);

        // radio buttons are visible or not ?
        driver.findElement(By.id("inlineCheckbox2")).click();
        // for java language
        BrowserUtils.wait(4);
        // to select java
        // it is visible on screen no need select just click..

        // to click sign Up
        driver.findElement(By.id("wooden_spoon")).click();


        // VALIDATION PART
        String expected = "Well done!";
        String actual = driver.findElement(By.tagName("h4")).getText();

        if(expected.equals(actual)){
            System.out.println("TEST PASSED ");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("EXPECTED = " +expected);
            System.out.println("ACTUAL = " +actual);
        }




        BrowserUtils.wait(3);
        driver.quit();

    }
}
