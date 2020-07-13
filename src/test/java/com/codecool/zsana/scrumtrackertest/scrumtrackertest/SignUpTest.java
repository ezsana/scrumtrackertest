package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SignUpTest extends Basetest {

    private SignUp signUp;

    @BeforeAll
    void SetupAllTests() {
        Basepage.setUp();
        signUp = new SignUp();
    }

    @BeforeEach
    void setup() {
        Basepage.goToAppUrl();
        signUp.clickOnElement(signUp.getSignUpButton());
    }

    @AfterAll
    void closeTests() {
        signUp.clickOnElement(signUp.getCloseWindowButton());
        Basepage.shutDown();
    }

    /**
     * Valid registration
     */

    @Test
    void registrationValid() {
        signUp.setRegistrationNamePasswordAndEmail();
        signUp.writeIntoInputField(signUp.getSignUpUsernameInputField(), signUp.getSignUpName());
        signUp.writeIntoInputField(signUp.getSignUpPasswordInputField(), signUp.getSignUpPassword());
        signUp.writeIntoInputField(signUp.getSignUpEmailField(), signUp.getSignUpEmail());
        signUp.clickOnElement(signUp.getSignUpSubmitButton());
        Assertions.assertTrue(signUp.isElementPresent(signUp.getSuccessfulRegistrationWindowMessage()));
    }

    /**
     * Invalid registration:
     *  too short username
     *  too short password
     *  blank password
     *  blank username
     *  all-spaces username
     *  all fields blank
     */

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/registration.csv", numLinesToSkip = 1)
    void invalidRegistration(String username, String password, String email) {
        if (username == null) username = "";
        if (password == null) password = "";
        signUp.writeIntoInputField(signUp.getSignUpUsernameInputField(), username);
        signUp.writeIntoInputField(signUp.getSignUpPasswordInputField(), password);
        signUp.writeIntoInputField(signUp.getSignUpEmailField(), email);
        signUp.clickOnElement(signUp.getSignUpSubmitButton());
        Assertions.assertTrue(signUp.isElementPresent(signUp.getAtLeastFiveCharMessage()));
    }

    /**
     * Invalid registration:
     *  too short e-mail
     *  invalid e-mail
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

    @Test
    void registrationWithExistingData() {
        signUp.writeIntoInputField(signUp.getSignUpUsernameInputField(), getUsername2());
        signUp.writeIntoInputField(signUp.getSignUpPasswordInputField(), getPassword2());
        signUp.writeIntoInputField(signUp.getSignUpEmailField(), getEmail2());
        signUp.clickOnElement(signUp.getSignUpSubmitButton());
        Assertions.assertTrue(signUp.isElementPresent(signUp.getUserAlreadyExistsMessage()));
    }
}