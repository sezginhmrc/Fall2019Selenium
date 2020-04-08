package com.automation.pages.fleet;

import com.automation.pages.AbstractPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehiclesPageBase extends AbstractPageBase {

    // for every page we gonna create a corresponding page class
    // we can group page classes based on tab name.
    // VyTrack app pages -> Vehicles, Vehicles Models, Vehicle Models
    // Framework         -> VehiclesPage.java, VehiclesModelsPage.java

    @FindBy(partialLinkText = "Create Car")
    private WebElement createCar ;

    // for simple click for Vehicles Page and test should call this method and handle all other actions

    public void clickToCreateCar(){
        wait.until(ExpectedConditions.elementToBeClickable(createCar)).click();
        // test should call click and handle

    }

}
