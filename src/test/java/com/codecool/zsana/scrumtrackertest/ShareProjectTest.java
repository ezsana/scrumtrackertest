package com.codecool.zsana.scrumtrackertest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

    /**
     * To make this test reusable, the ShareThisProject is deleted and created again.
     */

public class ShareProjectTest extends Basetest {

    private Homepage homepage;
    private SignIn signIn;
    private Projectspage projectspage;
    private UniqueProjectpage uniqueProjectpage;

    /**
     * Scenario Outline: Successful inviting participant - valid account name
     */

    @Given("that I've clicked on the invite participant button")
    public void setupAndClickOnInvitationButton() {
        Basepage.setUp();
        signIn = new SignIn();
        homepage = new Homepage();
        projectspage = new Projectspage();
        uniqueProjectpage = new UniqueProjectpage();
        Basepage.goToAppUrl();
        signIn.validLoginForTest();
        homepage.clickOnElement(homepage.getProjectsButton());
        projectspage.clickOnElement(projectspage.getShareThisProjectTitle());
    }

    @When("I fill in the {string} and click on the add participant button")
    public void inviteParticipant(String participant) {
        uniqueProjectpage.inviteParticipant(participant);
    }

    @Then("the invited participant's name is seen: {string}")
    public void invitationValid(String participant) {
        assertTrue(uniqueProjectpage.isParticipantInvited(participant)); // I close the window here
    }

    @And("I close the share project test no 1.")
    public void closeInvitationValidTest() {
        signIn.logoutForTest(homepage);
        Homepage.shutDown();
    }

    /**
     * Scenario Outline: Unsuccessful inviting participant - invalid account name
     */

    @When("I fill in the input with invalid user name: {string} and click on the add participant button")
    public void invitationWithNonExistingUser(String invalidParticipant) {
        uniqueProjectpage.inviteParticipant(invalidParticipant);
    }

    @Then("the invitation is not possible with the {string}")
    public void invitationUnsuccessful(String invalidParticipant) {
        assertFalse(uniqueProjectpage.isParticipantInvited(invalidParticipant));
    }


    @And("I close the test, deleting and creating the project again.")
    public void close() {
        // Go back to projects page
        homepage.clickOnElement(homepage.getProjectsButton());
        // Delete and create the ShareThisProject project
        projectspage.deleteProject("ShareThisProject");
        projectspage.createNewProject("ShareThisProject");
        signIn.logoutForTest(homepage);
        Homepage.shutDown();
    }

}
