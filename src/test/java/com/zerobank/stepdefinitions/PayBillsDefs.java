package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class PayBillsDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Then("the user select the Payee")
    public void the_user_select_the_Payee() {
        Select payee = new Select(payBillsPage.selectPayee);
        payee.selectByVisibleText("Bank of America");

    }

    @Then("the user select the account")
    public void the_user_select_the_account() {
        Select account = new Select(payBillsPage.selectAccount);
        account.selectByVisibleText("Credit Card");
    }

    @Then("the user enter the Amount")
    public void the_user_enter_the_Amount() {
       payBillsPage.amountBox.sendKeys("10000");
    }

    @Then("the user enter the Date")
    public void the_user_enter_the_Date() {
        payBillsPage.dateBox.sendKeys("2020-06-15");

    }

    @Then("enter the Description")
    public void enter_the_Description() {
       payBillsPage.descriptionBox.sendKeys("Payment for electricity bill");
    }

    @Then("enter pay button for payment")
    public void enter_pay_button_for_payment() {
       payBillsPage.payBtn.click();
    }

    @Then("verify {string} message display")
    public void verify_message_display(String expectedMessage) {
        Assert.assertEquals("verify payment submit message",expectedMessage,payBillsPage.paymentSubmitMessage.getText());

    }

    @Then("the user enter the Amount as alphabetical characters")
    public void the_user_enter_the_Amount_as_alphabetical_characters() {
       payBillsPage.amountBox.sendKeys("twentythousand");
    }

    @Then("the user enter the Amount as special characters")
    public void the_user_enter_the_Amount_as_special_characters() {
        payBillsPage.amountBox.sendKeys("£@$#%&^*()_");
    }
    @Then("verify for {string} {string} alert message display")
    public void verify_for_alert_message_display(String element, String expectedMessage) {
        BrowserUtils.waitFor(2);

        String actualMessage = payBillsPage.getAlertMessage(element);
        Assert.assertEquals("verify aalert message",expectedMessage,actualMessage);

    }


    @Then("the user enter the Date as alphabetical characters")
    public void the_user_enter_the_Date_as_alphabetical_characters() {
        payBillsPage.dateBox.sendKeys("twentytwenty-six=fifteen");
    }
}
