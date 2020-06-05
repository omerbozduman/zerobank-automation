package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSummaryPage {

    @FindBy(xpath = "//a[contains(text(),'Account Summary')]")
    public WebElement accountSummaryTab;


}
