package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.JVM)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UniqueProjectpageTest extends Basetest {

    private Homepage homepage;
    private SignIn signIn;
    private Projectspage projectspage;
    private UniqueProjectpage uniqueProjectpage;

    @BeforeAll
    void setup() {
        Homepage.setUp();
        signIn = new SignIn();
        homepage = new Homepage();
        projectspage = new Projectspage();
        uniqueProjectpage = new UniqueProjectpage();
        homepage.navigateToPage(homepage.getHomepage());
        signIn.validLogin(homepage);
        homepage.clickOnElement(homepage.getProjectsButton());
    }

    @AfterAll
    void close() {
        homepage.clickOnElement(homepage.getProjectsButton());
        projectspage.deleteProject("Fresh project");
        Homepage.shutDown();
    }

    /*
        17)
        Given that I've just created a new project
        When I click on the newly created project
        Then the page of this project shows up
        And I can see three statuses: To Do; In Progress; Done
    */

    @TestFactory
    Collection<DynamicTest> freshlyCreatedProjectPageTest() {
        homepage.clickOnElement(homepage.getProjectsButton());
        WebElement project = projectspage.createNewProject("Fresh project");
        projectspage.clickOnElement(project);
        return Arrays.asList(DynamicTest.dynamicTest("To Do", () -> assertTrue(uniqueProjectpage.isElementPresent(uniqueProjectpage.getTodoContainer()))),
                DynamicTest.dynamicTest("In Progress", () -> assertTrue(uniqueProjectpage.isElementPresent(uniqueProjectpage.getInProgressContainer()))),
                DynamicTest.dynamicTest("Done", () -> assertTrue(uniqueProjectpage.isElementPresent(uniqueProjectpage.getDoneContainer()))));
    }

    /*
        18)
        Given that I'm on my unique project page
        When I fill in the "Add new status" field and click on submit (+) button
        I can see the new status on the page.
    */

    @Test
    void addNewStatusIsWorkingTest() {
        homepage.clickOnElement(homepage.getProjectsButton());
        projectspage.clickOnElement(projectspage.getProji());
        uniqueProjectpage.addNewStatus("New status");
        WebElement status = uniqueProjectpage.searchElementByText("New status");
        Assertions.assertTrue(status.isDisplayed());
    }

    /*
        27)
        Given that I'm on my unique project page
        When I click on the status delete button
        Then status is deleted.
    */

    @Test
    void statusDeleteIsWorkingTest() {
        homepage.clickOnElement(homepage.getProjectsButton());
        projectspage.clickOnElement(projectspage.getProji());
        WebElement status = uniqueProjectpage.searchElementByText("New status");
        uniqueProjectpage.deleteStatus(status);
        Assertions.assertTrue(uniqueProjectpage.elementIsNotPresent(status));
    }

    /*
        19)
        Given that I'm on my unique project page
        When I fill in the "Add new task" field and click on submit (+) button
        I can see the new task in the first container on the page.
    */

    @Test
    void addNewTaskIsWorkingTest() {
        homepage.clickOnElement(homepage.getProjectsButton());
        projectspage.clickOnElement(projectspage.getProji());
        uniqueProjectpage.addNewTask("New task");
        WebElement task = uniqueProjectpage.searchElementByText("New task");
        Assertions.assertTrue(task.isDisplayed());
    }

    /*
        26)
        Given that I have a task
        When I click on the task delete button
        Then the task is deleted.
     */

    @Test
    void deleteTaskIsWorkingTest() {
        homepage.clickOnElement(homepage.getProjectsButton());
        projectspage.clickOnElement(projectspage.getProji());
        WebElement task = uniqueProjectpage.searchElementByText("New task");
        uniqueProjectpage.deleteTask(task);
        Assertions.assertTrue(uniqueProjectpage.elementIsNotPresent(task));
    }

    /*
        20)
        Given that I'm on my unique project page
        When I fill in the "Add new status" field with less than three character and click on submit (+) button
        Then a pop-up shows that I have to write more the three letters to create a new status.

    */

    @Test
    void addNewStatusWithLessThanThreeChar() {
        homepage.clickOnElement(homepage.getProjectsButton());
        projectspage.clickOnElement(projectspage.getProji());
        uniqueProjectpage.addNewStatus("ne");
        String message = uniqueProjectpage.getPopUpMessage();
        uniqueProjectpage.acceptPopUpAlert();
        Assertions.assertEquals("add name (minimum 3 character) to your status", message);
    }

    /*

        21)
        Given that I'm on my unique project page
        When I fill in the "Add new task" field with less than three character and click on submit (+) button
        Then a pop-up shows that I have to write more the three letters to create a new task.
    */

    @Test
    void addNewTaskWithLessThanThreeChar() {
        homepage.clickOnElement(homepage.getProjectsButton());
        projectspage.clickOnElement(projectspage.getProji());
        uniqueProjectpage.addNewTask("ne");
        String message = uniqueProjectpage.getPopUpMessage();
        uniqueProjectpage.acceptPopUpAlert();
        Assertions.assertEquals("add title (minimum 3 character) to the new task", message);
    }

    /*
        22)
        Given that I've created a new task
        When I click on the Edit task button
        Then I can see a pop-up window with possibilities to edit the task.

        23)
        Given that I clicked on the edit task button
        When I fill the inputs and click on the ok button
        Then I can change and save a new title, description and business value.

        24)
        Given that I clicked on the edit task button
        When I fill the inputs and click on the cancel button
        Then the changes are not saved.

        25)
        Given that I have a task
        When I drag the task from one status to an other
        Then the aforementioned task would be in the new container.


        28)
        Given that I'm on the unique project page
        And I click on the invite participant button
        Then I can see a pop-up window with possibilities to add new participants
        And see the already added ones.

        29)
        Given that I've clicked on the invite participant button
        When I fill in the input and click on the add participant button
        Then the invited participant's name in seen.
     */
}