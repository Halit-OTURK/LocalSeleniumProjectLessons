package com.cydeo.tests.day12_pom_design_explicit_wait;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LibraryLoginPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class POMPractices {

    LibraryLoginPage libraryLoginPage;

    @BeforeMethod

    public void setUpMethod() {
        Driver.getDriver().get("https://library1.cydeo.com/");
        libraryLoginPage = new LibraryLoginPage();
    }


    @Test
    public void Required_field_error_message_test() {
        //TC #1: Required field error message test
        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com/
        //3- Do not enter any information
        //4- Click to “Sign in” button

        libraryLoginPage.signInButton.click();

        //5- Verify expected error is displayed:
        //Expected: This field is required.
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());

        Driver.closeDriver();
    }

    @Test
    public void Invalid_email_format_error_message_test() {

        libraryLoginPage.inputUsername.sendKeys("invalidEmail");
        libraryLoginPage.signInButton.click();
        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());

        Driver.closeDriver();

    }

    @Test
    public void library_negative_login_test() {
        libraryLoginPage.inputUsername.sendKeys("abcde@qwert.com");
        libraryLoginPage.inputPassword.sendKeys("123456");
        libraryLoginPage.signInButton.click();
        BrowserUtils.sleep(3);
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());
        Driver.closeDriver();
    }

}
/* TC #1: Required field error message tes
        1- Open a Chrome browser
        2- Go to: https://library1.cydeo.com
        3- Do not enter any information
        4- Click to “Sign in” button
        5- Verify expected error is displayed:
        Expected: This field is require
        NOTE: FOLLOW POM DESIGN PATTERN
         */
/*
TC #2: Invalid email format error message test
1- Open a Chrome browser
2- Go to: https://library1.cydeo.com
3- Enter invalid email format
4- Verify expected error is displayed:
Expected: Please enter a valid email address.
NOTE: FOLLOW POM DESIGN PATTERN
 */

/*
TC #3: Library negative login
1- Open a Chrome browser
2- Go to: https://library1.cydeo.com
3- Enter incorrect username or incorrect password
4- Verify title expected error is displayed:
Expected: Sorry, Wrong Email or Password
NOTE: FOLLOW POM DESIGN PATTERN
 */