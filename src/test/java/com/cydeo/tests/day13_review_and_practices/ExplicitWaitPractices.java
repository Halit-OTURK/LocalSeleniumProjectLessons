package com.cydeo.tests.day13_review_and_practices;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicControlPages;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitPractices {

    DynamicControlPages dynamicControlPages;

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlPages = new DynamicControlPages();
    }

    @Test
    public void Explicit_wait_practice_test() {
        /*
TC #2: Explicit wait practice
1- Open a Chrome browser
2- Go to: https://practice.cydeo.com/dynamic_controls
3- Click to “Remove” button
4- Wait until “loading bar disappears”
5- Verify:
a. Checkbox is not displayed
b. “It’s gone!” message is displayed.
NOTE: FOLLOW POM
 */

        dynamicControlPages.removeButton.click();
        //4- Wait until “loading bar disappears”
//        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));
// when we use implicit wait and explicit wait same time its gone be confused.
// Gurhan solve this problem with that code part. important point is first implicit wait value is 0.
// after the run code rewrite again the implicit wait value is 10 seconds.

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlPages.loadingBar));


        // BrowserUtils.waitForInvisibilityOf(dynamicControlPages.loadingBar);

        // Assert.assertFalse(dynamicControlPages.checkbox.isDisplayed()); if we use this code .
        // result return us as false and the test get failed and exit the test.
        // because of that we have to use try/catch block.


         try {
            //assertFalse method will pass the test if the boolean value returned is: false
            Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            Assert.assertTrue(!dynamicControlPages.checkbox.isDisplayed());
            Assert.assertFalse(dynamicControlPages.checkbox.isDisplayed());
        }catch (NoSuchElementException n){
            Assert.assertTrue(true);
        }

        Assert.assertTrue(dynamicControlPages.message.isDisplayed());
        Assert.assertTrue(dynamicControlPages.message.getText().equals("It's gone!"));

    }

@Test
public void Explicit_wait_practice_test2() {

/*
TC #3: Explicit wait practice
1- Open a Chrome browser
2- Go to: https://practice.cydeo.com/dynamic_controls
3- Click to “Enable” button
4- Wait until “loading bar disappears”
5- Verify:
a. Input box is enabled.
b. “It’s enabled!” message is displayed.
NOTE: FOLLOW POM
 */

    dynamicControlPages.enableButton.click();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    wait.until(ExpectedConditions.invisibilityOf(dynamicControlPages.loadingBar));
    Assert.assertTrue(dynamicControlPages.inputBox.isEnabled());
    Assert.assertTrue(dynamicControlPages.message.isDisplayed());
    Assert.assertTrue(dynamicControlPages.message.getText().equals("It's enabled!"));

    //Calling our ExplicitWait utility method to wait loadingBar to disappear
    // BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);
}

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

}

