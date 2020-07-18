package com.codecool.zsana.scrumtrackertest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

import org.openqa.selenium.WebElement;

public class ProjectspageTest {

    private Homepage homepage;
    private SignIn signIn;
    private Projectspage projectspage;
    private boolean errorMessageLessThanThreeChar;
    private WebElement projectToDelete;

    /**
     * Scenario: all my projects can be seen on page
     */

    @Given("that I'm logged in for project page test")
    public void loginForTest() {
        Basepage.setUp();
        signIn = new SignIn();
        homepage = new Homepage();
        projectspage = new Projectspage();
        Basepage.goToAppUrl();
        signIn.validLoginForTest();
    }

    @When("I click on Projects button")
    public void clickOnProjectButton() {
        homepage.clickOnElement(homepage.getProjectsButton());
    }

    //@Order(1)
    @Then("I can see all my projects")
    @TestFactory
    public Collection<DynamicTest> allProjectsAreOnPage() {
        boolean isBaseProjectForTestPresent = projectspage.isElementPresent(projectspage.getBaseProjectForTestTitle());
        boolean isShareThisProjectPresent = projectspage.isElementPresent(projectspage.getShareThisProjectTitle());
        boolean isArchiveThisProjectPresent = projectspage.isElementPresent(projectspage.getArchiveThisProjectTitle());
        return Arrays.asList(DynamicTest.dynamicTest("BaseProjectForTest", () -> assertTrue(isBaseProjectForTestPresent)),
                DynamicTest.dynamicTest("ShareThisProject", () -> assertTrue(isShareThisProjectPresent)),
                DynamicTest.dynamicTest("ArchiveThisProject", () -> assertTrue(isArchiveThisProjectPresent)));
    }

    /**
     * Scenario: Unsuccessful creating project with less than three characters
     */

    @Given("that I'm on the Projects page")
    public void setupTests() {
        loginForTest();
        clickOnProjectButton();
    }

    //@Order(2)
    @When("I fill in the \"Create Project\" field with less than three character")
    public void createProjectNotPossibleWithLessThanThreeChar() {
        projectspage.createNewProjectWithInvalidName("pr");
        errorMessageLessThanThreeChar = projectspage.isElementPresent(projectspage.getTitleLessThanThreeCharErrorMessage());
        projectspage.getCloseErrorWindow().click();
    }

    @Then("a pop-up shows that I have to write at least three letters to create a project")
    public void errorMessageForLessThanThreeCharAppears() {
        assertTrue(errorMessageLessThanThreeChar);
    }

    /**
     * Scenario: Successful creating project
     */

    //@Order(3)
    @When("I write in the \"create new project\" field and click on \"create project\" button")
    public void newProjectIsDisplayedOnPage() {
        projectspage.createNewProject("AddAndDeleteThisProject");
    }

    @Then("I can see my new project")
    public void newProjectIsShown() {
        assertTrue(projectspage.isNewProjectDisplayed("AddAndDeleteThisProject"));
    }

    /**
     * Scenario: Successful deleting project
     */

    //@Order(4)
    @When("I click on the delete project button")
    public void deleteProject() {
        projectToDelete = projectspage.searchElementByText("AddAndDeleteThisProject");
        projectspage.deleteProject("AddAndDeleteThisProject");
    }

    @Then("the project is deleted")
    public void projectIsDeleted() {
        assertTrue(projectspage.elementIsNotPresent(projectToDelete));
    }

    /**
     * Scenario: Successful archiving project
     */

    //@Order(5)
    @When("I click on the archive project button")
    public void archiveProject() {
        projectspage.archiveAndUnarchiveProject();
        projectspage.getShowAndHideArchiveProjects().click();
    }

    @Then("the archived project is replaced to the archived projects' container")
    public void projectIsReplaced() {
        assertTrue(projectspage.projectIsInArchivedProjectsContainer());
    }

    /**
     * Unarchive project test
     */

    @Order(6)
    void unarchiveProjectWorking() {
        assertTrue(projectspage.projectIsUnarchived());
    }

    /**
     * Shared projects can be seen on page
     */

    @Order(7)
    void projectIsAvailableInParticipantAccount() {
        String sharedProjectTitle = "zsanaProjectShare";
        String projectText = projectspage.getSharedProjectsContainer().getText();
        assertEquals(sharedProjectTitle, projectText);
    }

    /**
     * Shared project is not possible to delete
     */

    @Order(8)
    void deletionNotPossibleInParticipantAccount() {
        projectspage.clickOnElement(projectspage.getDeleteSharedProjectButton());
        boolean alertDisplay = projectspage.getSharedProjectDeleteErrorMessage().isDisplayed();
        projectspage.clickOnElement(projectspage.getSharedProjectDeleteErrorMessageCloseButton());
        assertTrue(alertDisplay);
    }


    @And("I close the project page test.")
    public void closeTests() {
        signIn.logoutForTest(homepage);
        Basepage.shutDown();
    }
}