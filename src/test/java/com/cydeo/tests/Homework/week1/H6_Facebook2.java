package com.cydeo.tests.Homework.week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class H6_Facebook2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        WebElement userName=driver.findElement(By.name("email"));
        userName.sendKeys("lskfdjglkdfjglkdfj");

        WebElement Password=driver.findElement(By.name("pass"));

        Password.sendKeys("lskfdjglkdfjglkdfj"+ Keys.ENTER);

        String title= driver.getTitle();

        String expectedTitlePass="Log into Facebook";

        if (expectedTitlePass.equals(title)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }
        driver.close();


    }
}
