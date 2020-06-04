package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest extends Basetest{

    private Homepage homepage;
    private Login login;
    private Projectspage projectspage;

    @BeforeEach
    void setupTests() {
        super.setUp();
        login = new Login(getDriver());
        homepage = new Homepage(getDriver());
        projectspage = new Projectspage(getDriver());
        homepage.navigateToPage(homepage.getHomepage());
        homepage.clickOnElement(homepage.getSignInUpButton());
    }

    @AfterEach
    void closeTests() {
        login.acceptPopUpAlert();
        super.shutDown();
    }

    @Test
    void validLogin() {
        login.writeIntoInputField(login.getUsernameInputField(), getUsername());
        login.writeIntoInputField(login.getPasswordInputField(), getPassword());
        login.clickOnElement(login.getSubmitButton());
        Assertions.assertEquals("Login successful", login.getPopUpMessage());
    }

    @Test
    void invalidLoginWithInvalidCredentials() {
        login.writeIntoInputField(login.getUsernameInputField(), getInvalidUsername());
        login.writeIntoInputField(login.getPasswordInputField(), getInvalidPassword());
        login.clickOnElement(login.getSubmitButton());
        Assertions.assertEquals("Login failed", login.getPopUpMessage());
    }

    @Test
    void invalidLoginWithEmptyFields() {
        login.writeIntoInputField(login.getUsernameInputField(), getInvalidUsername());
        login.writeIntoInputField(login.getPasswordInputField(), getInvalidPassword());
        login.clickOnElement(login.getSubmitButton());
        Assertions.assertEquals("Login failed", login.getPopUpMessage());
    }
}