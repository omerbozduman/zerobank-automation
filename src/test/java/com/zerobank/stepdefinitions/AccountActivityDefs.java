package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityDefs {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Then("the user navigate to {string} tab")
    public void the_user_navigate_to_tab(String tab) {
        accountActivityPage.navigateToModule(tab);
    }

    @Then("the user should see following dropdown options")
    public void the_user_should_see_following_dropdown_options(List<String> dropdownList) {
       Select dropdownOptions = new Select(accountActivityPage.accountOptions);
       List<String> actulaOptions = BrowserUtils.getElementsText(dropdownOptions.getOptions());
       Assert.assertEquals("verify actions options",dropdownList,actulaOptions);

    }

    @Then("user should see following options on Transactions table")
    public void user_should_see_following_options_on_Transactions_table(List<String> transactionOptions) {

        BrowserUtils.waitFor(2);
        List<String> actualTransactionsOptions =BrowserUtils.getElementsText(accountActivityPage.transactionsTable);
        System.out.println(actualTransactionsOptions.get(1));
        Assert.assertEquals("verify transactions table options",transactionOptions,actualTransactionsOptions);

    }
}
