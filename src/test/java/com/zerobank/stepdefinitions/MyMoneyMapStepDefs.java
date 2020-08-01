package com.zerobank.stepdefinitions;

import com.zerobank.pages.MyMoneyMapPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class MyMoneyMapStepDefs {

    MyMoneyMapPage moneyMapPage = new MyMoneyMapPage();

    @Then("table should displays summaryrows")
    public void table_should_displays_summaryrows() {

        //moneyMapPage.totalInflow.isDisplayed();
        //moneyMapPage.totalOutflow.isDisplayed();
        //moneyMapPage.whatsleft.isDisplayed();

        BrowserUtils.waitFor(3);

        Assert.assertTrue( "total inflow is displayed",moneyMapPage.totalInflow.isDisplayed());
        Assert.assertTrue("total outflow is displayed",moneyMapPage.totalOutflow.isDisplayed());
        Assert.assertTrue("whatsleft is displayed",moneyMapPage.whatsleft.isDisplayed());

    }

    @Then("system should compare infos between {string} and {string}")
    public void system_should_compare_infos_between_and(String totalDatas, String tablesDatas ) {
        String totalDataspath = "//div[contains(text(),'"+totalDatas+"')]/../../td[2]";
        String tablesDataspath = "(//div[contains(text(),'"+tablesDatas+"')]/../../../../tr[4]//b)[2]";
        ///tr/td/div/b[contains(text(),'$')]  bu metodla da denenecek
        // WebElementle olustur, get et

        BrowserUtils.waitFor(3);
        Assert.assertEquals(Driver.get().findElement(By.xpath(totalDataspath)).getText(),Driver.get().findElement(By.xpath(tablesDataspath)).getText());

    }

    @Then("verify {string} amount is correct")
    public void verify_amount_is_correct(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
