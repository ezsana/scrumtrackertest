package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SignInTest extends Basetest{

    private SignIn signIn;
    private Homepage homepage;

    @BeforeEach
    void setupTests() {
        Basepage.setUp();
        Basepage.goToAppUrl();
        signIn = new SignIn();
        homepage = new Homepage();
        signIn.clickOnElement(signIn.getSignInButton());
    }

    @AfterEach
    void closeTests() {
        Basepage.shutDown();
    }

    /**
     * Valid login
     */

    @Test
    void validLogin() {
        signIn.writeIntoInputField(signIn.getSignInUsernameInputField(), getUsername2());
        signIn.writeIntoInputField(signIn.getSignInPasswordInputField(), getPassword2());
        signIn.clickOnElement(signIn.getSignInSubmitButton());
        boolean isWelcomeMessageOnPage = homepage.isElementPresent(homepage.getWelcomeHeading());
        signIn.logoutForTest(homepage);
        Assertions.assertTrue(isWelcomeMessageOnPage);
    }

    /**
     * Invalid login:
     *  invalid username
     *  invalid password
     *  empty username
     *  empty password
     *  all blank fields
     */

    @ParameterizedTest
    @CsvFileSource(resources = "/login.csv", numLinesToSkip = 1)
    void invalidLoginWithInvalidCredentials(String username, String password) {
        if (username == null) username = "";
        if (password == null) password = "";
        signIn.writeIntoInputField(signIn.getSignInUsernameInputField(), username);
        signIn.writeIntoInputField(signIn.getSignInPasswordInputField(), password);
        signIn.clickOnElement(signIn.getSignInSubmitButton());
        boolean isInvalidLoginMessageDisplayed = signIn.isElementPresent(signIn.getInvalidLoginMessage());
        signIn.clickOnElement(signIn.getCloseInvalidLoginWindowButton());
        Assertions.assertTrue(isInvalidLoginMessageDisplayed);
    }

}