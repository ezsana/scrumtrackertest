package com.codecool.zsana.scrumtrackertest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class SignUpTest extends Basetest {

    private SignUp signUp;

    /**
     * Scenario: Valid registration
     */

    @Given("I've clicked on Sign Up button")
    public void clickOnSignUpButton() {
        Basepage.setUp();
        signUp = new SignUp();
        Basepage.goToAppUrl();
        signUp.clickOnElement(signUp.getSignUpButton());
    }

    @When("I enter username, password and email and click on Sign up button")
    public void enterUsernamePasswordAndEmailAndClickOnSignUpButton() {
        signUp.setRegistrationNamePasswordAndEmail();
        signUp.writeIntoInputField(signUp.getSignUpUsernameInputField(), signUp.getSignUpName());
        signUp.writeIntoInputField(signUp.getSignUpPasswordInputField(), signUp.getSignUpPassword());
        signUp.writeIntoInputField(signUp.getSignUpEmailField(), signUp.getSignUpEmail());
        signUp.clickOnElement(signUp.getSignUpSubmitButton());
    }

    @Then("pop-up window shows registration success")
    public void registrationSuccess() {
        assertTrue(signUp.isElementPresent(signUp.getSuccessfulRegistrationWindowMessage()));
    }

    /**
     * Scenario Outline: Invalid registration - all blank fields; username / password blank with valid e-mail;
     *                   less than 5 characters username / password with valid e-mail; all-spaces username with valid
     *                   password and e-mail
     */

    @When("I write {string}, {string}, {string}")
    public void invalidRegistration(String username, String password, String email) {
        if (username.equals("null")) username = "";
        if (password.equals("null")) password = "";
        if (email.equals("null")) email = "";
        if (username.equals("spaces")) username = "          "; // ten spaces
        signUp.writeIntoInputField(signUp.getSignUpUsernameInputField(), username);
        signUp.writeIntoInputField(signUp.getSignUpPasswordInputField(), password);
        signUp.writeIntoInputField(signUp.getSignUpEmailField(), email);
        signUp.clickOnElement(signUp.getSignUpSubmitButton());
    }

    @Then("pop-up shows that I need to use at least five characters in all fields")
    public void fiveCharacterNeeded() {
        assertTrue(signUp.isElementPresent(signUp.getAtLeastFiveCharMessage()));
    }

    /**
     * Scenario Outline: Invalid registration - valid username / password, invalid e-mail
     */

    @When("{string} and {string} valid but {string} is not in xxxxx@xxxxx.xxx form")
    public void wrongEmailInput(String username, String password, String email) {
        if (email.equals("spaces@spaces.com")) { email = "      @      .com"; }
        if (email.equals("spaces@spaces.spaces")) { email = "       @       .       "; }
        signUp.writeIntoInputField(signUp.getSignUpUsernameInputField(), username);
        signUp.writeIntoInputField(signUp.getSignUpPasswordInputField(), password);
        signUp.writeIntoInputField(signUp.getSignUpEmailField(), email);
        signUp.clickOnElement(signUp.getSignUpSubmitButton());
    }

    @Then("pop-up shows that e-mail is invalid")
    public void invalidEmail() {
        assertTrue(signUp.isElementPresent(signUp.getInvalidEmailMessage()));
    }

    /**
     * Scenario Outline: Invalid registration - valid username / password, blank e-mail
     */

    @When("{string} and {string} is valid and {string} is blank")
    public void blankEmailWithValidUsernameAndPassword(String username, String password, String email) {
        if (email.equals("null")) {
            email = "";
        }
        signUp.writeIntoInputField(signUp.getSignUpUsernameInputField(), username);
        signUp.writeIntoInputField(signUp.getSignUpPasswordInputField(), password);
        signUp.writeIntoInputField(signUp.getSignUpEmailField(), email);
        signUp.clickOnElement(signUp.getSignUpSubmitButton());
    }

    @Then("pop-up shows that all fields are required")
    public void invalidBlankEmail() {
        assertTrue(signUp.isElementPresent(signUp.getBlankEmailMessage()));
    }

    /**
     * Scenario: Invalid registration - already existing account
     */

    @When("I fill fields with already existing account data")
    public void registrationWithExistingData() {
        signUp.writeIntoInputField(signUp.getSignUpUsernameInputField(), getUsername2());
        signUp.writeIntoInputField(signUp.getSignUpPasswordInputField(), getPassword2());
        signUp.writeIntoInputField(signUp.getSignUpEmailField(), getEmail2());
        signUp.clickOnElement(signUp.getSignUpSubmitButton());
    }

    @Then("pop-up shows that the account already exists")
    public void accountAlreadyExists() {
        assertTrue(signUp.isElementPresent(signUp.getUserAlreadyExistsMessage()));
    }


    @And("finally I close the test.")
    public void closeTests() {
        signUp.clickOnElement(signUp.getCloseWindowButton());
        Basepage.shutDown();
    }

}