package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RegistrationTest extends Basetest {

    private Homepage homepage;
    private Registration registration;

    @BeforeAll
    void SetupAllTests() {
        Homepage.setUp();
        registration = new Registration();
        homepage = new Homepage();
    }

    @BeforeEach
    void setup() {
        registration.navigateToPage(registration.getHomepage());
        registration.clickOnElement(homepage.getSignInUpButton());
        registration.clickOnElement(registration.getRegistrationButton());
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
        registration.setRegistrationNameAndPassword();
        registration.writeIntoInputField(registration.getUsernameInputField(), registration.getRegistrationName());
        registration.writeIntoInputField(registration.getPasswordInputField(), registration.getRegistrationPassword());
        registration.clickOnElement(registration.getSubmitButton());
        String message = registration.getPopUpMessage();
        registration.acceptPopUpAlert();
        Assertions.assertEquals("registration succes", message);

    }

    @Test
    @Order(2)
    void registrationWithBlankFields() {
        registration.clickOnElement(registration.getSubmitButton());
        String message = registration.getPopUpMessage();
        registration.acceptPopUpAlert();
        Assertions.assertEquals("Registration failed", message);
    }

    @Test
    @Order(3)
    void registrationWithExistingData() {
        registration.writeIntoInputField(registration.getUsernameInputField(), registration.getRegistrationName());
        registration.writeIntoInputField(registration.getPasswordInputField(), registration.getRegistrationPassword());
        registration.clickOnElement(registration.getSubmitButton());
        String message = registration.getPopUpMessage();
        registration.acceptPopUpAlert();
        Assertions.assertEquals("Registration failed", message);
    }

    /*
    @Test
    void nameOrPasswordNotLongEnough() {}
     */
}