package com.zerobank.pages;


import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class PayBillsPage extends BasePage {

    @FindBy(id = "sp_payee")
    public WebElement selectPayee;

    @FindBy(id = "sp_account")
    public WebElement selectAccount;

    @FindBy(id = "sp_amount")
    public WebElement amountBox;

    @FindBy(id = "sp_date")
    public WebElement dateBox;

    @FindBy(id = "sp_description")
    public WebElement descriptionBox;

    @FindBy(id = "pay_saved_payees")
    public WebElement payBtn;

    @FindBy(xpath = "//span[contains(text(),'successfully')]")
    public WebElement paymentSubmitMessage;

    @FindBy(xpath = "//a[contains(text(),'Add New Payee')]")
    public WebElement addNewPayeeBtn;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameBox;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddressBox;

    @FindBy(id = "np_new_payee_account")
    public WebElement newPayeeAccountBox;

    @FindBy(id = "np_new_payee_details")
    public WebElement newPayeeDetailsBox;

    @FindBy(id = "add_new_payee")
    public WebElement submitNewPayeeBtn;

    @FindBy(id = "alert_content")
    public WebElement addNewPayeeSubmitMessage;


    @FindBy(xpath = "//a[contains(text(),'Purchase Foreign Currency')]")
    public WebElement purchaseForeignCurrencyBtn;

    @FindBy(xpath = "//select[@name='currency']")
    public WebElement currencyDropdownList;

    @FindBy(id = "pc_amount")
    public WebElement purchaseAmountBox;

    @FindBy(id = "pc_inDollars_true")
    public WebElement dolarCheckbox;

    @FindBy(id = "purchase_cash")
    public WebElement purchaseSubmitBtn;


    public void verifyCurrenciesList(List<String> currencyList){
        Select selectCurrency = new Select(currencyDropdownList);
        String expectedOption;
        String actualOption;
        for (String currency : currencyList) {
            expectedOption=currency;
            selectCurrency.selectByVisibleText(currency);
            actualOption=selectCurrency.getFirstSelectedOption().getText();
            Assert.assertEquals("verify selection",expectedOption,actualOption);
        }
    }

    public String getAlertMessage(String element){

        String alertLocator ="sp_" + element;

        WebElement alert = Driver.get().findElement(By.id(alertLocator));

        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        Boolean is_valid = (Boolean)js.executeScript("return arguments[0].checkValidity();",alert );
        String alertMessage = (String)js.executeScript("return arguments[0].validationMessage;",alert );

        return alertMessage;
    }
    public void createNewPayee(Map<String,String> payeeInfo){

        BrowserUtils.waitFor(2);
        payeeNameBox.sendKeys(payeeInfo.get("Payee Name"));
        payeeAddressBox.sendKeys(payeeInfo.get("Payee Address"));
        newPayeeAccountBox.sendKeys(payeeInfo.get("Account"));
        newPayeeDetailsBox.sendKeys(payeeInfo.get("Payee details"));
        submitNewPayeeBtn.click();

    }

    public void setPurchaseWithoutCurrency(){

        Select currency = new Select(currencyDropdownList);
        currency.selectByVisibleText("Select One");
        purchaseAmountBox.sendKeys("1000");
        dolarCheckbox.click();
        BrowserUtils.waitFor(2);
        purchaseSubmitBtn.click();
        BrowserUtils.waitFor(2);
    }

    public boolean getErrorMessage(){
        Alert alert = Driver.get().switchTo().alert();
        String errorMessage =alert.getText();
        alert.accept();
        boolean flag = false;
        if(!errorMessage.isEmpty()){
            flag=true;
        }
        return flag;
    }

    public void setPurchaseWithoutAmount() {

        Select currency = new Select(currencyDropdownList);
        currency.selectByVisibleText("Canada (dollar)");
        BrowserUtils.waitFor(2);
        purchaseSubmitBtn.click();
        BrowserUtils.waitFor(2);
    }

}
