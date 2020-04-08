package com.automation.tests.day13;

import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class ConfigurationReaderTest {

    // this is easiest path
    // one browser at a time
    // one method to call
    // we creating map(properties) where we store project references.
    // all test will have same properties
    // we avoid to hard coding (changing properties from test cases)
    // this is take it and move

    @Test

    public void readProperties() {

        String browser = ConfigurationReader.getProperty("browser");
        String url = ConfigurationReader.getProperty("qa1");
        String color1 = ConfigurationReader.getProperty("color");
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");

        System.out.println(browser);
        System.out.println(url);
        System.out.println(color1);
        System.out.println(username);
        System.out.println(password);

        // we can set property like this
        System.setProperty("automation tool", "Selenium");
        System.out.println(System.getProperty("automation tool"));
    }
}
