package com.zerobank.stepdefinitions;


import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class PurchaseForeignCurrencyDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Then("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        payBillsPage.purchaseForeignCurrencyBtn.click();
        BrowserUtils.waitFor(3);
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencyTable) {

        payBillsPage.verifyCurrenciesList(currencyTable);

    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        payBillsPage.setPurchaseWithoutCurrency();

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertTrue("verify error message",payBillsPage.getErrorMessage());
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        payBillsPage.setPurchaseWithoutAmount();

    }
}
