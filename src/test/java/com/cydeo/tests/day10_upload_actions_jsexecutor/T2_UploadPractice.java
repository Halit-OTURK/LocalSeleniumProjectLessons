package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_UploadPractice {

    @Test
    public void uploadTest() {

        Driver.getDriver().get("https://practice.cydeo.com/upload");
       String path = "E:/programming/html/HTML class/sunnyday.jpg";

        /*
        String path ="C:\\Users\\hayat\\Desktop\\note.txt";
         */

        //3. Upload the file.
        WebElement fileUpload = Driver.getDriver().findElement(By.id("file-upload"));
        BrowserUtils.sleep(2);
        fileUpload.sendKeys(path);

        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();

        //4. Assert:
        //-File uploaded text is displayed on the page
        WebElement fileUploadedHeader = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedHeader.isDisplayed());



    }
}
//TC #2 Upload Test
//1. Go to https://practice.cydeo.com/upload
//2. Find some small file from your computer, and get the path of it.
//3. Upload the file.
//4. Assert:
//-File uploaded text is displayed on the page