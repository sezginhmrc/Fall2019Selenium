package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");

        BrowserUtils.wait(2);

        // how to upload file ? - we need to find locator by that choose button

        WebElement upload = driver.findElement(By.id("file-upload"));

        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        // i am gonna upload pom.xml file
        String filePath = System.getProperty("user.dir")+"/.gitignore" ;
        // System setProperty -> it returns to location of project
        // For every computer path is different user.dir returns path to your project
        // wrongFilePath is most comman exception here
        // this is the filePath and how it looks like..
        String file2Path = "/Users/sezgin/Downloads/definition-of-done.png";
        // this is location of my file in computer

        System.out.println(filePath);
        // we got properties from our project -> System.getProperty("user.dir")+..
        upload.sendKeys(file2Path);



        driver.findElement(By.id("file-submit")).click(); // to click upload


        BrowserUtils.wait(2);

        driver.quit();




        driver.quit();
    }
}
