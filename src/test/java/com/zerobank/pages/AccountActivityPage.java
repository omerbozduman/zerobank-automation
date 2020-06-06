package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en_lol.WEN;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(xpath = "//a[contains(text(),'Account Summary')]")
    public WebElement accountActivityTab;

    @FindBy(id = "aa_accountId")
    public WebElement accountOptions;

    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> transactionsTable;

    @FindBy(xpath = "//a[contains(text(),'Find Transactions')]")
    public WebElement findTransactionsBtn;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDateBox;

    @FindBy(id = "aa_toDate")
    public WebElement toDateBox;

    @FindBy(id = "aa_description")
    public WebElement findTransactionsDescriptionBox;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//td[1]")
    public List<WebElement> dateResultTable;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchBtn;

    public void verifyDate(String fromDate , String toDate){

        List<String> dates = BrowserUtils.getElementsText(dateResultTable);

        System.out.println("dates = " + dates);
        System.out.println("fromDate = " + fromDate);
    }

}
