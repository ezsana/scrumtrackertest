package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.NoAlertPresentException;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RegistrationTest extends Basetest {

    private Homepage homepage;
    private Registration registration;

    @BeforeAll
    public void setupUpAllTest() {
        super.setUp();
        registration = new Registration(getDriver());
        homepage = new Homepage(getDriver());
    }

    @BeforeEach
    void setupTests() {
        registration.navigateToPage(registration.getHomepage());
        registration.clickOnElement(homepage.getSignInUpButton());
        registration.clickOnElement(registration.getRegistrationButton());
    }

    @AfterAll
    void closeTests() {
        super.shutDown();
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
}