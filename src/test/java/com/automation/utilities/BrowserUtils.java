package com.automation.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrowserUtils {

        public static void wait(int seconds){
            try {
                Thread.sleep(1000 * seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // this is the logic the get texts from List of Element
      // whatever they pass as aan element
    // it will get you the values of element as a collection of string
        public static List<String> getTextFromWebElements(List<WebElement> elements){
            List<String> textValues = new ArrayList<>();
            for (WebElement element : elements){
                if(!element.getText().isEmpty()){
                    textValues.add(element.getText());
                }
            }
            return textValues ;
        }



    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }


    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Scroll to element using JavaScript
     *
     * @param element
     */
    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);




    }
    /**
     * @param name screenshot name
     * @return path to the screenshot
     */

    // THIS IS GETSCREENSHOT METHOD
    // IT WILL TAKE THE SCREENSHOT AND
    // AND IT WILL RETURN THE LOCATION OF SCREENSHOT
    public static String getScreenshot(String name) {
        //adding date and time to screenshot name, to make screenshot unique
        name = new Date().toString().replace(" ", "_") + "_" + name;
        //                                      Fri_Apr_10_17:35:39_EDT_2020_name. png
        //where we gonna store a screenshot
        // it will open test-output folder and will save screshoots inside screenshot file
        String path = "";
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            path = System.getProperty("user.dir") + "/test-output/screenshots/" + name + ".png";
            System.out.println("Screen shots here = " +path);
            // user dir returns  location of your project (/Users/sezgin/fall2019Selenium...//)
            // png is exxtension for images
            // path is where we store screenshots
        } else {
            path = System.getProperty("user.dir") + "\\test-output\\screenshots\\" + name + ".png";
        }
       //  System.out.println("OS name: " + System.getProperty("os.name"));
       // System.out.println("Screenshot is here: " + path);
        //since our reference type is a WebDriver
        //we cannot see methods from TakesScreenshot interface
        //that's why do casting
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        //take screenshot of web browser, and save it as a file
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        //where screenshot will be saved
        File destination = new File(path);
        try {
            //copy file to the previously specified location (path)
            FileUtils.copyFile(source, destination);
            // source is screenshot
            // destination is where screenshot will be stored
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    // We created path Where We gonna store screenshots
    // and We use the getscreenshot method
    // and defined the screenshot into a file  as a format png (outputType.File)
    // and defined the destination of path
    // and we copy the file in the path as screenshot file as a nice format

    // BASICALLY WE USE THIS METHOD TO GET SCREENSHOT
    // AND SAVE IT AS FILE IN OUR PROJECT
    // AND IT WILL RETURN THE LOCATION OF PROJECT.


}


