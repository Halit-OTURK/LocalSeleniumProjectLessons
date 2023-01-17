package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {

    WebDriver driver;

    @BeforeMethod
    public void SetupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @Test
    public void order_name_verify_test(){

        /*WebElement bob= driver.findElement(By.xpath("//table[@class='SampleTable']//tbody//tr[7]//td[2]"));
        if the table will change this location also change. we can use name path */
WebElement bob=driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
        String actual= bob.getText();

        Assert.assertEquals(actual,"Bob Martin");
        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021

        // alternative locator to bobMartinDateCell = "//td[.='Bob Martin']/../td[5]"
        WebElement bobMartinDateCell =
                driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));

        String expectedBobDate = "12/31/2021";
        String actualBobDate = bobMartinDateCell.getText();

        Assert.assertEquals(actualBobDate, expectedBobDate);

    }
    //We use the utility method we created.
    @Test
    public void Test2(){
    String customerOrderName1= WebTableUtils.returnOrderDate(driver,"Alexandra Gray");
    System.out.println("customerOrderName1 = " + customerOrderName1);

    String costumerOrderDate2 = WebTableUtils.returnOrderDate(driver, "John Doe");
    System.out.println("costumerOrderDate2 = " + costumerOrderDate2);
    }


    //Using WebTableUtils.orderVerify(); method

    @Test
    public void test3(){

        WebTableUtils.orderVerify(driver,"Bart Fisher", "01/16/2021");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
}
/*
TC #1: Web table practice
1. Go to: https://practice.cydeo.com/web-tables
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
3. Verify Bob Martin’s order date is as expected
Expected: 12/31/2021
 */