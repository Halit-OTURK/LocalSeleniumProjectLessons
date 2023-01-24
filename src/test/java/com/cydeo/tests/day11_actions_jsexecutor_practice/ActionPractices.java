package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionPractices {
    @Test
    public void task_4_5_test(){
        Driver.getDriver().get("https://practice.cydeo.com/");
        Actions actions=new Actions(Driver.getDriver());

        WebElement element=Driver.getDriver().findElement(By.linkText("CYDEO"));
        actions.moveToElement(element).pause(2000).perform();
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_DOWN,Keys.PAGE_UP).pause(2000).perform();
        Driver.closeDriver();

    }

    @Test
    public void test2(){
        Driver.getDriver().get("https://practice.cydeo.com/");
        Driver.closeDriver();
    }

    @Test
    public void test3(){
        Driver.getDriver().get("https://practice.cydeo.com/");
        Driver.closeDriver();
    }
}
//TC #4: Scroll practice
//1- Open a Chrome browser
//2- Go to: https://practice.cydeo.com/
//3- Scroll down to “Powered by CYDEO”
//4- Scroll using Actions class “moveTo(element)” method
//TC #5: Scroll practice 2
//1- Continue from where the Task 4 is left in the same test.
//2- Scroll back up to “Home” link using PageUP button