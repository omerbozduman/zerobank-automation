package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//td[2]")
    public List<WebElement> descriptionResultTable;

    @FindBy(xpath = "//div[@class='well']")
    public WebElement descriptionNoResult;

    @FindBy(id = "filtered_transactions_for_account")
    public WebElement descriptionTable;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//td[4]")
    public List<WebElement> withdrawalResultTable;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//td[3]")
    public List<WebElement> depositResultTable;

    @FindBy(id = "aa_type")
    public WebElement selectTypeBtn;

    @FindBy(xpath = "//a[contains(text(),'Add New Payee')]")
    public WebElement addNewPayeeBtn;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameBox;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddressBox;

    @FindBy(id = "np_new_payee_account")
    public WebElement newPayeeAccountBox;

    @FindBy(id = "np_new_payee_details")
    public WebElement newPayeeDetailsBox;

    @FindBy(id = "add_new_payee")
    public WebElement submitNewPayeeBtn;

    @FindBy(id = "alert_content")
    public WebElement submitMessage;

    @FindBy(xpath = "//a[contains(text(),'Purchase Foreign Currency')]")
    public WebElement purchaseForeignCurrencyBtn;

    @FindBy(xpath = "//select[@name='currency']")
    public WebElement currencyDropdownList;


    public void verifyCurrenciesList(List<String> currencyList){
        Select selectCurrency = new Select(currencyDropdownList);
        String expectedOption;
        String actualOption;
        for (String currency : currencyList) {
            expectedOption=currency;
            selectCurrency.selectByVisibleText(currency);
            actualOption=selectCurrency.getFirstSelectedOption().getText();
            Assert.assertEquals("verify selection",expectedOption,actualOption);
        }
    }

    public void selectTransactionsType(String transactionsType){
        Select selectType = new Select(selectTypeBtn);
        selectType.selectByVisibleText(transactionsType);
    }

    public boolean verifyDepositTransactions(){
        boolean flag = false;
        if(depositResultTable.size()>0){
            flag=true;
        }
        return flag;
    }
    public boolean verifyDepositTransactionsIsEmpty() {
        boolean flag = false;
        for (WebElement deposit : depositResultTable) {
            System.out.println("withdrawal = " + deposit.getText());
            if (deposit.getText().isEmpty()) {
                flag = true;
            }
        }
        return flag;
    }
    public boolean verifyWithdrawalTransactions(){
        boolean flag = false;
        if(withdrawalResultTable.size()>0){
            flag=true;
        }
        return flag;
    }
    public boolean verifyWithdrawalTransactionsIsEmpty(){
        boolean flag = false;
        for (WebElement withdrawal : withdrawalResultTable) {
            System.out.println("withdrawal = " + withdrawal.getText());
            if(withdrawal.getText().isEmpty()){
                flag=true;
            }
        }
        return flag;
    }

    public List<Integer> getIntDateTable(){

        List<String> dates = BrowserUtils.getElementsText(dateResultTable);
        ArrayList<Integer> intDate = new ArrayList<>();
        System.out.println("dates = " + dates);
        for (String sdate : dates) {
            int date = Integer.valueOf(sdate.replace("-",""));
            System.out.println("date = " + date);
            intDate.add(date);
        }
        return intDate;
    }

    public boolean verifyDate(String fromDate , String toDate){

        int fDate = Integer.valueOf(fromDate.replace("-",""));
        int tDate = Integer.valueOf(toDate.replace("-",""));

        boolean flag = false;
        for (Integer date : getIntDateTable()) {
            if(date>=fDate && date<=tDate){
              flag = true;
            }
        }
        return flag;
    }

    public boolean verifySortedRecentDate(){
        List<Integer> sortedDate = getIntDateTable();

        int recentDate = sortedDate.get(0);
        boolean flag = false;
        for(int i=1; i<sortedDate.size(); i++){
            if(recentDate>sortedDate.get(i)){
                recentDate=sortedDate.get(i);
                flag=true;
            }
        }
        return flag;
    }

    public boolean verifyExcludingDate(String exDate){
        int excludingDate = Integer.valueOf(exDate.replace("-",""));

        boolean flag=true;
        for (Integer date : getIntDateTable()) {
            if(excludingDate==date){
                flag=false;
            }
        }
        return flag;
    }

    public boolean verifySearchWithDescription(String descript){

        List<String> descriptions = BrowserUtils.getElementsText(descriptionResultTable);
        int countDescription=0;
        boolean flag = false;
        for (String description : descriptions) {
            if(description.contains(descript)){
                countDescription++;
            }
        }
        if(!descriptionTable.getText().equals("No results.")) {
            if (countDescription == descriptions.size()) {
                flag = true;
            }
        }else if(!descriptionNoResult.getText().isEmpty()){
            flag=false;
        }

        return flag;
    }



    public void createNewPayee(Map<String,String> payeeInfo){

        BrowserUtils.waitFor(2);
        payeeNameBox.sendKeys(payeeInfo.get("Payee Name"));
        payeeAddressBox.sendKeys(payeeInfo.get("Payee Address"));
        newPayeeAccountBox.sendKeys(payeeInfo.get("Account"));
        newPayeeDetailsBox.sendKeys(payeeInfo.get("Payee details"));
        submitNewPayeeBtn.click();

    }


}
