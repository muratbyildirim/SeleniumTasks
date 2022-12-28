package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_findElements {

    public static void main(String[] args) {

        //TC #4: FindElements Task
        //1- Open a Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //Providing extra wait time for our driver before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

        List<WebElement> allLinks=driver.findElements(By.tagName("a"));
        System.out.println("allLinks.size() = " + allLinks.size());

        for (WebElement each : allLinks) {
            System.out.println("each.getText() = " + each.getText());
            System.out.println("each.getAttribute(\"href\") = " + each.getAttribute("href"));

        }


    }

}
