package Practices;

import utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC1solveA {
    @BeforeClass
    public void Setup() {
        Driver.getDriver().get("http://automationexercise.com");
        Driver.getDriver().manage().window().maximize();
    }

    @Test
    public void homepage() {
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Automation Exercise";
        assert actualTitle.equals(expectedTitle);
        WebElement sign = Driver.getDriver().findElement(By.xpath("//a[@href='/login']"));
        sign.click();
        WebElement newuser = Driver.getDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
        newuser.isDisplayed();

        Faker faker = new Faker();
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@data-qa='signup-name']"));
        userName.click();
        userName.sendKeys(faker.name().username() + Keys.TAB + faker.internet().emailAddress() + Keys.ENTER);

        WebElement information = Driver.getDriver().findElement(By.xpath("//h2[@class='title text-center']/b"));
        information.isDisplayed();

        WebElement title = Driver.getDriver().findElement(By.xpath("//input[@type='radio']"));
        title.click();

        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        password.sendKeys(faker.internet().password());

        WebElement day = Driver.getDriver().findElement(By.xpath("//select[@id='days']/option [3] "));
        day.click();

        WebElement month = Driver.getDriver().findElement(By.xpath("//select[@id='months']/option [5]"));
        month.click();

        WebElement year = Driver.getDriver().findElement(By.xpath("//select[@id='years']/option [30]"));
        year.click();

        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@id='first_name']"));
        firstName.click();
        firstName.sendKeys(faker.name().firstName() + Keys.TAB + faker.name().firstName() + Keys.TAB + faker.company().name()
                + Keys.TAB + faker.address().fullAddress() + Keys.TAB + faker.address().secondaryAddress());

        WebElement country = Driver.getDriver().findElement(By.xpath("//select[@id='country']/option [6]"));
        country.click();

        WebElement state = Driver.getDriver().findElement(By.xpath("//input[@id='state']"));
        state.sendKeys(faker.address().state() + Keys.TAB + faker.address().city() + Keys.TAB +
                faker.address().zipCode() + Keys.TAB + faker.phoneNumber());

        WebElement accountButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        accountButton.click();

        WebElement accountCreated = Driver.getDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        accountCreated.isDisplayed();

        WebElement continueButton = Driver.getDriver().findElement(By.xpath("//a[@class='btn btn-primary']"));
        continueButton.click();

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@id='aswift_2']")));

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@id='ad_iframe']")));

        Driver.getDriver().findElement(By.xpath("//div[@id='dismiss-button']")).click();

        Driver.getDriver().switchTo().defaultContent();

       /*  WebElement informationAlertButton = Driver.getDriver().findElement(By.xpath("//*[@id=\"dismiss-button\"]"));


        informationAlertButton.click();
        Thread.sleep(1000);

*/


        WebElement logInAs = Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-user']"));
        logInAs.isDisplayed();

        WebElement deleteButton = Driver.getDriver().findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
        deleteButton.click();

        WebElement deleted = Driver.getDriver().findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        deleted.isDisplayed();

        WebElement continue2 = Driver.getDriver().findElement(By.xpath("//a[@data-qa='continue-button']"));
        continue2.click();
    }



}
/*
Test Case 1: Register User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
 */