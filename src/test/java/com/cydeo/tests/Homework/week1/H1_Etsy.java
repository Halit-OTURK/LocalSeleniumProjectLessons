package com.cydeo.tests.Homework.week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class H1_Etsy {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com");
        WebElement searchpart=driver.findElement(By.id("global-enhancements-search-query"));
        searchpart.sendKeys("wooden spoon"+ Keys.ENTER);


        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }


        String expectedTitle2 = "Wooden spoon - Etsy";
        String actualTitle2 = driver.getTitle();

        if (actualTitle2.equals(expectedTitle2)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }

        driver.close();
    }
}
