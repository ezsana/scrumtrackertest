package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationTest extends Basetest {

    private Homepage homepage;
    private Registration registration;

    @BeforeEach
    void setupTests() {
        super.setUp();
        registration = new Registration(getDriver());
        homepage = new Homepage(getDriver());
        registration.navigateToPage("http://192.168.1.105:3000/");
        registration.clickOnElement(homepage.getRegistrationButton());
    }

    @AfterEach
    void closeTests() {
        super.shutDown();
    }

    @Test
    @Order(1)
    void registrationWorking() {
        registration.writeIntoInputField(registration.getUsernameInputField(), getUsername());
        registration.writeIntoInputField(registration.getPasswordInputField(), getPassword());
        registration.clickOnElement(registration.getSubmitButton());
        registration.acceptPopUpAlert();
        Assertions.assertTrue(homepage.isElementPresent(homepage.getHeading()));

    }

    @Test
    @Order(2)
    void registrationWithBlankFields() {
        registration.clickOnElement(registration.getSubmitButton());
        registration.acceptPopUpAlert();
        Assertions.assertTrue(registration.isElementPresent(registration.getPasswordInputField()));
    }

    @Test
    @Order(3)
    void registrationWithExistingData() {
        registration.writeIntoInputField(registration.getUsernameInputField(), getUsername());
        registration.writeIntoInputField(registration.getPasswordInputField(), getPassword());
        registration.clickOnElement(registration.getSubmitButton());
        registration.acceptPopUpAlert();
        Assertions.assertTrue(registration.isElementPresent(registration.getPasswordInputField()));
    }
}