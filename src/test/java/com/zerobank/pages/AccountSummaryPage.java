package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Account Summary')]")
    public WebElement accountSummaryTab;

    @FindBy(css = ".board-header")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "(//h2[@class='board-header'])[1]")
    public WebElement accountType;

    @FindBy(xpath = "(//thead)[3]/tr/th")
    public List<WebElement> creditCardsOptions;



}
