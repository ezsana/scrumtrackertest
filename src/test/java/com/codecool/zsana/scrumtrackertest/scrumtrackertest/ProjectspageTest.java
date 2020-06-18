package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.junit.jupiter.api.*;

class ProjectspageTest {

    private Homepage homepage;
    private SignIn signIn;
    private Projectspage projectspage;

    @BeforeEach
    void setupTests() {
        Homepage.setUp();
        signIn = new SignIn();
        homepage = new Homepage();
        projectspage = new Projectspage();
        homepage.navigateToPage(homepage.getHomepage());
    }

    @AfterEach
    void closeTests() {
        Homepage.shutDown();
    }

    @Test
    @Disabled
    void withoutLogInCreatingProjectNotPossible() {
        homepage.clickOnElement(homepage.getProjectsButton());
        projectspage.writeIntoInputField(projectspage.getCreateProjectInput(), "New project");
        projectspage.clickOnElement(projectspage.getSubmitButton());
        // Here I would have to get a message that I have to log in to create projects.
    }

    @Test
    void projectsAreOnPageWithLogin() {
        signIn.validLogin(homepage);
        homepage.clickOnElement(homepage.getProjectsButton());
        boolean isProjectPresent = projectspage.isElementPresent(projectspage.getProject1());
        signIn.logout(homepage);
        Assertions.assertTrue(isProjectPresent);
    }

    @Test
    void createProjectNotPossibleWithLessThanThreeChar() {
        signIn.validLogin(homepage);
        homepage.clickOnElement(homepage.getProjectsButton());
        projectspage.createNewProject("ne");
        String message = homepage.getPopUpMessage();
        homepage.acceptPopUpAlert();
        signIn.logout(homepage);
        Assertions.assertEquals("minimum 3 character", message);
    }

    @Test
    void newProjectIsDisplayedOnPage() {
        signIn.validLogin(homepage);
        homepage.clickOnElement(homepage.getProjectsButton());
        //homepage.clickOnElement(homepage.getProjectsButton());
        projectspage.createNewProject("New project 1234");
        boolean newProjectDisplayed = projectspage.isNewProjectDisplayed("New project 1234");
        projectspage.deleteProject("New project 1234");
        signIn.logout(homepage);
        Assertions.assertTrue(newProjectDisplayed);
    }
}