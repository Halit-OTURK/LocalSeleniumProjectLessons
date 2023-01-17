package com.cydeo.tests.day5_testNG_dropdowns;


import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_Simple_Dropdowns {

    /*
 TC#4: Verifying “Simple dropdown” and “State selection” dropdown default values
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Verify “Simple dropdown” default selected value is correct
Expected: “Please select an option”
4. Verify “State selection” default selected value is correct
Expected: “Select a State”
     */
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void SimpleDropdownTest() {

        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();

        String actualSimpleDropdownText = currentlySelectedOption.getText();
        String expectedSimpleDropdownText = "Please select an option";

        Assert.assertEquals(actualSimpleDropdownText, expectedSimpleDropdownText);
    }

    @Test
    public void SimpleDropdown2(){
        Select simpleDropdown2 = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        WebElement currentlySelectedOption2 = simpleDropdown2.getFirstSelectedOption();

        String actualSimpleDropdownText = currentlySelectedOption2.getText();
        String expectedSimpleDropdownText =  "Select a State";

        Assert.assertEquals(actualSimpleDropdownText, expectedSimpleDropdownText);

    }


    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }


}
