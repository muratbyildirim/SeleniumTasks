package com.cydeo.tests.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    //There is some changes here

     /*
    This method will accept int (in seconds) and execute Thread.sleep
    for given duration
     */

    public static void sleep(int seconds){

        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {

        }
    }

     /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */

    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedInTitle){
        Set<String> allWindowsHandles=driver.getWindowHandles();

        for (String eachWindows : allWindowsHandles) {
            driver.switchTo().window(eachWindows);
            System.out.println("Current URL: "+driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains(expectedInUrl)){
                break;
            }

        }
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    //This method accepts a String "expectedTitle" and Asserts if it is true
    public static void verifyTitle(WebDriver driver ,String expectedTitle){

        Assert.assertEquals(driver.getTitle(), expectedTitle);

    }




}
