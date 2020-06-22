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
        Basepage.setUp();
        signIn = new SignIn();
        homepage = new Homepage();
        projectspage = new Projectspage();
        uniqueProjectpage = new UniqueProjectpage();
        Basepage.goToAppUrl();
        signIn.validLoginForTest();
        homepage.clickOnElement(homepage.getProjectsButton());
        projectspage.clickOnElement(projectspage.getBaseProjectForTestTitle());
    }

    @AfterAll
    void close() {
        signIn.logoutForTest(homepage);
        Homepage.shutDown();
    }

    /**
     * After clicking on BaseProjectForTest I can see all three basic statuses:
     *  To Do
     *  In Progress
     *  Done
    */

    @TestFactory
    Collection<DynamicTest> freshlyCreatedProjectPageTest() {
        return Arrays.asList(DynamicTest.dynamicTest("To Do", () -> assertTrue(uniqueProjectpage.isElementPresent(uniqueProjectpage.getTodoContainer()))),
                DynamicTest.dynamicTest("In Progress", () -> assertTrue(uniqueProjectpage.isElementPresent(uniqueProjectpage.getInProgressContainer()))),
                DynamicTest.dynamicTest("Done", () -> assertTrue(uniqueProjectpage.isElementPresent(uniqueProjectpage.getDoneContainer()))));
    }


    /**
     * Add new status is working
     *  New status: On Hold
    */

    @Test
    void addNewStatusIsWorkingTest() {
        uniqueProjectpage.addNewStatus("On Hold");
        WebElement status = uniqueProjectpage.searchElementByText("On Hold");
        Assertions.assertTrue(status.isDisplayed());
    }

    /**
     * Delete status is working
     *  Deleted status: On Hold
    */

    @Test
    void statusDeleteIsWorkingTest() {
        WebElement status = uniqueProjectpage.searchElementByText("On Hold");
        uniqueProjectpage.deleteStatus(status);
        Assertions.assertTrue(uniqueProjectpage.elementIsNotPresent(status));
    }

    /**
     * Add new status with less than three character is not possible
    */

    @Test
    void addNewStatusWithLessThanThreeChar() {
        uniqueProjectpage.addNewStatus("ne");
        String message = uniqueProjectpage.getPopUpMessage();
        uniqueProjectpage.acceptPopUpAlert();
        Assertions.assertEquals("add name (minimum 3 character) to your status", message);
    }

    /**
     * Add new task in To Do container
     *  Task name: AddAndDeleteThisTask
    */

    @Test
    void addNewTaskIsWorkingTest() {
        uniqueProjectpage.addNewTask("AddAndDeleteThisTask");
        WebElement task = uniqueProjectpage.searchElementByText("AddAndDeleteThisTask");
        Assertions.assertTrue(task.isDisplayed());
    }

    /**
     * Delete task is working
     *  task to delete: AddAndDeleteThisTask
     */

    @Test
    void deleteTaskIsWorkingTest() {
        WebElement task = uniqueProjectpage.searchElementByText("AddAndDeleteThisTask");
        uniqueProjectpage.deleteTask(task);
        Assertions.assertTrue(uniqueProjectpage.elementIsNotPresent(task));
    }

    /**
     * Add new task with less than three character is not possible
    */

    @Test
    void addNewTaskWithLessThanThreeChar() {
        uniqueProjectpage.addNewTask("ne");
        boolean errorMessage = uniqueProjectpage.isElementPresent(uniqueProjectpage.getErrorMessage());
        uniqueProjectpage.clickOnElement(uniqueProjectpage.getErrorWindowCloseButton());
        Assertions.assertTrue(errorMessage);
    }

    /**
     * Send the project details by e-mail is working
     */

    @Test
    void sendProjectDetailsByEmail() {

    }

    /**
     * Send project by e-mail is not possible with invalid e-mail address
     */

    @Test
    void sendEmailWithInvalidEmailAddress() {

    }

    /**
     * Limit the In Progress task count is working
     */

    @Test
    void limitInProgressTaskCount() {

    }

    /**
     * Dragging task from one status to an other is working
     *  Task: TransferThisTask from To Do to In Progress (and back)
     */

    @Test
    void transferTaskWorking() {

    }

    /**
     * Edit task working
     */

    @Test
    void editTaskWorking() {

    }

    /**
     * Edit task: title can't be less than three character
     */

    @Test
    void taskTitleMinimumThreeChar() {

    }

    /**
     * Edit task not happening when changes are not saved
     */

    @Test
    void editingTaskWithoutSavingIsNotPossible() {

    }

    /**
     * Sprint progress by user story
     */

    @Test
    void sprintProgressByUserStory() {

    }

    /**
     * Sprint progress by value distribution
     */

    @Test
    void sprintProgressByValue() {

    }
}