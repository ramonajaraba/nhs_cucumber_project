package com.test.nhs.stepdefinitions;

import com.test.nhs.pages.LoginPage;
import com.test.nhs.utils.ConfigReader;
import com.test.nhs.utils.DriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStepDefinition {


    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);


    @Given("the user navigate to the NHS website")
    public void the_user_navigate_to_the_nhs_website() {
        // driver.get("http://www.techtorialacademy.link/");
        //we can save the url in configuration.properties and get it from there
        driver.get(ConfigReader.readProperty("NHS_url"));
    }

    //feature file: And validates page title 'LoginPage'
    @Given("validates page title {string}")//title value is 'LoginPage'
    public void validates_page_title( String expectedTitle) {
        //the parameter 'expectedTitle' from the methods, gets the value from the feature file: 'LoginPage'
        //expectedTitle="LoginPage"
        Assert.assertEquals(expectedTitle,driver.getTitle());
    }

    @Given("credential field attribute is required {string}")
    public void credential_field_attribute_is_required(String attributeValue) {
        Assert.assertEquals(attributeValue ,loginPage.passwordIsRequired());
    }


    @When("user login with credentials {string} and {string}")
    public void user_enters_correct_and(String username, String password) throws InterruptedException {

        loginPage.login(username,password);
    }

    @Then("user validates page title {string} and url {string}")
    public void user_validates_page_title_and_url(String expectedTitle, String expectedUrl) {

        Assert.assertEquals(expectedTitle, driver.getTitle());
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }









}
