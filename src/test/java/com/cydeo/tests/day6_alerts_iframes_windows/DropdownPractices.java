package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        //2. Go to https://practice.cydeo.com/dropdown
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/dropdown");

    }

    @Test
    public void dropdown_task5() throws InterruptedException {
        //TC #5: Selecting state from State dropdown and verifying result 1. Open Chrome browse
        //we located the dropdown and it is ready to use

        Select stateDropdown=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String selectedStateDropdown=stateDropdown.getFirstSelectedOption().getText();
        System.out.println("selectedStateDropdown = " + selectedStateDropdown);

        //3. Select Illinois
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia
        Thread.sleep(2000);
        stateDropdown.selectByValue("VA");
        //5. Select California
        Thread.sleep(2000);
        stateDropdown.selectByIndex(5);

        //6. Verify final selected option is California.

        String expectedOptionText="California";
        String actualtedOptionText=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOptionText,actualtedOptionText);


    }
    @Test
    public void dropdown_task6(){
        //Select “December 1 , 1923” and verify it is selected.
        Select yearDropdown=new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown=new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //Select year using : visible text
        yearDropdown.selectByVisibleText("2023");
        //Select month using : value attribute
        monthDropdown.selectByValue("11");
        //Select day using : index number
        dayDropdown.selectByIndex(0);

        String expectedYear = "2023";
        String expectedMonth = "December";
        String expectedDay = "1";



        String actualYear=yearDropdown.getFirstSelectedOption().getText();
        String actualMonth=monthDropdown.getFirstSelectedOption().getText();
        String actualDay=dayDropdown.getFirstSelectedOption().getText();

        System.out.println("actualDay = " + actualDay);
        System.out.println("actualMonth = " + actualMonth);
        System.out.println("actualYear = " + actualYear);

        Assert.assertTrue(expectedYear.equals(actualYear));
        Assert.assertEquals(expectedDay,actualDay);
        Assert.assertEquals(expectedMonth,actualMonth);


    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }




}
