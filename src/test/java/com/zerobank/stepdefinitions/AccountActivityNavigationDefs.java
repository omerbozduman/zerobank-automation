package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavigationDefs {


    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String activity) {
        accountSummaryPage.clickActivityLink(activity);



    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String selectedOption) {
        Select dropdownOptions = new Select(accountActivityPage.accountOptions);
        Assert.assertEquals("Verify action dropdown selected options",selectedOption,dropdownOptions.getFirstSelectedOption().getText());


    }

}
