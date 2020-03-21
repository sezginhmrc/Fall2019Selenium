package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {

    // Runs only once before @BeforeClass and @BeforeMethod
    @BeforeTest
    public void beforeTest(){
        //something should be done only once in the class BEFORE ALL TESTS
        System.out.println("BEFORE TEST");
    }

    //runs only once after @Afterclass after @Aftermethod
    @AfterTest
    public void afterTest(){
        // something that should be done once in the class AFTER ALL TESTS
        System.out.println("AFTER TEST");
    }

    // Runs only once in the class before @beforemethod and before any test
    // regardless on number of tests, if runs only once
    @BeforeClass
    public void beforeClass(){
        // it should be done only once in the class BEFORE ALL TESTS
        System.out.println("BEFORE CLASS");
    }

    @AfterClass
    public void afterClass(){
        // smth should be done only once in the class AFTER ALL TESTS
        System.out.println("AFTER CLASS");
    }
    //runs before every test automatically
    // works as a pre-condition
    @BeforeMethod
    public void setup(){
        System.out.println("BEFORE METHOD");
    }

    // runs automatically after every test
    @AfterMethod
    public void teardown(){
        System.out.println("AFTER METHOD");
    }





    @Test
    public void test1(){
        System.out.println("TEST 1");
        String actual = "apple";
        String expected = "apple" ;

        // it calls hard assertion
        // if assertion fails - it stops the execution(due to exception)
        Assert.assertEquals(actual,expected);
    }


    @Test
    public void test2(){
        System.out.println("TEST 2");
        int num1 = 5 ;
        int num2 = 10 ;

        Assert.assertTrue(num1<num2);
    }
}

// once we have more tests above annotations will help us


// ABOUT TETSNG...

/* Testng and JUnit(tools)
they will help, give structute, shortcuts, be able to run and manage test cases in more effective way
this tools are very simple to understand sometimes complex in some part
in building framework and we can easily test
it is way a bulding a test and run at same time
Selenium is automation tool
TestNg is framework connect with selenium
Advantages ; TestNg is has more tools than JUnit
Annotations to use and understand when building test scripts
Test cases can be grouped (we can group by class)
Generate Reports (the reporting for testNg, instead we use a different tool)

@Annotations
- are actually instructions for our JVM
- minimize our testing more effective way
- they have information for how a test should instructions

@Test
- this way we can run our test cases seperatly than other ones
- without main method

@BeforeMethod @AfterMethod
- Scope
- it goes back to Java (local variable it is in same class)

-> Most of them We will use @test and @beforemethod and @aftermethod

@BeforeClass, @AfterClass

@BeforeTet , @AfterTets

@BeforeGroup, @AfterGroup

@BeforeSuite, @AfterSuite

Clarifcation :

@BeforeMethod vs @BeforeGroup

@Test
public voud test1(){
sout("hello")

@Test
public voud test2(){
sout("world")

@BeforeMethod
public void setup(){
int count = 1 ;
sout(test1)
-


*
*
*
*
*
* */