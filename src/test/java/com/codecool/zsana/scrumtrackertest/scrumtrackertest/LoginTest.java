package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LoginTest extends Basetest{

    private Homepage homepage;
    private Login login;
    private Projectspage projectspage;

    @BeforeEach
    void setupTests() {
        Homepage.setUp();
        login = new Login();
        homepage = new Homepage();
        projectspage = new Projectspage();
        homepage.navigateToPage(homepage.getHomepage());
        homepage.clickOnElement(homepage.getSignInUpButton());
    }

    @AfterEach
    void closeTests() {
        Homepage.shutDown();
    }

    @Test
    void validLogin() {
        login.writeIntoInputField(login.getUsernameInputField(), getUsername());
        login.writeIntoInputField(login.getPasswordInputField(), getPassword());
        login.clickOnElement(login.getSubmitButton());
        boolean isHeadingOnPage = homepage.isElementPresent(homepage.getHeading());
        homepage.clickOnElement(homepage.getLogoutButton());
        Assertions.assertTrue(isHeadingOnPage);
    }

    @Test
    void invalidLoginWithInvalidCredentials() {
        login.writeIntoInputField(login.getUsernameInputField(), getInvalidUsername());
        login.writeIntoInputField(login.getPasswordInputField(), getInvalidPassword());
        login.clickOnElement(login.getSubmitButton());
        String message = login.getPopUpMessage();
        login.acceptPopUpAlert();
        Assertions.assertEquals("Login failed", message);
    }

    @Test
    void invalidLoginWithEmptyFields() {
        login.writeIntoInputField(login.getUsernameInputField(), getInvalidUsername());
        login.writeIntoInputField(login.getPasswordInputField(), getInvalidPassword());
        login.clickOnElement(login.getSubmitButton());
        String message = login.getPopUpMessage();
        login.acceptPopUpAlert();
        Assertions.assertEquals("Login failed", message);
    }

}