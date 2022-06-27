package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SellTradePage {
    public SellTradePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".hHVkqZ")
    public WebElement getOffer;

    @FindBy(css = ".dJRkut")
    public WebElement pickCarText;

    @FindBy(xpath = "//button[@data-cv-test='VINToggle']")
    public WebElement vinButton;

    @FindBy(xpath = "//input[@aria-labelledby='VIN']")
    public WebElement vinInputBox;

    @FindBy(xpath = "//button[@data-cv-test='heroGetMyOfferButton']")
    public WebElement getMyOfferButton;

    @FindBy(xpath = "//div[@class='sc-ckTRkR sc-fXazxj sc-fTFLOO gCHypS geDMnu kjoUgV']")
    public WebElement couldNotFindText;
}
