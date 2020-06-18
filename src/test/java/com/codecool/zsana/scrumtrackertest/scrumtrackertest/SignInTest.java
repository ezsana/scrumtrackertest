package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SignInTest extends Basetest{

    private Homepage homepage;
    private SignIn signIn;

    @BeforeEach
    void setupTests() {
        Homepage.setUp();
        signIn = new SignIn();
        homepage = new Homepage();
        homepage.navigateToPage(homepage.getHomepage());
        homepage.clickOnElement(homepage.getSignInUpButton());
    }

    @AfterEach
    void closeTests() {
        Homepage.shutDown();
    }

    @Test
    void validLogin() {
        signIn.writeIntoInputField(signIn.getUsernameInputField(), getUsername());
        signIn.writeIntoInputField(signIn.getPasswordInputField(), getPassword());
        signIn.clickOnElement(signIn.getSubmitButton());
        boolean isHeadingOnPage = homepage.isElementPresent(homepage.getHeading());
        homepage.clickOnElement(homepage.getLogoutButton());
        Assertions.assertTrue(isHeadingOnPage);
    }

    @Test
    void invalidLoginWithInvalidCredentials() {
        signIn.writeIntoInputField(signIn.getUsernameInputField(), getInvalidUsername());
        signIn.writeIntoInputField(signIn.getPasswordInputField(), getInvalidPassword());
        signIn.clickOnElement(signIn.getSubmitButton());
        String message = signIn.getPopUpMessage();
        signIn.acceptPopUpAlert();
        Assertions.assertEquals("SignIn failed", message);
    }

    @Test
    void invalidLoginWithEmptyFields() {
        signIn.writeIntoInputField(signIn.getUsernameInputField(), getInvalidUsername());
        signIn.writeIntoInputField(signIn.getPasswordInputField(), getInvalidPassword());
        signIn.clickOnElement(signIn.getSubmitButton());
        String message = signIn.getPopUpMessage();
        signIn.acceptPopUpAlert();
        Assertions.assertEquals("SignIn failed", message);
    }

}