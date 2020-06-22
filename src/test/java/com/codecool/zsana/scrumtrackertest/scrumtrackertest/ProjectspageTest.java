package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

class ProjectspageTest {

    private Homepage homepage;
    private SignIn signIn;
    private Projectspage projectspage;

    @BeforeEach
    void setupTests() {
        Basepage.setUp();
        signIn = new SignIn();
        homepage = new Homepage();
        projectspage = new Projectspage();
        Basepage.goToAppUrl();
        signIn.validLoginForTest();
        homepage.clickOnElement(homepage.getProjectsButton());
    }

    @AfterEach
    void closeTests() {
        signIn.logoutForTest(homepage);
        Basepage.shutDown();
    }

    /**
     * Check if all projects are available on the projects page
     */

    @Order(1)
    @Test
    void allProjectsAreOnPage() {
        boolean isBaseProjectForTestPresent = projectspage.isElementPresent(projectspage.getBaseProjectForTestTitle());
        boolean isShareThisProjectPresent = projectspage.isElementPresent(projectspage.getShareThisProjectTitle());
        boolean isArchiveThisProjectPresent = projectspage.isElementPresent(projectspage.getArchiveThisProjectTitle());
        Assertions.assertTrue(isBaseProjectForTestPresent);
        Assertions.assertTrue(isShareThisProjectPresent);
        Assertions.assertTrue(isArchiveThisProjectPresent);
    }

    /**
     * Project creation is not possible with less than three character
     */

    @Order(2)
    @Test
    void createProjectNotPossibleWithLessThanThreeChar() {
        projectspage.createNewProjectWithInvalidName("pr");
        boolean errorMessage = projectspage.isElementPresent(projectspage.getTitleLessThanThreeCharErrorMessage());
        projectspage.getCloseErrorWindow().click();
        Assertions.assertTrue(errorMessage);
    }

    /**
     * New project created is seen on page
     */

    @Order(3)
    @Test
    void newProjectIsDisplayedOnPage() {
        projectspage.createNewProject("AddAndDeleteThisProject");
        Assertions.assertTrue(projectspage.isNewProjectDisplayed("AddAndDeleteThisProject"));
    }

    /**
     * Delete project test
     */

    @Order(4)
    @Test
    void deleteProjectIsWorking() {
        WebElement project = projectspage.searchElementByText("AddAndDeleteThisProject");
        projectspage.deleteProject("AddAndDeleteThisProject");
        Assertions.assertTrue(projectspage.elementIsNotPresent(project));
    }

    /**
     * Archive project test
     */

    @Order(5)
    @Test
    void archiveProjectWorking() {
        Assertions.assertTrue(projectspage.projectIsInArchivedProjectsContainer());
    }

    /**
     * Unarchive project test
     */

    @Order(6)
    @Test
    void unarchiveProjectWorking() {
        Assertions.assertTrue(projectspage.projectIsUnarchived());
    }

}