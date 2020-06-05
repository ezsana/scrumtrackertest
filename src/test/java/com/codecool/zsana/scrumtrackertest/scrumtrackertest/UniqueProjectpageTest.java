package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class UniqueProjectpageTest {

    private Homepage homepage;
    private Login login;
    private Projectspage projectspage;

    @BeforeEach
    void setupTests() {
        Homepage.setUp();
        login = new Login();
        homepage = new Homepage();
        projectspage = new Projectspage();
        homepage.navigateToPage(homepage.getHomepage());
    }

    @AfterEach
    void closeTests() {
        Homepage.shutDown();
    }
}