package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Amazon {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("https://www.amazon.com/");
        BrowserUtils.wait(2);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        BrowserUtils.wait(2);

        List<WebElement> names = driver.findElements(By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']"));
        List<WebElement> prices = driver.findElements(By.cssSelector("span[class='a-price-whole']"));

        /*for (int i = 0; i <prices.size() ; i++) {
            System.out.println(prices.get(i).getText());

        }*/

        for (WebElement name : names) {
            System.out.println("each name= = " +name.getText());
        }

        for (WebElement price : prices){
            System.out.println("Each price = " + price.getText());
        }

        BrowserUtils.wait(2);
        driver.quit();

    }
}
