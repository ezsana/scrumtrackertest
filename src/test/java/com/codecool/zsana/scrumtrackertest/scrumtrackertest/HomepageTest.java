package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HomepageTest extends Basetest{

    private Homepage homepage;
    private Registration registration;
    private Projectspage projectspage;

    @BeforeEach
    void setupTests() {
        super.setUp();
        homepage = new Homepage(getDriver());
        registration = new Registration(getDriver());
        projectspage = new Projectspage(getDriver());
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
    void clickOnSignInUpLeadsSignInUpPage() {
        homepage.clickOnElement(homepage.getSignInUpButton());
        Assertions.assertTrue(registration.isElementPresent(registration.getUsernameInputField()));
        Assertions.assertTrue(registration.isElementPresent(registration.getPasswordInputField()));
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

}