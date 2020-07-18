package com.codecool.zsana.scrumtrackertest;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HomepageTest extends Basetest{

    private Homepage homepage;
    private SignIn signIn;

    @BeforeAll
    void setupTests() {
        Basepage.setUp();
        Basepage.goToAppUrl();
        homepage = new Homepage();
        signIn = new SignIn();
        signIn.validLoginForTest();
    }

    @AfterAll
    void closeTests() {
        signIn.logoutForTest(homepage);
        Basepage.shutDown();
    }

    /**
     * Check all elements on homepage are visible
     */

    @Test
    void homeButtonIsVisible() {
        Assertions.assertTrue(homepage.isElementPresent(homepage.getHomeButton()));
    }

    @Test
    void projectsButtonIsVisible() {
        Assertions.assertTrue(homepage.isElementPresent(homepage.getProjectsButton()));
    }

    @Test
    void logoutButtonIsVisible() {
        Assertions.assertTrue(homepage.isElementPresent(homepage.getLogoutButton()));
    }

    @Test
    void welcomeMessageIsVisible() {
        Assertions.assertTrue(homepage.isElementPresent(homepage.getWelcomeHeading()));
    }

    @Test
    void projectMessageIsVisible() {
        Assertions.assertTrue(homepage.isElementPresent(homepage.getCheckProjectsLink()));
    }

}