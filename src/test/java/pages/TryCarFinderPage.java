package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class TryCarFinderPage {
    public TryCarFinderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@data-qa='headline']")
    public WebElement importantText;

    @FindBy(xpath = "//div[@data-qa='sub-heading']")
    public WebElement orderText;
}
