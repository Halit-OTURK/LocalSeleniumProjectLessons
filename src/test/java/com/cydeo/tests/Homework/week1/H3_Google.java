package com.cydeo.tests.Homework.week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class H3_Google {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");
        WebElement gmailClick=driver.findElement(By.className("gb_j"));
        gmailClick.click();

        String expectedInTitle = "Gmail";
        String actualTitle = driver.getTitle();



        if (actualTitle.startsWith(expectedInTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }
        driver.navigate().back();
        String expectedInTitle2 = "Google";
        String actualTitle2= driver.getTitle();

        if (actualTitle2.startsWith(expectedInTitle2)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }


        driver.close();
    }
}
