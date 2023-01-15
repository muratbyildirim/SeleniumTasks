package com.cydeo.tests.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebTableUtils {

public static String  returnOrderDate(WebDriver driver,String customerName){
    String xpathLocator="//table[@id='ctl00_MainContent_orderGrid']//td[.='"+customerName+"']/following-sibling::td[3]";
    WebElement dateCell= driver.findElement(By.xpath(xpathLocator));

return dateCell.getText();
}

public static void orderVerify(WebDriver driver,String customerName,String customerExpectedDate){

    String xpathLocator="//table[@id='ctl00_MainContent_orderGrid']//td[.='"+customerName+"']/following-sibling::td[3]";
    WebElement dateCell= driver.findElement(By.xpath(xpathLocator));

    String actualOrderDate=dateCell.getText();

    Assert.assertEquals(customerExpectedDate,actualOrderDate);


}


}
