package com.cydeo.tests.Homework.week3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task_2_3 {
    WebDriver driver;

    @BeforeMethod

    public void SetupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }
    @Test
    public void Task2(){

        WebElement confirm= driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        confirm.click();

        Alert alert=driver.switchTo().alert();
        alert.accept();

        WebElement acceptText= driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(acceptText.isDisplayed(),"You clicked: Ok");
    }


    @Test

    public void Task_3(){

        WebElement confirm= driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        confirm.click();

        Alert alert=driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();

        WebElement result= driver.findElement(By.xpath("//p[@id='result']"));


        Assert.assertTrue(result.isDisplayed(),"You entered: hello");
    }


    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

}
/*
TC #2: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed.


TC #3: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Prompt” button
4. Send “hello” text to alert
5. Click to OK button from the alert
6. Verify “You entered: hello” text is displayed.
 */