package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.ActionsUtil;
import utils.Driver;
import utils.DropdownHandler;
import utils.Waiter;

public class CarvanaSteps {
    WebDriver driver;
    CarvanaPage carvanaPage;
    CarFinderPage carFinderPage;
    TryCarFinderPage tryCarFinderPage;
    CalculatorPage calculatorPage;
    SellTradePage sellTradePage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        carvanaPage = new CarvanaPage();
        carFinderPage = new CarFinderPage();
        tryCarFinderPage = new TryCarFinderPage();
        calculatorPage = new CalculatorPage();
        sellTradePage = new SellTradePage();
    }
    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String link) {
        switch (link){
            case "CAR FINDER":
                carvanaPage.carFinderLink.click();
                break;
            case "SELL/TRADE":
                carvanaPage.sellTradeLink.click();
                break;
            case "AUTO LOAN CALCULATOR":
                carvanaPage.calculatorLink.click();
                break;
        }
    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String URL) {
        switch (URL) {
            case "https://www.carvana.com/help-me-search/":
            case "https://www.carvana.com/help-me-search/qa":
            case "https://www.carvana.com/sell-my-car":
                Assert.assertEquals(URL, driver.getCurrentUrl());
                break;
        }
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String text) {
        switch (text) {
            case "https://www.carvana.com/help-me-search/":
                Waiter.pause(2);
                Assert.assertTrue(carFinderPage.h1Text.isDisplayed());
                Assert.assertTrue(carFinderPage.h3Text.isDisplayed());
                Assert.assertEquals(text, carFinderPage.h1Text.getText());
                Assert.assertEquals(text, carFinderPage.h3Text.getText());
                break;
            case "https://www.carvana.com/help-me-search/qa":
                Waiter.pause(2);
                Assert.assertTrue(tryCarFinderPage.importantText.isDisplayed());
                Assert.assertTrue(tryCarFinderPage.orderText.isDisplayed());
                Assert.assertEquals(text,tryCarFinderPage.importantText.getText());
                Assert.assertEquals(text,tryCarFinderPage.orderText.getText());
            case "https://www.carvana.com/sell-my-car":
                Waiter.pause(2);
                Assert.assertTrue(sellTradePage.getMyOfferButton.isDisplayed());
                Assert.assertTrue(sellTradePage.pickCarText.isDisplayed());
                Assert.assertEquals(text,sellTradePage.getMyOfferButton.getText());
                Assert.assertEquals(text,sellTradePage.pickCarText.getText());
                break;
        }
    }

    @And("user should see {string} link")
    public void userShouldSeeLink(String link) {
        Assert.assertTrue(carFinderPage.tryCarFinderLink.isDisplayed());

    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String link) {
        if("TRY CAR FINDER".equals(link)){
            carFinderPage.tryCarFinderLink.click();
        }
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) {
        switch (button){
            case "VIN":
                sellTradePage.vinButton.click();
                break;
            case "GET MY OFFER":
                sellTradePage.getMyOfferButton.click();
                break;
        }
    }

    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String vin) {
        sellTradePage.vinInputBox.sendKeys(vin);
    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String button) {
        Assert.assertEquals(button,carvanaPage.financingLink.getText());
        Waiter.pause(3);
        ActionsUtil.moveToElement(carvanaPage.financingLink);

    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String costText, String overallCost) {
        switch (costText){
            case "Cost of Car I want":
                Assert.assertTrue(costText,calculatorPage.costOfCarBox.isDisplayed());
                calculatorPage.costOfCarBox.sendKeys(overallCost);
                break;
            case "What is Your Down Payment?":
                calculatorPage.downPaymentBox.sendKeys(overallCost);
                break;
        }
    }

    @And("user selects {string} as {string}")
    public void userSelectsAs(String creditScoreText, String overallScore) {
        switch (creditScoreText){
            case "What's Your Credit Score?":
                DropdownHandler.selectOptionByIndex(calculatorPage.creditScoreBox,0);
                break;
            case "Choose Your Loan Terms":
                Waiter.pause(3);
                DropdownHandler.selectOptionByIndex(calculatorPage.loanTermBox,1);
                break;
        }
    }

    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String monthlyPayment) {
        Assert.assertTrue(calculatorPage.monthlyText.isDisplayed());
        Assert.assertEquals(monthlyPayment,calculatorPage.monthlyText.getText());
    }
}
