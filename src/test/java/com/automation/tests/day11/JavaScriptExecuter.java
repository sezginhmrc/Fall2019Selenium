package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecuter {

    // we need to upcasting to be able to interact our browser by JSE
    private WebDriver driver ;


        @BeforeMethod
        public void setup(){
            driver = DriverFactory.createADriver("chrome");
            driver.get("http://practice.cybertekschool.com/");
            driver.manage().window().maximize();
        }

        @Test
        public void verifyTitle (){
            String exptexted = "Practice" ;
            // we gonna get title using JSE
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String actual = (String ) js.executeScript("return document.title");
            // ExecuteScript method execute javascript code
            // We provide actual as astring
            // return.document.title always like this
            System.out.println(actual);

            Assert.assertEquals(actual,exptexted);

            // We can esily get Url or title or any other attribute by usin console in inspect
            // document.title
            // document.url
        }

        @Test(description = "ClickTest on Multiple Buttons")
        public void clickTest(){
            WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
            BrowserUtils.wait(2);

            // we found link and we will click the link by JSE
            JavascriptExecutor js = (JavascriptExecutor) driver;

           // js.executeScript("",link);
            // after "" we can list webelement that will be used as part of your java script code

            // after comma we can specify element that will be interact
            js.executeScript("arguments[0].click()",link);
            // we clicked multiple buttons link by JSE

            WebElement bttn6 = driver.findElement(By.cssSelector("#disappearing_button"));
            js.executeScript("arguments[0].click()",bttn6);
            // clicked bttn6 using JSE
            BrowserUtils.wait(2);

            WebElement result = driver.findElement(By.cssSelector("#result"));
            Assert.assertEquals(result.getText(),"Now it's gone!");

            // We usually deal with one argument -> arguments[0]

        }
        @Test
        public void practiceJSE(){

            WebElement link = driver.findElement(By.linkText("Form Authentication"));
            BrowserUtils.wait(3);

            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].click()",link);

            BrowserUtils.wait(3);

            WebElement username = driver.findElement(By.name("username"));
            WebElement password = driver.findElement(By.name("password"));
            WebElement login = driver.findElement(By.id("wooden_spoon"));

            js.executeScript("arguments[0].setAttribute('value','tomsmith')",username);
            js.executeScript("arguments[0].setAttribute('value','SuperSecretPassword')",password);
            js.executeScript("arguments[0].click()",login);
            // arguments[0] this index one element

            BrowserUtils.wait(4);

            String expected = "Welcome to the Secure Area. When you are done click logout below.";

            String actual = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();

            Assert.assertEquals(actual,expected);

        }


    @Test
    public void enterTextJCE(){

            WebElement link = driver.findElement(By.linkText("Form Authentication"));
            BrowserUtils.wait(2);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()",link);

            WebElement username = driver.findElement(By.name("username"));
            WebElement password =driver.findElement(By.name("password"));
            WebElement loginButton = driver.findElement(By.id("wooden_spoon"));
            js.executeScript("arguments[0].setAttribute('value','tomsmith')",username);
            js.executeScript("arguments[0].setAttribute('value','SuperSecretPassword')",password);
            js.executeScript("arguments[0].click()",loginButton);
            // this is how we can enter text and password and click login with JSE

            BrowserUtils.wait(2);


            String expected = "Welcome to the Secure Area. When you are done click logout below.";
             String subheader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();

             Assert.assertEquals(subheader,expected);
    }



        @Test
        public void scrollToElement(){
            WebElement link = driver.findElement(By.linkText("Cybertek School"));
            BrowserUtils.wait(2);
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].scrollIntoView(true)",link);
            // just scrooling the page down from webpage
            // if true it will be scrollin
        }

        @Test
        public void scrollTest(){
            driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");
            JavascriptExecutor js = (JavascriptExecutor) driver ;
            BrowserUtils.wait(4);
            for (int i = 0; i <15 ; i++) {
                js.executeScript("window.scrollBy(250,1000)");
            }

        }

        @AfterMethod
        public void teardown(){
            BrowserUtils.wait(2);
            driver.quit();
        }
}

