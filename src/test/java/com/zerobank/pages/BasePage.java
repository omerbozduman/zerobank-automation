package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    //a[contains(text(),'Account Summary')]

    public void navigateToModule(String tab){
        String tabLocator = "//a[contains(text(),'"+tab+"')]";
        WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
        tabElement.click();

    }
}
