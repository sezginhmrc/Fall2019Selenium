package com.automation.tests.day13;

import org.testng.annotations.Test;

import java.util.Properties;

public class SystemProperties {

    @Test
    public void test(){
        ///Users/sezgin/IdeaProjects/Fall2019Selenium/pom.xml
        System.out.println(System.getProperty("user.dir"));
        // it represent path to the project
        // properties is like a map (key value)
        // to specify path into file
        // to test data in your project
        // we have test file in my project how you gonna specify it to use on your program
        // it is on your environment
        System.out.println(System.getProperty("os.name"));

        System.out.println(System.getProperty("java.version"));

        System.out.println(System.getProperty("java.home"));

        System.out.println(System.getProperty("user.home"));

        String path = System.getProperty("user.dir") + "/configuration.properties";
        System.out.println(path);

        System.out.println(System.getProperty("user.dir")+ "/pom.xml");



    }

}

// instance block when object crerated
// static block no need to object