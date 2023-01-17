package com.cydeo.tests.Homework.week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class H4_Cydeo {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/inputs");
        WebElement homeLink=driver.findElement(By.className("nav-link"));
        homeLink.click();
        String expectedInTitle = "Practice";
        String actualTitle = driver.getTitle();
        if (actualTitle.startsWith(expectedInTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }
        driver.close();
    }
}
