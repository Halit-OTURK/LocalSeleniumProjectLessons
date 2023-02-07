package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DynamicControlPages {

    public DynamicControlPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "form#checkbox-example > button")
    public WebElement removeButton;

    @FindBy(id = "loading")
    public WebElement loadingBar;

    @FindBy(css = "input[type='checkbox']")
    public WebElement checkbox;

    @FindBy(id="message")
    public WebElement message;

    @FindBy(xpath = "//button[.='Enable']")
    public WebElement enableButton;

    @FindBy(css = "input[type='text']")
    public WebElement inputBox;


}
/*
TC #2: Explicit wait practice
1- Open a Chrome browser
2- Go to: https://practice.cydeo.com/dynamic_controls
3- Click to “Remove” button
4- Wait until “loading bar disappears”
5- Verify:
a. Checkbox is not displayed
b. “It’s gone!” message is displayed.
NOTE: FOLLOW POM
 */