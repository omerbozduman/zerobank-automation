package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountActivity extends BasePage{

    @FindBy(xpath = "//a[contains(text(),'Account Summary')]")
    public WebElement accountActivityTab;

    @FindBy(id = "aa_accountId")
    public WebElement accountOptions;

    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> transactionsTable;
}
