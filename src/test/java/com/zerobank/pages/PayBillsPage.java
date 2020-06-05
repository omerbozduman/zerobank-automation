package com.zerobank.pages;


import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public String getAlertMessage(String element){

        String alertLocator ="sp_" + element;

        WebElement alert = Driver.get().findElement(By.id(alertLocator));

        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        Boolean is_valid = (Boolean)js.executeScript("return arguments[0].checkValidity();",alert );
        String alertMessage = (String)js.executeScript("return arguments[0].validationMessage;",alert );

        return alertMessage;
    }

}
