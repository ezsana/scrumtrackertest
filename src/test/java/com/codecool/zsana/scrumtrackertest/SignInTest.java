package com.codecool.zsana.scrumtrackertest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class SignInTest extends Basetest{

    private SignIn signIn;
    private Homepage homepage;
    private boolean isWelcomeMessageOnPage;
    private boolean isInvalidLoginMessageDisplayed;

    /**
     * Scenario: Valid sign in
     */

    @Given("that I've clicked on Sign in button")
    public void setup() {
        Basepage.setUp();
        Basepage.goToAppUrl();
        signIn = new SignIn();
        homepage = new Homepage();
        signIn.clickOnElement(signIn.getSignInButton());
    }

    @When("I enter valid username and valid password")
    public void writeValidLoginCredentials() {
        signIn.writeIntoInputField(signIn.getSignInUsernameInputField(), getUsername2());
        signIn.writeIntoInputField(signIn.getSignInPasswordInputField(), getPassword2());
        signIn.clickOnElement(signIn.getSignInSubmitButton());
        isWelcomeMessageOnPage = homepage.isElementPresent(homepage.getWelcomeHeading());
        signIn.logoutForTest(homepage);
    }

    @Then("I see a welcome message on the screen")
    public void validLoginSuccessful() {
        assertTrue(isWelcomeMessageOnPage);
    }

    /**
     * Scenario Outline: Invalid sign in
     */

    @When("I enter invalid {string}, {string}")
    public void invalidLoginWithInvalidCredentials(String username, String password) {
        if (username.equals("null")) username = "";
        if (password.equals("null")) password = "";
        signIn.writeIntoInputField(signIn.getSignInUsernameInputField(), username);
        signIn.writeIntoInputField(signIn.getSignInPasswordInputField(), password);
        signIn.clickOnElement(signIn.getSignInSubmitButton());
        isInvalidLoginMessageDisplayed = signIn.isElementPresent(signIn.getInvalidLoginMessage());
        signIn.clickOnElement(signIn.getCloseInvalidLoginWindowButton());
    }

    @Then("pop-up shows invalid login")
    public void invalidLogin() {
        assertTrue(isInvalidLoginMessageDisplayed);
    }


    @And("I close SignIn test.")
    public void closeTests() {
        Basepage.shutDown();
    }

}