package com.zerobank.stepdefinitions;

import com.zerobank.pages.GooglePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GoogleStepDefs {

    GooglePage googlePage = new GooglePage();

    @Given("the user is on the Google")
    public void the_user_is_on_the_Google() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

    }

    @When("the user search {string}")
    public void the_user_search(String searchElement) {

        googlePage.searchElement(searchElement);

    }

    @Then("displayed the result")
    public void displayed_the_result() {
        Assert.assertTrue(googlePage.results.isDisplayed());
        System.out.println("googlePage.results.getText() = " + googlePage.results.getText());
        System.out.println("googlePage.getResultOfSeaarch() = " + googlePage.getResultOfSeaarch());
    }

//    @Then("verify the available Gumtree Links number")
//    public void verify_the_available_Gumtree_Links_number()  {
//        System.out.println("googlePage.getGumtreeLinks().size() = " + googlePage.getGumtreeLinks().size());
//    }

    @And("verify the available {string} Links number")
    public void verifyTheAvailableLinksNumber(String link) {

        System.out.println("number of gumtree links = " + googlePage.getGumtreeLinks(link).size());

    }

    List<String> titles = new ArrayList<>();
    List<Integer> numss  = new ArrayList<>();
    @Then("navigate to each Gumtree Link")
    public void navigate_to_each_Gumtree_Link() throws InterruptedException {

            for(WebElement gumtreeLink : googlePage.gumtreeLinks){

                gumtreeLink.click();
                googlePage.acceptBtn.click();
                googlePage.waitForVisibility(googlePage.numberofCars);

               String title = googlePage.getTitle();
               System.out.println("title = " + title);
               titles.add(title);
               Integer numCarr = googlePage.getNumberOfCars();
               numss.add(numCarr);

                Driver.get().navigate().back();

            }

        }


    @Then("verify the title is displayed")
    public void verify_the_title_is_displayed() {
        for (String title : titles) {
            Assert.assertFalse(title.isEmpty());
            System.out.println("title = " + title);
        }

    }


    @Then("verify the number of cars grater the {int}")
    public void verifyTheNumberOfCarsGraterThe(int number)  {

        for (int num : numss) {

            Assert.assertTrue(num>number);
        }

    }
}
