package com.cydeo.tests.Homework.week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class H5_Facebook1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");
        String expectedTitle="Facebook - Log In or Sign Up";
        String getTitle=driver.getTitle();

        if (expectedTitle.equals(getTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }
        driver.close();


    }
}
