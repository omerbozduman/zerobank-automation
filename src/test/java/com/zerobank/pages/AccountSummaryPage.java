package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
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

    public void clickActivityLink(String activity){
        String activityLinkLocator = "//tbody/tr/td/a[contains(text(),'"+ activity +"')]";

        WebElement activityLink = Driver.get().findElement(By.xpath(activityLinkLocator));
        activityLink.click();
    }



}
