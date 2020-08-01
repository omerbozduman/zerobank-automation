package com.zerobank.pages;


import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GooglePage {

    public GooglePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(name = "q")
    public WebElement searchBox;

    @FindBy(id = "result-stats")
    public WebElement results;

    @FindBy(xpath = "//div[@id='srp-results-header-main']//h1[@class='h1-responsive srp-desktop-title']")
    public WebElement numberofCars;

    @FindBy(xpath = "//button[contains(text(),'I Accept')]")
    public WebElement acceptBtn;
//
//    @FindBy(xpath = "//div[@class='TbwUpd NJjxre']/cite[contains(text(),'.co')]")
//    public List<WebElement> links;
//
//    @FindBy(xpath = "//div[@class='TbwUpd NJjxre']/cite[contains(text(),'gumtree')]")
//    public List<WebElement> gumtreeLinks;


    public void searchElement(String searchElement){
        searchBox.click();
        searchBox.sendKeys(searchElement, Keys.ENTER);
    }

    public String getResultOfSeaarch(){
        String result = results.getText();

        String[] searchResult = result.split(" ");

        return searchResult[1];

    }

//    public List<WebElement> getGumtreeLinks(){
//        System.out.println("links = " + links.size());
//       List<WebElement> gumtreeLinks = new ArrayList<>();
//        for (WebElement link : links) {
//            System.out.println("link.getText() = " + link.getText());
//            if(link.getText().contains("gumtree")){
//                gumtreeLinks.add(link);
//            }
//        }
//        return gumtreeLinks;
//    }



    public List<WebElement> gumtreeLinks;

    public List<WebElement> getGumtreeLinks(String link){
        String locator = "//div[@class='TbwUpd NJjxre']/cite[contains(text(),'"+ link + "')]";
         gumtreeLinks = Driver.get().findElements(By.xpath(locator));

         return gumtreeLinks;
    }

    public int getNumberOfCars()  {

        String number = numberofCars.getText();
        System.out.println("number = " + number);

        String[] num = number.split(" ");
        String num1 = num[0];
        System.out.println("num[0] = " + num[0]);
        int numCars = Integer.valueOf(num1.replace(",",""));
        System.out.println("numCars = " + numCars);
        return numCars;
    }

    public WebElement waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getTitle(){
        return Driver.get().getTitle();
    }
}
