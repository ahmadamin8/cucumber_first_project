package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarFinderPage {
    public CarFinderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1")
    public WebElement h1Text;

    @FindBy(xpath = "//h3")
    public WebElement h3Text;

    @FindBy(xpath = "//a[@data-qa='router-link']")
    public WebElement tryCarFinderLink;


}
