package com.cydeo.tests.day12_pom_design_explicit_wait;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoad1Page;
import pages.DynamicLoad7Page;
import utilities.Driver;

public class WebDriveWaitPractices {

    @Test(priority = 1)
    public void Dynamically_Loaded_Page_Elements_7_Test() {

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleIs("Dynamic title"));
        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();
        Assert.assertTrue(dynamicLoad7Page.doneMessage.isDisplayed());
        Assert.assertTrue(dynamicLoad7Page.spongeBobImage.isDisplayed());

        Driver.closeDriver();

    }

    /*
TC#4 : Dynamically Loaded Page Elements 7
1. Go to https://practice.cydeo.com/dynamic_loading/7
2. Wait until title is “Dynamic title”
3. Assert: Message “Done” is displayed.
4. Assert: Image is displayed.
Note: Follow POM
 */
    @Test(priority = 2)
    public void Dynamically_Loaded_Page_Elements_1_Test() {
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");
        DynamicLoad1Page dynamicLoad1Page = new DynamicLoad1Page();

        dynamicLoad1Page.startButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad1Page.loadingBar));
        Assert.assertTrue(dynamicLoad1Page.inputUsername.isDisplayed());
        dynamicLoad1Page.inputUsername.sendKeys("tomsmith");
        dynamicLoad1Page.inputPassword.sendKeys("incorrectpassword");
        dynamicLoad1Page.submitButton.click();
        Assert.assertTrue(dynamicLoad1Page.errorMessage.isDisplayed());
        Driver.closeDriver();
    }
}


/*
TC#5 : Dynamically Loaded Page Elements 1
1. Go to https://practice.cydeo.com/dynamic_loading/1
2. Click to start
3. Wait until loading bar disappears
4. Assert username inputbox is displayed
5. Enter username: tomsmith
6. Enter password: incorrectpassword
7. Click to Submit button
8. Assert “Your password is invalid!” text is displayed.
Note: Follow POM Design Pattern
 */