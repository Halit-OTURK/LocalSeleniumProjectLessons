package com.cydeo.tests.Homework.week3;


import utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task_7 {
    WebDriver driver;

    @BeforeMethod

    public void SetupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test

    public void Task_7() throws InterruptedException {

        WebElement ddroplink = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        ddroplink.click();

        WebElement face = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));
        face.click();

        Thread.sleep(1000);


        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, "Facebook - Giriş Yap veya Kaydol");

    }

    @AfterMethod

    public void tearDownMethod(){
        driver.quit();
    }
}



/*
TC #7: Selecting value from non-select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Click to non-select dropdown
4. Select Facebook from dropdown
5. Verify title is “Facebook - Log In or Sign Up”
 */
