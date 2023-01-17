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

public class Dropdowns_Practices {

    WebDriver driver;

    @BeforeMethod

    public void SetupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test

    public void dropdown_task5() throws InterruptedException {

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);
        String exceptingOptionText = "California";
        String actualOptionText = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOptionText, exceptingOptionText);
    }

    @Test

    public void dropdown_task6() throws InterruptedException {
        Select dropdownYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Thread.sleep(1000);
        // dropdownYear.selectByVisibleText("1923");
        dropdownYear.selectByVisibleText("1924");

        Select dropdownMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Thread.sleep(1000);
        dropdownMonth.selectByValue("11");

        Select dropdownDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        Thread.sleep(1000);
        dropdownDay.selectByIndex(0);

        String expectedYear = "1924";
        String expectedMonth = "December";
        String expectedDay = "1";

        String actualdropdownYear = dropdownYear.getFirstSelectedOption().getText();
        String actualdropdownMonth = dropdownMonth.getFirstSelectedOption().getText();
        String actualdropdownDay = dropdownDay.getFirstSelectedOption().getText();


        Assert.assertEquals(actualdropdownYear, expectedYear);
        Assert.assertEquals(actualdropdownMonth, expectedMonth);
        Assert.assertEquals(actualdropdownDay, expectedDay);
    }

    @AfterMethod

    public void tearDownMethod() {
        driver.close();
    }


}
/*
TC #5: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
 */
/*
TC #6: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1923” and verify it is selected.
Select year using : visible text
Select month using : value attribute
Select day using : index number
 */