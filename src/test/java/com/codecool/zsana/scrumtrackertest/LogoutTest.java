package com.codecool.zsana.scrumtrackertest;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogoutTest {

    Homepage homepage;
    SignIn signIn;

    @BeforeAll
    void setup() {
        Basepage.setUp();
        signIn = new SignIn();
        homepage = new Homepage();
        Basepage.goToAppUrl();
        signIn.validLoginForTest();
    }

    @AfterAll
    void close() {
        Basepage.shutDown();
    }

    /**
     * Logout is working
     */

    @Test
    void logoutTest() {
        homepage.clickOnElement(homepage.getLogoutButton());
        boolean logoutMessage = homepage.isElementPresent(homepage.getLogoutMessage());
        Assertions.assertTrue(logoutMessage);
    }

}
