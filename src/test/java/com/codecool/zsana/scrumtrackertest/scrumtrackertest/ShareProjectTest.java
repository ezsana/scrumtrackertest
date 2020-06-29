package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.junit.jupiter.api.*;

/**
 * To make this test reusable, the ShareThisProject is deleted and created again.
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShareProjectTest extends Basetest {

    private Homepage homepage;
    private SignIn signIn;
    private Projectspage projectspage;
    private UniqueProjectpage uniqueProjectpage;

    @BeforeAll
    void setup() {
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

    @AfterAll
    void close() {
        // Go back to projects page
        homepage.clickOnElement(homepage.getProjectsButton());
        // Delete and create the ShareThisProject project
        projectspage.deleteProject("ShareThisProject");
        projectspage.createNewProject("ShareThisProject");
        signIn.logoutForTest(homepage);
        Homepage.shutDown();
    }

    /**
     * Invite participant is working
     * Participant: zsana
     */

    @Test
    void inviteParticipant() {
        String participant = "zsana";
        uniqueProjectpage.inviteParticipant(participant);
        Assertions.assertTrue(uniqueProjectpage.isParticipantInvited(participant));
    }

    /**
     * Invitation is not possible when user doesn't exists.
     */

    @Test
    void invitationWithNonExistingUser() {
        String invalidParticipant = "invalidUser";
        uniqueProjectpage.inviteParticipant(invalidParticipant);
        Assertions.assertFalse(uniqueProjectpage.isParticipantInvited(invalidParticipant));
    }

}
