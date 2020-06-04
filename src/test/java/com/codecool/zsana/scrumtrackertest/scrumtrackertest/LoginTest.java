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
        homepage.navigateToPage("localhost:3000");
        homepage.clickOnElement(homepage.getLoginButton());
    }

    @AfterEach
    void closeTests() {
        super.shutDown();
    }

    @Test
    void validLogin() {
        login.writeIntoInputField(login.getUsernameInputField(), getUsername());
        login.writeIntoInputField(login.getPasswordInputField(), getPassword());
        login.clickOnElement(login.getSubmitButton());
        Assertions.assertTrue(homepage.isElementPresent(homepage.getHeading()));
    }

    @Test
    void invalidLogin() {
        login.writeIntoInputField(login.getUsernameInputField(), getInvalidUsername());
        login.writeIntoInputField(login.getPasswordInputField(), getInvalidPassword());
        login.clickOnElement(login.getSubmitButton());
        try {
            login.acceptPopUpAlert();
            Assertions.assertTrue(true);
        } catch (NullPointerException nullP) {
            Assertions.fail();
        }
    }
}