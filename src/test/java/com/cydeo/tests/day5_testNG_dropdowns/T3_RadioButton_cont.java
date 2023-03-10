package com.cydeo.tests.day5_testNG_dropdowns;


import utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T3_RadioButton_cont {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/radio_buttons");
        // WebElement hockeyButton=driver.findElement(By.xpath("//input[@id='hockey']"));

        clickAndVerifyRadioButton(driver, "sport", "hockey" );

        clickAndVerifyRadioButton(driver, "sport", "football");

        clickAndVerifyRadioButton(driver, "color", "yellow");


        driver.close();
    }


    private static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String idValue) {

        List<WebElement> radioButton = driver.findElements(By.name(nameAttribute));

        for (WebElement each : radioButton) {

            String eachId = each.getAttribute("id");
            if (eachId.equals(idValue)) {
                each.click();
                System.out.println(eachId + " is selected : " + each.isSelected());
                break;

            }

        }
    }
}
