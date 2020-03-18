package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {

    public static void main(String[] args) {
        // unit testing
        // to check if our method works properly
        // if assertion fails, that means our merhod does no wrok correctly
        // that means we have to fix the method


        String expected = "cba";
        String toReserve = "abc";
        String actual = reverseString(toReserve);

        // Assertion
        verifyEquals(expected,actual);

    }
    // This is unit testing now..
    // annotation (it comes from TestNG)
    @Test(description = "Verify if method can reverse a string")
    public void test(){
        String expected = "elppa" ;
        String actual = reverseString("apple");

        Assert.assertEquals(actual,expected);

        // this method does the same as method we createad (assertion)
        // it comes from testNg and Junit also has this class
        // you can compare any data types here : string ,primitives ,arrays, objects
        // to verify i expected result is equals to actual
    }
    @Test (description = "verify if method can reverse a string")
    public void test2(){
        String expected = "rac" ;
        String actual = reverseString("car");
        Assert.assertEquals(actual,expected);
    }


    public static boolean verifyEquals (String expected , String actual){
        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
            return true ;
        }
        else {
            System.out.println("TEST FAILED");
            System.out.println("Expected = " +expected);
            System.out.println("Actual = " +actual);
            return false ;
        }
    }
    /*
    This method stands for reversing strings
    @param str to resserve
    @return reverse string
    */
    public static String reverseString (String str){
        String reversed = "";

        for (int i = str.length()-1; i >=0 ; i--) {
            reversed+=  str.charAt(i);
        }
        return reversed ;
    }
}
// Unit testing concept is checking if methods working properly

