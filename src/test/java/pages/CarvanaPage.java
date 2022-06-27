package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaPage {
    public CarvanaPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/help-me-search']")
    public WebElement carFinderLink;

    @FindBy(xpath = "//a[@href='/sell-my-car']")
    public WebElement sellTradeLink;

    @FindBy(xpath = "//a[@class='MenuButton__MenuButtonWrapper-dq0g44-0 imLDTG']")
    public WebElement financingLink;

    @FindBy(css = "a[data-cv-test='headerFinanceLoanCalc']")
    public WebElement calculatorLink;


}