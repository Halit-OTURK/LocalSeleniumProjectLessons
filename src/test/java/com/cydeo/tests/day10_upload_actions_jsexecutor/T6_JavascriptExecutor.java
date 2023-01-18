package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T6_JavascriptExecutor {

    @Test

    public void Js_Test(){

        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");
        //((JavascriptExecutor)Driver.getDriver()).executeScript(""); => second way down casting
      JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        for (int i = 0; i < 11; i++) {
            BrowserUtils.sleep(2);
        js.executeScript("window.scrollBy(0,750)");
        }


        for (int i = 0; i < 11; i++) {
            BrowserUtils.sleep(2);
            js.executeScript("window.scrollBy(0,-750)");
        }

        Driver.getDriver().close();
    }



    @Test
    public void youtubeTest(){

        Driver.getDriver().get("https://www.youtube.com/");
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        for (int i = 0; i < 7; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");
        }


        for (int i = 0; i < 6; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-750)");
        }

        Driver.getDriver().close();
    }



}
//TC #6: Scroll using JavascriptExecutor
//1- Open a chrome browser
//2- Go to: https://practice.cydeo.com/infinite_scroll
//3- Use below JavaScript method and scroll
//a. 750 pixels down 10 times.
//b. 750 pixels up 10 times
//JavaScript method to use : window.scrollBy(0,0)
