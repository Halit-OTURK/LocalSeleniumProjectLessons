package com.cydeo.tests.day7_webtables_utilities_javafaker;


import utilities.BrowserUtils;
import utilities.CRM_Utilities;
import utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_CRM_LOGIN {
    WebDriver driver;

    @BeforeMethod

    public void SetUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void crm_login_test() {

        driver.get(" https://login1.nextbasecrm.com/");
        WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys("helpdesk1@cybertekschool.com");
        WebElement password= driver.findElement(By.xpath(" //input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");
        WebElement login= driver.findElement(By.xpath(" //input[@type='submit']"));
        login.click();
        BrowserUtils.verifyTitle(driver,"My tasks");

    }

    @Test
    public void crm_login_test2(){


        driver.get("https://login1.nextbasecrm.com/");

        //Calling my utility method to login helpdesk1
        CRM_Utilities.crm_login(driver);

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "EULA violation");
    }


    @Test
    public void crm_login_test3() {

        driver.get(" https://login1.nextbasecrm.com/");
        WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys("Helpdesk2@cybertekschool.com");
        WebElement password= driver.findElement(By.xpath(" //input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");
        WebElement login= driver.findElement(By.xpath(" //input[@type='submit']"));
        login.click();
        BrowserUtils.verifyTitle(driver,"(1) Portal");

    }

@AfterMethod
    public void tearDownMethod(){
       driver.close();
}
}
/*
TC #3: Login scenario
1. Create new test and make set ups
2. Go to : http://login1.nextbasecrm.com/
3. Enter valid username
4. Enter valid password
5. Click to `Log In` button
6. Verify title is as expected:
Expected: Portal
USERNAME PASSWORD
helpdesk1@cybertekschool.com UserUser
Helpdesk2@cybertekschool.com UserUser
 */