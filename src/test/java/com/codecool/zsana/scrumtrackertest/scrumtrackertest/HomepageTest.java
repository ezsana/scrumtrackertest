package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HomepageTest extends Basetest{

    private Homepage homepage;
    private Registration registration;

    @BeforeEach
    void setupTests() {
        super.setUp();
        homepage = new Homepage(getDriver());
        registration = new Registration(getDriver());
        homepage.navigateToPage(homepage.getHomepage());
    }

    @AfterEach
    void closeTests() {
        super.shutDown();
    }

    @Test
    void homepageHeadingAppear() {
        Assertions.assertTrue(homepage.isElementPresent(homepage.getHeading()));
    }

    @Test
    void homepageNavbarAppears() {
        Assertions.assertTrue(homepage.isElementPresent(homepage.getNavbar()));
    }

    @Test
    void clickOnButtonLeadsToPage() {
        homepage.clickOnElement(homepage.getSignInUpButton());
        Assertions.assertTrue(registration.isElementPresent(registration.getUsernameInputField()));
        Assertions.assertTrue(registration.isElementPresent(registration.getPasswordInputField()));
    }

}