package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeDefs {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
       accountActivityPage.addNewPayeeBtn.click();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> payeeInfo) {

        accountActivityPage.createNewPayee(payeeInfo);

    }
    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals("verify add new payee",expectedMessage,accountActivityPage.submitMessage.getText());
    }

}
