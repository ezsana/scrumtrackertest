package com.codecool.zsana.scrumtrackertest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class HomepageTest extends Basetest {

    private Homepage homepage;
    private SignIn signIn;

    @Given("that I'm logged in")
    public void setupTest(){
        Basepage.setUp();
        Basepage.goToAppUrl();
        homepage = new Homepage();
        signIn = new SignIn();
    }

    @When("homepage is loaded")
    public void signInAndLoadHomepage() {
        signIn.validLoginForTest();
    }

    @Then("all of the above web elements are seen")
    @TestFactory
    public Collection<DynamicTest> elementsAreVisible() {
        return Arrays.asList(DynamicTest.dynamicTest("Home button", () -> assertTrue(homepage.isElementPresent(homepage.getHomeButton()))),
                DynamicTest.dynamicTest("Projects button", () -> assertTrue(homepage.isElementPresent(homepage.getProjectsButton()))),
                DynamicTest.dynamicTest("Logout button", () -> assertTrue(homepage.isElementPresent(homepage.getLogoutButton()))),
                DynamicTest.dynamicTest("Welcome heading", () -> assertTrue(homepage.isElementPresent(homepage.getWelcomeHeading()))),
                DynamicTest.dynamicTest("Check Projects link", () -> assertTrue(homepage.isElementPresent(homepage.getCheckProjectsLink()))));
    }


    @And("I close homepage tests.")
    public void closeTests() {
        signIn.logoutForTest(homepage);
        Basepage.shutDown();
    }

}