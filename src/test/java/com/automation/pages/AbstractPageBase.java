package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageBase {

    // this class will be extended by page classes
    // any common web element / locators can be stored here
    // any web element that will appears as is in anywhere
    // since navigation menu does not belong to particular page
    // we cannot really create a dedicated page class to store
    // elements from that menu

    protected WebDriver driver = Driver.getDriver();
    // more reuse code
    // every page will get driver like below
    protected WebDriverWait wait = new WebDriverWait(driver,15);
    // every page class implement this wait

    @FindBy(css = "#user-menu > a")
    protected WebElement currentuser;
    // this current owner element belongs to top menu and comman for all test cases..
    // it belongs basePage
    // We can store this top menu elements here BasePAge since they are shared for pages in application


    public AbstractPageBase(){
        PageFactory.initElements(driver,this);
        // initialzes pagefactory to use @Findby in all subclasses
    }


    public String getCurrentUserName(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(currentuser));
        return  currentuser.getText().trim();
    }
    /*
    *
    * @param tabName, like Dashboards, Fleet or Costumers
    * @parm moduleName, like Vehicles, Vehicles Odometer and Vehicles Costs
    * */
    public void navigateTo(String tabName, String moduleName){

        String tagNamePath = "//span[@class='title title-level-1' and contains(text(),'"+tabName+"')]";
        // this tagName locator is common for all tagNames on page of Application
        // according the given tabName it will find that element
        String moduleXpath = "//span[@class='title title-level-2' and text()='" + moduleName + "']";
        // this modelName locator is commoan for all Modul name on page
        // accordgin the given modulName it will find  that the module

        WebElement tabElement = driver.findElement(By.xpath(tagNamePath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleXpath));


        Actions actions = new Actions(driver);

        BrowserUtils.wait(4);
        actions.moveToElement(tabElement)
                .pause(2000)
                .click(moduleElement)
                .build().perform();

        // increase this wait tim here if still failing
        BrowserUtils.wait(4);
    }
}
