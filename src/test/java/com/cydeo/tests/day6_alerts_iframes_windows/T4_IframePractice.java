package com.cydeo.tests.day6_alerts_iframes_windows;


import utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_IframePractice {
    WebDriver driver;

    @BeforeMethod
    public void SetupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://practice.cydeo.com/iframe");

    }
    // @Ignore for skip this test part
    @Test
    public void IframeTask1() {

        //We need to switch driver's focus to iframe
        //option #1- switching to iframe using id attribute value
        //driver.switchTo().frame("mce_0_ifr");

        //option #2- passing index number of iframe
        //driver.switchTo().frame(0);

        //option #3- locate as web element and pass in frame() method

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));

        Assert.assertTrue(yourContentGoesHereText.isDisplayed());
        driver.switchTo().parentFrame();

        WebElement headerText= driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(headerText.isDisplayed());
    }

    @AfterMethod
    public void tearDownMethod(){

        driver.close();
    }


}
/*
TC #4: Iframe practice
1. Create a new class called: T4_Iframes
2. Create new test and make set ups
3. Go to: https://practice.cydeo.com/iframe
4. Assert: “Your content goes here.” Text is displayed.
5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
 */