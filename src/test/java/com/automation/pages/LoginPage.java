package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // this loginPage class is coreespoding of Login Page of Application
    // it provides web elements and methods for login page of application
    // @FindBy anonotions are used for findin elemenets without findElement
    // PageFactory is used for instaiance of object and find instance of class
    // it will return the these element and methods in test scripts

    /// these elements should be private
    // they are not supposed to be accesible in test cases
    // We already using them here in methods
    // they not will be accesible anywhere out of this class
    // benefit of encasuplation
    // it is about design and more organize code
    // all logic implement here in page class
    // oop in action........


    @FindBy (id="prependedInput")
    private WebElement username ;


    @FindBy (id="prependedInput2")
    private WebElement password ;

    @FindBy(id="_submit")
    private WebElement login ;

    @FindBy (linkText = "Forgot your password?")
    private WebElement forgotPassword ;


    //warning mesasge
    @FindBy(css= "*[class='alert alert-error']")
    private WebElement warningMessage ;

    // method that returns a text of waning message webelement
    // call it in test class
    public String getWarningMessageText(){
        return warningMessage.getText();
    }


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
        // this is where we connect web driver to find bannotation
        // to connect our driver, page class and page factory
        // PageFactory used to use @FindyBy annotations to find elements easily
    }

    // this is method for login
    // login gor specific user(driver or store manager or sales manager)
    public void login(String usernameValue,String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(3);
    }


    // if there is no dependencies on the the rule use this method
    // login for default user
    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"),Keys.ENTER);
        BrowserUtils.wait(3);
    }
}
// login functions ;
// first version is -> lets you to create from method
// second version is -> using credentials to create  from credential file

