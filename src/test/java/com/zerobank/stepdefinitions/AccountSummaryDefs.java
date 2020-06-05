package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryDefs {

    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @Then("the title should be {string}")
    public void the_title_should_be(String expected) {
        Assert.assertEquals(expected, Driver.get().getTitle());
    }

    @Then("the user should see following account types")
    public void the_user_should_see_following_account_types(List<String> accountList) {

        List<String> actualAccountList = BrowserUtils.getElementsText(accountSummaryPage.accountTypes);
        Assert.assertEquals(accountList,actualAccountList);
    }

    @Then("user should see following options under Credit Accounts")
    public void user_should_see_following_options_under_Credit_Accounts(List<String> creditAccountsOptions) {

        System.out.println("creditAccountsOptions = " + creditAccountsOptions);

        List<String> actualCreditCardOptions = BrowserUtils.getElementsText(accountSummaryPage.creditCardsOptions);
        Assert.assertEquals(creditAccountsOptions,actualCreditCardOptions);

    }



    }
