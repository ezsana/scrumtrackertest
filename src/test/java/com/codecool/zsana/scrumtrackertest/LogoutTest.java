package com.codecool.zsana.scrumtrackertest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class LogoutTest {

    private Homepage homepage;
    private SignIn signIn;
    private boolean logoutMessage;

    /**
     * Scenario: Successful logging out
     */

    @Given("that I'm logged in for logout test")
    public void setupAndLoginForTest() {
        Basepage.setUp();
        signIn = new SignIn();
        homepage = new Homepage();
        Basepage.goToAppUrl();
        signIn.validLoginForTest();
    }

    @When("I click on Logout button")
    public void clickOnLogoutButton() {
        homepage.clickOnElement(homepage.getLogoutButton());
        logoutMessage = homepage.isElementPresent(homepage.getLogoutMessage());
    }

    @Then("a pop-up window shows that logout was successful")
    public void successfulLogout() {
        assertTrue(logoutMessage);
    }

    @And("I close logout test.")
    public void closeTest() {
        Basepage.shutDown();
    }

}
