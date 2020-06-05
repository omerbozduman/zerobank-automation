package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityDefs {

    AccountActivity accountActivity = new AccountActivity();

    @Then("the user naavigate to {string} tab")
    public void the_user_naavigate_to_tab(String tab) {


        accountActivity.navigateToModule(tab);
    }

    @Then("the user should see default option {string} on dropdown")
    public void the_user_should_see_default_option_on_dropdown(String defaultOption) {
        Select dropdownOptions = new Select(accountActivity.accountOptions);
        Assert.assertEquals("Verify action dropdown first options",defaultOption,dropdownOptions.getFirstSelectedOption().getText());
    }

    @Then("the user should see following dropdown options")
    public void the_user_should_see_following_dropdown_options(List<String> dropdownList) {
       Select dropdownOptions = new Select(accountActivity.accountOptions);
       List<String> actulaOptions = BrowserUtils.getElementsText(dropdownOptions.getOptions());
       Assert.assertEquals("verify actions options",dropdownList,actulaOptions);

    }

    @Then("user should see following options on Transactions table")
    public void user_should_see_following_options_on_Transactions_table(List<String> transactionOptions) {

        BrowserUtils.waitFor(2);
        List<String> actualTransactionsOptions =BrowserUtils.getElementsText(accountActivity.transactionsTable);
        System.out.println(actualTransactionsOptions.get(1));
        Assert.assertEquals("verify transactions table options",transactionOptions,actualTransactionsOptions);

    }
}
