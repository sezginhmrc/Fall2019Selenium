package com.automation.tests.day9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationFormTestNG {

    // one xpath for all inputs : //label[text()='Label Name']/..//input
    private WebDriver driver ;
    private By name = By.name("firstname");
    private By lastName = By.name("lastname");
    private By userName = By.name("username");
    private By email = By.name("email");
    private By password = By.name("password");
    private By phoneNumber = By.name("phone");
    private By male = By.cssSelector("input[value='male']");
    private By female = By.cssSelector("input[value='female']");
    private By birthDay = By.name("birthday");
    private By department = By.name("department");
    private By jobTitle = By.name("job_title");
    private By languageCPlus = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By signUp = By.xpath("//button[text()='Sign up']");

    private By warningMessage = By.xpath("//small[text()='first name can only consist of alphabetical letters']");
    @Test
    public void RegistrationForm(){
        driver.findElement(name).sendKeys("sezgin");
        driver.findElement(lastName).sendKeys("hamurcu");
        driver.findElement(userName).sendKeys("sezohmrc");
        driver.findElement(email).sendKeys("qwes@hormas.om");
        driver.findElement(password).sendKeys("nabersinya2");
        driver.findElement(phoneNumber).sendKeys("123-123-1233");
        driver.findElement(male).click();
        driver.findElement(birthDay).sendKeys("02/02/2002");

        Select depatmentSelect = new Select(driver.findElement(department));
        depatmentSelect.selectByVisibleText("MPDC");

        Select jobTitleSelect = new Select(driver.findElement(jobTitle));
        jobTitleSelect.selectByVisibleText("Developer");

        driver.findElement(languageCPlus).click();
        driver.findElement(signUp).click();

        String expected = "You've successfully completed registration!";
        String actual =  driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void verifyFirstNameLenghtTest(){
        driver.findElement(name).sendKeys("a");
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));

        Assert.assertTrue(warningMessage.isDisplayed());
    }
    @Test
    public void verifyAlpahabeticLettersOnlyTest(){
        driver.findElement(name).sendKeys("123");
        WebElement warning = driver.findElement(warningMessage);
        Assert.assertTrue(warning.isDisplayed());
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        String URL = "http://practice.cybertekschool.com/registration_form";
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void teardown(){
        if(driver!=null){
            driver.close();
            driver=null;
        }
    }
}
