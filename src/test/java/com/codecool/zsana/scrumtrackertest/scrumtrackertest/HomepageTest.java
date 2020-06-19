package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HomepageTest extends Basetest{/*

    private Homepage homepage;
    private SignUp signUp;
    private Projectspage projectspage;

    @BeforeEach
    void setupTests() {
        Homepage.setUp();
        homepage = new Homepage();
        signUp = new SignUp();
        projectspage = new Projectspage();
        homepage.navigateToPage(homepage.getHomepage());
    }

    @AfterEach
    void closeTests() {
        Homepage.shutDown();
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
    void clickOnSignInUpLeadsSignInUpPage() {
        homepage.clickOnElement(homepage.getSignInUpButton());
        signUp.clickOnElement(signUp.getRegistrationButton());
        Assertions.assertTrue(signUp.isElementPresent(signUp.getUsernameInputField()));
        Assertions.assertTrue(signUp.isElementPresent(signUp.getPasswordInputField()));
    }

    @Test
    void clickOnHomeLeadsHomePage() {
        homepage.clickOnElement(homepage.getHomeButton());
        Assertions.assertTrue(homepage.isElementPresent(homepage.getHeading()));
    }

    @Test
    void clickOnProjectsLeadsProjectsPage() {
        homepage.clickOnElement(homepage.getProjectsButton());
        Assertions.assertTrue(projectspage.isElementPresent(projectspage.getCreateProjectInput()));
    }
*/
}