package com.automation.tests.Homework3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Days {

   private WebDriver driver ;

   @BeforeMethod
   public void setup(){

      driver = DriverFactory.createADriver("chrome");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.manage().window().maximize();

   }
   @Test (description = "TEST 1",priority = 0)
    public void days(){

       driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

      List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
      List<WebElement> labels = driver.findElements(By.xpath("//label"));

      int countFriday = 0 ;
      Random random = new Random();

      while ((countFriday!=3)){
         int index = random.nextInt(checkboxes.size()-1);
         WebElement current = checkboxes.get(index);
         if(current.isEnabled()){
            current.click();
            System.out.println(labels.get(index).getText());
            current.click();
            if(labels.get(index).getText().equals("Friday")){
               countFriday++;
               System.out.println(countFriday);
            }
         }
       }
      Assert.assertEquals(countFriday,3);
   }




   @Test ( description = "TEST 2", priority = 1)
   public void year() {
      driver.get("http://practice.cybertekschool.com/dropdown");

      String actual = driver.findElement(By.id("year")).getAttribute("value");
      String expected = LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY"));
      Assert.assertEquals(actual, expected);
      System.out.println("actual = " + actual);
      System.out.println("expected = " + expected);

   }
      @Test (description = "TEST 2",priority = 2)
      public void  month(){
         driver.get("http://practice.cybertekschool.com/dropdown");


         Select select = new Select(driver.findElement(By.id("month")));

         String actualMonth = select.getFirstSelectedOption().getText();

         String expectedMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM"));
         System.out.println(actualMonth);
         System.out.println(expectedMonth);
         Assert.assertEquals(actualMonth,expectedMonth);

      }
      @Test (description = "TEST 2",priority = 3)
      public void day() {
         driver.get("http://practice.cybertekschool.com/dropdown");

         Select day = new Select(driver.findElement(By.id("day")));
         String actualDay = day.getFirstSelectedOption().getText();
         String expextedDay = LocalDate.now().format(DateTimeFormatter.ofPattern("dd"));
         System.out.println(expextedDay);
         System.out.println(actualDay);
         Assert.assertEquals(actualDay,expextedDay);

      }

      @Test( description = "TEST 3", priority = 4)
      public  void dropdwons(){

      //step1
      driver.get("http://practice.cybertekschool.com/dropdown");

      //step2
      //Select year = new Select(driver.findElement(By.id("year")));
      //year.selectByVisibleText("1994");





         Select year = new Select(driver.findElement(By.id("year")));
         Select month = new Select(driver.findElement(By.id("month")));
         Select day = new Select(driver.findElement(By.id("day")));
         List<WebElement>  years = year.getOptions();
         List<WebElement> months = month.getOptions();
         List<WebElement> days = day.getOptions();

         Random r = new Random();



            int current = r.nextInt(years.size());
            years.get(current).click();

            for(WebElement monthh : months){
               month.selectByIndex(r.nextInt(months.size()));
            /*for (int j = 0; j <months.size() ; j++) {
                  month.selectByIndex(j);
                  int currentDaySize =days.size();
               System.out.println(currentDaySize);
               Assert.assertEquals(days.size(),currentDaySize);*/
            }





            }


  //       Assert.assertEquals(actual,expected);





   @AfterMethod
   public void teardown(){
      driver.quit();
   }


}
