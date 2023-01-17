package com.cydeo.tests.Homework.week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class H2_Bank {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().fullscreen();

        driver.get("http://zero.webappsecurity.com/login.html");
        WebElement headerText=driver.findElement(By.tagName("h3"));

        String expectedHeaderText = "Log in to ZeroBank";
        String actualHeaderText = headerText.getText(); // will return "Registration form" as String

        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header text verification PASSED!");
        }else{
            System.out.println("Header text verification FAILED!!!");
        }
        driver.close();

    }
}
