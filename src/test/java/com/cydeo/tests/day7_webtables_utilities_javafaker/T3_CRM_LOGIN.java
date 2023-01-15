package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.CRM_Utilities;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_CRM_LOGIN {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    //TC #3: Login scenario
    @Test
    public void crm_login_test(){
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3. Enter valid username
        WebElement inputUserName= driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
       inputUserName.sendKeys("helpdesk2@cybertekschool.com");

        //helpdesk1@cybertekschool.com  UserUser
        //Helpdesk2@cybertekschool.com  UserUser
        WebElement inputPassword= driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to Log In button
        WebElement loginButton= driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //6. Verify title is as expected:
        //Expected: Portal
        String expectedTitle="(1) Portal";
        String actualTitle= driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);


    }
    @Test
    public void crm_login_test_1(){
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        CRM_Utilities.crm_login(driver);

        //6. Verify title is as expected:
        //Expected: Portal

        BrowserUtils.verifyTitle(driver,"(1) Portal");

    }

    @Test
    public void crm_login_test_2(){
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //Helpdesk2@cybertekschool.com  UserUser
       CRM_Utilities.crm_login(driver,"Helpdesk2@cybertekschool.com","UserUser");

        //6. Verify title is as expected:
        //Expected: Portal

        BrowserUtils.verifyTitle(driver,"(1) Portal");

    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }




}
