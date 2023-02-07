package com.cydeo.tests.day13_review_and_practices;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DoubleClick;
import utilities.Driver;

public class T1_DoubleClick {

    @Test
    public void t1_double_click_test(){
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        Driver.getDriver().switchTo().frame("iframeResult");
        DoubleClick doubleClick = new DoubleClick();
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(doubleClick.textToDoubleClick).perform();
        Assert.assertTrue(doubleClick.textToDoubleClick.getAttribute("style").contains("red"));
/*
String actualStyleAttributeValue = doubleClickPage.textToDoubleClick.getAttribute("style");
        String expectedInStyleAttribute = "red";

        Assert.assertTrue(actualStyleAttributeValue.contains(expectedInStyleAttribute));

 */

     //   Driver.getDriver().switchTo().defaultContent(); => optional
         Driver.closeDriver();
    }
}
/* TC #1: Double Click Test
        1. Go to
        https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        2. Switch to iframe.
        3. Double-click on the text “Double-click me to change my text color.”
        4. Assert: Text’s “style” attribute value contains “red”.
        NOTE: FOLLOW POM

 */