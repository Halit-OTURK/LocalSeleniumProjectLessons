package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DoubleClick {

    public DoubleClick () {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "demo")
    public WebElement textToDoubleClick;


}
