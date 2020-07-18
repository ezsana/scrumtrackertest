package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import io.cucumber.java.en.And;
import org.junit.jupiter.api.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SignUpTest extends Basetest {

    private SignUp signUp;

    @BeforeAll
    public void SetupAllTests() {
        Basepage.setUp();
        signUp = new SignUp();
    }

    @Given("I've clicked on Sign Up button")
    @And("registration fields can be seen")
    @BeforeEach
    public void setup() {
        Basepage.goToAppUrl();
        signUp.clickOnElement(signUp.getSignUpButton());
    }

    @AfterAll
    public void closeTests() {
        signUp.clickOnElement(signUp.getCloseWindowButton());
        Basepage.shutDown();
    }

    /**
     * Scenario: Valid registration
     */

    @When("I enter username, password and email and click on Sign up button")
    void enterCredentials() {
        signUp.setRegistrationNamePasswordAndEmail();
        signUp.writeIntoInputField(signUp.getSignUpUsernameInputField(), signUp.getSignUpName());
        signUp.writeIntoInputField(signUp.getSignUpPasswordInputField(), signUp.getSignUpPassword());
        signUp.writeIntoInputField(signUp.getSignUpEmailField(), signUp.getSignUpEmail());
        signUp.clickOnElement(signUp.getSignUpSubmitButton());
    }

    @Then("pop-up window shows registration success.")
     void registrationSuccess() {
        Assertions.assertTrue(signUp.isElementPresent(signUp.getSuccessfulRegistrationWindowMessage()));
    }

    /**
     * Scenario Outline: Invalid registration - all blank fields; username / password blank with valid e-mail;
     *                   less than 5 characters username / password with valid e-mail; all-spaces username with valid
     *                   password and e-mail
     */

    @When("I write {string}, {string}, {string}")
    void invalidRegistration(String username, String password, String email) {
        if (username.equals("null")) username = "";
        if (password.equals("null")) password = "";
        if (email.equals("null")) email = "";
        if (username.equals("spaces")) username = "          "; // ten spaces
        signUp.writeIntoInputField(signUp.getSignUpUsernameInputField(), username);
        signUp.writeIntoInputField(signUp.getSignUpPasswordInputField(), password);
        signUp.writeIntoInputField(signUp.getSignUpEmailField(), email);
        signUp.clickOnElement(signUp.getSignUpSubmitButton());
    }

    @Then("pop-up shows that I need to use at least five characters in all fields.")
    void fiveCharacterNeeded() {
        Assertions.assertTrue(signUp.isElementPresent(signUp.getAtLeastFiveCharMessage()));
    }

    /**
     * Scenario Outline: Invalid registration - valid username / password, invalid e-mail
     */

    @When("{String} and {String} valid but {String} is not in \"xxxx@xxxxx.xxx\" form")
    void wrongEmailInput(String username, String password, String email) {
        if (email.equals("spaces@spaces.com")) { email = "      @      .com"; }
        if (email.equals("spaces@spaces.spaces")) { email = "       @       .       "; }
        signUp.writeIntoInputField(signUp.getSignUpUsernameInputField(), username);
        signUp.writeIntoInputField(signUp.getSignUpPasswordInputField(), password);
        signUp.writeIntoInputField(signUp.getSignUpEmailField(), email);
        signUp.clickOnElement(signUp.getSignUpSubmitButton());
    }

    @Then("pop-up shows that e-mail is invalid.")
    void invalidEmail() {
        Assertions.assertTrue(signUp.isElementPresent(signUp.getInvalidEmailMessage()));
    }

    /**
     * Scenario Outline: Invalid registration - valid username / password, blank e-mail
     */

    @When("{String} and {String} is valid and {String} is blank")
    void blankEmailWithValidUsernameAndPassword(String username, String password, String email) {
        if (email.equals("null")) {
            email = "";
        }
        signUp.writeIntoInputField(signUp.getSignUpUsernameInputField(), username);
        signUp.writeIntoInputField(signUp.getSignUpPasswordInputField(), password);
        signUp.writeIntoInputField(signUp.getSignUpEmailField(), email);
        signUp.clickOnElement(signUp.getSignUpSubmitButton());
    }

    @Then("pop-up shows that e-mail is invalid.")
    void invalidBlankEmail() {
        Assertions.assertTrue(signUp.isElementPresent(signUp.getBlankEmailMessage()));
    }

    /**
     * Scenario: Invalid registration - already existing account
     */

    @When("I fill fields with already existing account data")
    void registrationWithExistingData() {
        signUp.writeIntoInputField(signUp.getSignUpUsernameInputField(), getUsername2());
        signUp.writeIntoInputField(signUp.getSignUpPasswordInputField(), getPassword2());
        signUp.writeIntoInputField(signUp.getSignUpEmailField(), getEmail2());
        signUp.clickOnElement(signUp.getSignUpSubmitButton());
    }

    @Then("pop-up shows that the account already exists.")
    void accountAlreadyExists() {
        Assertions.assertTrue(signUp.isElementPresent(signUp.getUserAlreadyExistsMessage()));
    }
}