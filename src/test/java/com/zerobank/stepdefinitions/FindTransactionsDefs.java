package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
    }


    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
       accountActivityPage.fromDateBox.sendKeys(fromDate);
       accountActivityPage.toDateBox.sendKeys(toDate);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        BrowserUtils.waitFor(2);
       accountActivityPage.verifyDate(fromDate,toDate);
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




}
