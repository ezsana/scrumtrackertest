package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SignUpTest extends Basetest {

    private Homepage homepage;
    private SignUp signUp;

    @BeforeAll
    void SetupAllTests() {
        Homepage.setUp();
        signUp = new SignUp();
        homepage = new Homepage();
    }

    @BeforeEach
    void setup() {
        signUp.navigateToPage(signUp.getHomepage());
        signUp.clickOnElement(homepage.getSignInUpButton());
        signUp.clickOnElement(signUp.getRegistrationButton());
    }

    @AfterAll
    void closeTests() {
        homepage.clickOnElement(homepage.getLogoutButton());
        homepage.acceptPopUpAlert();
        Homepage.shutDown();
    }

    @Test
    @Order(1)
    void registrationValid() {
        signUp.setRegistrationNameAndPassword();
        signUp.writeIntoInputField(signUp.getUsernameInputField(), signUp.getRegistrationName());
        signUp.writeIntoInputField(signUp.getPasswordInputField(), signUp.getRegistrationPassword());
        signUp.clickOnElement(signUp.getSubmitButton());
        String message = signUp.getPopUpMessage();
        signUp.acceptPopUpAlert();
        Assertions.assertEquals("signUp succes", message);

    }

    @Test
    @Order(2)
    void registrationWithBlankFields() {
        signUp.clickOnElement(signUp.getSubmitButton());
        String message = signUp.getPopUpMessage();
        signUp.acceptPopUpAlert();
        Assertions.assertEquals("SignUp failed", message);
    }

    @Test
    @Order(3)
    void registrationWithExistingData() {
        signUp.writeIntoInputField(signUp.getUsernameInputField(), signUp.getRegistrationName());
        signUp.writeIntoInputField(signUp.getPasswordInputField(), signUp.getRegistrationPassword());
        signUp.clickOnElement(signUp.getSubmitButton());
        String message = signUp.getPopUpMessage();
        signUp.acceptPopUpAlert();
        Assertions.assertEquals("SignUp failed", message);
    }

    /*
    @Test
    void nameOrPasswordNotLongEnough() {}
     */
}