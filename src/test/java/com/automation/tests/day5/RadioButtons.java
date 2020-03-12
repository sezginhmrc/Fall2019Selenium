package com.automation.tests.day5;

import com.automation.utilities.BrowserUtilites;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();

        // lets collect all radio buttons

        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        for(WebElement radioButton : radioButtons){

            if(radioButton.isEnabled()){
                // ISENABLE RETURN BOOLEAN
                // it checks if enable to click
                // and clicked all buttons and print attrbute like below
                radioButton.click();
                System.out.println("Clicked on : " +radioButton.getAttribute("id"));
                BrowserUtilites.wait(1);
            }
        // clicked all button on webpage
        // but there is a button disable How to check it ?
            // added if button.isEnabled
            else {
                System.out.println("Button is disabled, not clicked : " +radioButton.getAttribute("id"));
            }
        }
        // all ids are unique




        BrowserUtilites.wait(2);
        driver.quit();

// throws exceotion you warning user that can throw exeption
// try catch block it handle th exception you solve it .


    }
}
