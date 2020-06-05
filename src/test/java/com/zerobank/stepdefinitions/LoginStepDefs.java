package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @Given("the user is on the Home Page")
    public void the_user_is_on_the_Home_Page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user navigate to Login Page")
    public void the_user_navigate_to_Login_Page() {
        loginPage.navigateToLoginPage();

    }

    @Then("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {

        String actualTitle = Driver.get().getTitle();
        String expectedTitle ="Zero - Account Summary";
        Assert.assertEquals("Verify Title",expectedTitle,actualTitle);
    }

    @Then("Account Summary page should be displayed")
    public void account_Summary_page_should_be_displayed() {
        Assert.assertTrue(Driver.get().getTitle().contains("Account Summary"));
        Assert.assertEquals("verify Account summary page","Account Summary",accountSummaryPage.accountSummaryTab.getText());
    }

    @Then("the user enter the wrong username, valid password")
    public void the_user_enter_the_wrong_username_valid_password() {
        loginPage.login(ConfigurationReader.get("invalid_username"),ConfigurationReader.get("password"));

    }

    @Then("the user should not be able to login")
    public void the_user_should_not_be_able_to_login() {
        String actualTitle = Driver.get().getTitle();
        String expectedTitle ="Zero - Account Summary";
        Assert.assertNotEquals("Verify Title",expectedTitle,actualTitle);


    }

    @Then("message should be displayed {string}")
    public void message_should_be_displayed(String expected) {
        Assert.assertEquals(expected,loginPage.errorMessage.getText());
        BrowserUtils.waitFor(2);
        Assert.assertTrue(loginPage.errorMessage.getText().contains(expected));
    }

    @Then("the user enter the valid username, wrong password")
    public void the_user_enter_the_valid_username_wrong_password() {
        loginPage.login(ConfigurationReader.get("username"),ConfigurationReader.get("invalid_password"));
    }




}
