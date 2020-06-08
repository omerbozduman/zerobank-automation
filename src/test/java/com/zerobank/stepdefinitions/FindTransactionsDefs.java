package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;
import java.util.List;

public class FindTransactionsDefs {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Then("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        accountActivityPage.findTransactionsBtn.click();
        BrowserUtils.waitFor(2);
    }


    @Then("clicks search")
    public void clicks_search() {
       accountActivityPage.searchBtn.click();
       BrowserUtils.waitFor(1);
    }


    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        accountActivityPage.fromDateBox.clear();
        accountActivityPage.toDateBox.clear();
       accountActivityPage.fromDateBox.sendKeys(fromDate);
       accountActivityPage.toDateBox.sendKeys(toDate);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        BrowserUtils.waitFor(2);
        Assert.assertTrue("verify transactions dates between filter dates",accountActivityPage.verifyDate(fromDate,toDate));
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
       Assert.assertTrue("verify date sorted by most recent date",accountActivityPage.verifySortedRecentDate());
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String excludingDate) {

        Assert.assertTrue("verify date table should not contain 2012-09-01" ,accountActivityPage.verifyExcludingDate(excludingDate));

    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        accountActivityPage.findTransactionsDescriptionBox.clear();
        accountActivityPage.findTransactionsDescriptionBox.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
        Assert.assertTrue("verify table show only description",accountActivityPage.verifySearchWithDescription(description));

    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String description) {
        Assert.assertFalse("verify not show description on table",accountActivityPage.verifySearchWithDescription(description));
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        Assert.assertTrue("verify deposit transactions on results table",accountActivityPage.verifyDepositTransactions());
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        Assert.assertTrue("verify withdrawal transactions on results table",accountActivityPage.verifyWithdrawalTransactions());
    }

    @When("user selects type {string}")
    public void user_selects_type(String transactionsType) {
        accountActivityPage.selectTransactionsType(transactionsType);
        BrowserUtils.waitFor(2);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        Assert.assertTrue("verify withdrawal table is empty",accountActivityPage.verifyWithdrawalTransactionsIsEmpty());
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        Assert.assertTrue("verify deposit table is empty",accountActivityPage.verifyDepositTransactionsIsEmpty());
    }




}
