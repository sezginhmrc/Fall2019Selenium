package com.automation.tests.WarpUp;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tuesday17 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://qa3.vytrack.com");
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();

        // click on contract
        // crete contact

        WebElement contact_link = driver.findElement(By.xpath("//span[.='Contacts']/following-sibling::a"));
        contact_link.click();
        BrowserUtils.wait(3);



        BrowserUtils.wait(2);
        driver.quit();
    }
}
