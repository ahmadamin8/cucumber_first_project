package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CalculatorPage {
    public CalculatorPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='vehiclePrice']")
    public WebElement costOfCarBox;

    @FindBy(id = "creditBlock")
    public WebElement creditScoreBox;

    @FindBy(xpath = "//select[@name='loanTerm']")
    public WebElement loanTermBox;

    @FindBy(xpath = "//input[@name='downPayment']")
    public WebElement downPaymentBox;

    @FindBy(css = "div[class*='is-monthly-display']")
    public WebElement monthlyText;
}
