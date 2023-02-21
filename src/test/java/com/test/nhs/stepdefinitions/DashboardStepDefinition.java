package com.test.nhs.stepdefinitions;

import com.test.nhs.pages.DashboardPage;
import com.test.nhs.utils.DriverHelper;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class DashboardStepDefinition {


    WebDriver driver = DriverHelper.getDriver();
    DashboardPage dashboardPage = new DashboardPage(driver);


    @Then("user sees {int} cards")
    public void user_sees_cards(Integer expectedCardsNr) {
        Assert.assertEquals(expectedCardsNr, dashboardPage.numberOfCards());
    }

    @Then("user validates the cards have the same dimensions and are on the same line")
    public void user_validates_the_cards_have_the_same_dimensions_and_are_on_the_same_line() {

        Assert.assertTrue(dashboardPage.cardsHaveSameDimensions());
        Assert.assertTrue(dashboardPage.cardsHaveSameY());
    }


    @Then("user validates the cards have positive numbers")
    public void user_validates_the_cards_have_positive_numbers() {
//        System.out.println(dashboardPage.getCardNumbersText());
        Assert.assertTrue(dashboardPage.cardNumberIsNumeric());
    }


    @Then("user validates the cards with {string} have the expected title {string}")
    public void user_validates_the_cards_with_have_the_expected_title(String cardIndex, String expectedCardTitle) {
        int index = Integer.parseInt(cardIndex)-1;
        Assert.assertEquals(expectedCardTitle, dashboardPage.getActualCardTitle(index));
    }

//    @Then("user validates the cards with {string} have the expected color {string}")
//    public void user_validates_the_cards_with_have_the_expected_color(String string, String string2) {
//
//    }






}
