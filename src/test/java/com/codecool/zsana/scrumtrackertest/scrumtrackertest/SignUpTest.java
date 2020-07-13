package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import io.cucumber.java.en.And;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
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
     Given I've clicked on Sign Up button
     And registration fields can be seen
     When I enter username, password and email and click on Sign up button
     Then pop-up window shows registration success.
     */

    @When("I enter username, password and email and click on Sign up button")
    @Then("pop-up window shows registration success.")
    void registrationValid() {
        signUp.setRegistrationNamePasswordAndEmail();
        signUp.writeIntoInputField(signUp.getSignUpUsernameInputField(), signUp.getSignUpName());
        signUp.writeIntoInputField(signUp.getSignUpPasswordInputField(), signUp.getSignUpPassword());
        signUp.writeIntoInputField(signUp.getSignUpEmailField(), signUp.getSignUpEmail());
        signUp.clickOnElement(signUp.getSignUpSubmitButton());
        Assertions.assertTrue(signUp.isElementPresent(signUp.getSuccessfulRegistrationWindowMessage()));
    }

    /**
     Invalid registration - all blank fields; username / password blank with valid e-mail;
     less than 5 characters username / password with valid e-mail; all-spaces username with valid
     password and e-mail
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
        Assertions.assertTrue(signUp.isElementPresent(signUp.getAtLeastFiveCharMessage()));
    }

    /**
     * Invalid registration - valid username / password, invalid e-mail
     * Given I've clicked on Sign up button
     * And registration fields can be seen
     * When username / password valid but e-mail is not in "xxxxx@xxxxx.xxx" form
     * Then pop-up shows that e-mail is invalid.
     */

    @ParameterizedTest
    @ValueSource(strings = {"e", "emailaddress.com", "emailaddress@emailaddress", "emailaddress@emailaddress.", "@emailaddress.com", "     @     .com", "      .      .   "})
    void wrongEmailInput(String email) {
        String username = "username";
        String password = "password";
        signUp.writeIntoInputField(signUp.getSignUpUsernameInputField(), username);
        signUp.writeIntoInputField(signUp.getSignUpPasswordInputField(), password);
        signUp.writeIntoInputField(signUp.getSignUpEmailField(), email);
        signUp.clickOnElement(signUp.getSignUpSubmitButton());
        Assertions.assertTrue(signUp.isElementPresent(signUp.getInvalidEmailMessage()));
    }

    /**
     * Invalid registration:
     *  blank e-mail field
     */

    @Test
    void invalidBlankEmail() {
        String username = "username";
        String password = "password";
        String email = "";
        signUp.writeIntoInputField(signUp.getSignUpUsernameInputField(), username);
        signUp.writeIntoInputField(signUp.getSignUpPasswordInputField(), password);
        signUp.writeIntoInputField(signUp.getSignUpEmailField(), email);
        signUp.clickOnElement(signUp.getSignUpSubmitButton());
        Assertions.assertTrue(signUp.isElementPresent(signUp.getBlankEmailMessage()));
    }

    /**
     * Invalid registration:
     *  registration with existing data
     */


    @When("I fill fields with already existing account data")
    @Then("pop-up shows that the account already exists.")
    void registrationWithExistingData() {
        signUp.writeIntoInputField(signUp.getSignUpUsernameInputField(), getUsername2());
        signUp.writeIntoInputField(signUp.getSignUpPasswordInputField(), getPassword2());
        signUp.writeIntoInputField(signUp.getSignUpEmailField(), getEmail2());
        signUp.clickOnElement(signUp.getSignUpSubmitButton());
        Assertions.assertTrue(signUp.isElementPresent(signUp.getUserAlreadyExistsMessage()));
    }
}