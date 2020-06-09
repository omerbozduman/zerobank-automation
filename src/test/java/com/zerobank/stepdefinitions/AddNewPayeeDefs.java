package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
       payBillsPage.addNewPayeeBtn.click();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> payeeInfo) {

        payBillsPage.createNewPayee(payeeInfo);

    }
    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals("verify add new payee",expectedMessage,payBillsPage.addNewPayeeSubmitMessage.getText());
    }

}
