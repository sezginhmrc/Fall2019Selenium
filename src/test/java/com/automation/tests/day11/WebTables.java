package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTables {

    private WebDriver driver ;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true); // to run browser GUI, make browser invisible
        // tests will perfrom without seeing the browser
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void getColumnNames(){
        driver.findElement(By.linkText("Sortable Data Tables")).click();
        BrowserUtils.wait(2);

        List<WebElement> columnNames =driver.findElements(By.xpath("//table[1]//th"));
        for (WebElement columns : columnNames){
            System.out.println(columns.getText());
        }
        List <String> expected = Arrays.asList("Last Name","First Name","Email","Due","Web Site","Action");
        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames),expected);

        // THIS IS GREAT !!!

       List<WebElement> firstRow = driver.findElements(By.xpath("//table[1]//tr[1]//td"));
       List <String> expected1thRow = Arrays.asList("Smith","John","jsmith@gmail.com","$50.00","http://www.jsmith.com","edit delete");

       Assert.assertEquals(BrowserUtils.getTextFromWebElements(firstRow),expected1thRow);
    }

    @Test
    public void getFirstRow(){
        driver.findElement(By.linkText("Sortable Data Tables")).click();
        BrowserUtils.wait(2);
        List<WebElement> firstRow = driver.findElements(By.xpath("//table[1]//tr[1]//td"));
        List <String> expected1thRow = Arrays.asList("Smith","John","jsmith@gmail.com","$50.00","http://www.jsmith.com","edit delete");

        Assert.assertEquals(BrowserUtils.getTextFromWebElements(firstRow),expected1thRow);

        ///table[1]//tr[2]//td[3]
        // it means at table 1 second row third column... like a excel...
        // table[1] -> first table on website
        // tr -> table row
        // td -> table data
    }

    @Test
    public void verifyRowCount (){
        driver.findElement(By.linkText("Sortable Data Tables")).click();
        BrowserUtils.wait(2);

        List<WebElement> rows =driver.findElements(By.xpath("//table[1]//tbody//tr"));
        System.out.println("rows.size() = " + rows.size());
        Assert.assertEquals(rows.size(),4);
    }

    @Test
    public void getSpecificColumn(){
        driver.findElement(By.linkText("Sortable Data Tables")).click();
        BrowserUtils.wait(2);

        // to get specific column,skip row index, and just provide td index
        List<WebElement> links =driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(links));


        // omce we find email cell in the first table that has this email ->jdoe@hotmail.com
        // following sibling has this linktex delete ;
        // //table[1]//td[text()='jdoe@hotmail.com']//following-sibling::td/a[text()='delete']
        // //table[1]//td[text()='jsmith@gmail.com']/..//a[2] - to go directly easier from email.
    }

    @Test
    public void deleteRowTask(){
        driver.findElement(By.linkText("Sortable Data Tables")).click();
        BrowserUtils.wait(2);
        // String xpath = "//table[1]//td[text()='jsmith@gmail.com']/..//a[2]";
        //driver.findElement(By.xpath(xpath)).click();

        driver.findElement(By.xpath("//table[1]//td[text()='jsmith@gmail.com']/..//a[2]")).click();

      List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));

      Assert.assertEquals(rows.size(),3);

      // how do verify that elemet has deleted ?
      Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty());
      // find elemet xpath and assert  true if it is empty

        // if nothing exists if element is deleted ! ! ! ! you will get exception if you try to find it.

    }


    // lets write a function that will return column index based column name
    @Test
    public void getColumnIndexByName(){
        driver.findElement(By.linkText("Sortable Data Tables")).click();
        BrowserUtils.wait(2);

        String columnName = "Email" ;
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[2]//th"));

        int index = 0 ;
        for (int i = 0; i <columnNames.size() ; i++) {
            if(columnNames.get(i).getText().equals(columnName)){
                index = i + 1 ;
            }
        }

        Assert.assertEquals(index,3);



    }


    @Test
    public void getSpecificCell(){
        // to get specifc row and cell
        // -> //table[1]//tbody//tr[1]//td[2]
        // table 1 or 2 and body and row and cel

        driver.findElement(By.linkText("Sortable Data Tables")).click();
        BrowserUtils.wait(2);

        int row = 2 ;
        int column = 4 ;
        // we can change values to gel different cell

        String xPath = "//table[1]//tbody//tr["+row+"]//td["+column+"]";

        WebElement cell =driver.findElement(By.xpath(xPath));

        String expected = "$51.00";
        Assert.assertEquals(cell.getText(),expected);
    }




    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}
