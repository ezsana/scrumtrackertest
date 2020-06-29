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
        uniqueProjectpage.addNewTask("AddAndDeleteThisTask", uniqueProjectpage.getAddNewTaskButtonInDoneStatus(), uniqueProjectpage.getAddNewTaskInputInDoneStatus(), uniqueProjectpage.getAddNewTaskSubmitButtonInDoneStatus());
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
        uniqueProjectpage.addNewTask("ne", uniqueProjectpage.getAddNewTaskButtonInDoneStatus(), uniqueProjectpage.getAddNewTaskInputInDoneStatus(), uniqueProjectpage.getAddNewTaskSubmitButtonInDoneStatus());
        boolean errorMessage = uniqueProjectpage.isElementPresent(uniqueProjectpage.getErrorMessage());
        uniqueProjectpage.clickOnElement(uniqueProjectpage.getErrorWindowCloseButton());
        Assertions.assertTrue(errorMessage);
    }

    /**
     * Send the project details by e-mail is working
     */

    @Test
    void sendProjectDetailsByEmail() {
        uniqueProjectpage.sendProjectByEmail("zsana6@zsana6.com");
        boolean successfulEmailSending =  uniqueProjectpage.isElementPresent(uniqueProjectpage.getMessageOfSuccessfulEmailSending());
        uniqueProjectpage.getCloseMessageOfSuccessfulEmail().click();
        Assertions.assertTrue(successfulEmailSending);
    }

    /**
     * Send project by e-mail is not possible with invalid e-mail address
     */

    @Test
    void sendEmailWithInvalidEmailAddress() {
        uniqueProjectpage.sendProjectByEmail("invalid address");
        boolean invalidEmail =  uniqueProjectpage.isElementPresent(uniqueProjectpage.getInvalidEmailMessage());
        uniqueProjectpage.getInvalidEmailErrorWindowCloseButton().click();
        uniqueProjectpage.getCloseSendEmailWindow().click();
        Assertions.assertTrue(invalidEmail);
    }

    /**
     * Limit the In Progress task count is working
     */

    @Test
    void limitInProgressTaskCount() {
        uniqueProjectpage.setLimitInProgress(2);
        boolean success = uniqueProjectpage.isElementPresent(uniqueProjectpage.getLimitInProgressSuccessfulMessage());
        uniqueProjectpage.getLimitInProgressSuccessfulButton().click();
        // Set limit to 0 for later test executions
        uniqueProjectpage.setLimitInProgress(0);
        uniqueProjectpage.getLimitInProgressSuccessfulButton().click();
        Assertions.assertTrue(success);
    }

    /**
     * Dragging task from one status to an other is working
     *  Task: TransferThisTask from To Do to In Progress (and back)
     */

    @Test
    void transferTaskWorking() {
        uniqueProjectpage.transferTask(uniqueProjectpage.getTransferThisTask(), uniqueProjectpage.getInProgressContainer());
        boolean success = uniqueProjectpage.taskIsTransferred("In Progress");
        // Task moved back to original place
        uniqueProjectpage.transferTask(uniqueProjectpage.getTransferThisTask(), uniqueProjectpage.getTodoContainer());
        Assertions.assertTrue(success);
    }

    /**
     * Edit task working
     */

    @TestFactory
    Collection<DynamicTest> editTaskWorking() {
        String title = "Edited title";
        String description = "Edited description";
        String date = generateDate();
        WebElement priority = uniqueProjectpage.getEditThisTaskChooseThreeOption(); // 3
        WebElement owner = uniqueProjectpage.getEditThisTaskChooseOwnerFromList(); // zsana6
        uniqueProjectpage.editTask(title, description, date, priority, owner, true);
        //Open the edit task again
        uniqueProjectpage.clickOnElement(uniqueProjectpage.getEditedTaskEditButton());

        // Get all data
        String editedTitle = uniqueProjectpage.getTitleAfterEditTask();
        String editedDescription = uniqueProjectpage.getDescriptionAfterEditTask();
        int editedPriority = uniqueProjectpage.getPriorityAfterEditTask();
        String editedOwner = uniqueProjectpage.getOwnerAfterEditTask();
        String editedDate = uniqueProjectpage.getDeadlineAfterEditTask(date);

        //Close window
        uniqueProjectpage.clickOnElement(uniqueProjectpage.getEditThisTaskCloseWindowButton());

        // Change back the original values for later tests - delete EditThisTask and create it again
        uniqueProjectpage.clickOnElement(uniqueProjectpage.getEditedTaskDeletebutton());
        uniqueProjectpage.addNewTask("EditThisTask", uniqueProjectpage.getAddNewTaskButtonInToDoStatus(), uniqueProjectpage.getAddNewTaskInputInToDoStatus(), uniqueProjectpage.getAddNewTaskSubmitButtonInToDoStatus());

        return Arrays.asList(DynamicTest.dynamicTest("Title check", () -> assertEquals(title, editedTitle)),
                DynamicTest.dynamicTest("Description check", () -> assertEquals(description, editedDescription)),
                DynamicTest.dynamicTest("Priority check", () -> assertEquals(3, editedPriority)),
                DynamicTest.dynamicTest("Owner check", () -> assertEquals("zsana6", editedOwner)),
        DynamicTest.dynamicTest("Date check", () -> assertEquals(date, editedDate)));
    }

    /**
     * Edit task: title can't be less than three character
     * This test fails at the moment
     */

    @Test
    void taskTitleMinimumThreeChar() {
        String title = "uu";
        uniqueProjectpage.editTaskTitle(title, uniqueProjectpage.getEditThisTaskEditButton());
        boolean titleChange = uniqueProjectpage.searchElementByText(title).isDisplayed(); // Have the title changed?
        // Get back the original title - temporary solution as this test should pass in future development
        uniqueProjectpage.editTaskTitle("EditThisTask", uniqueProjectpage.getLessThanThreeCharTaskEditButton());
        Assertions.assertFalse(titleChange);
    }

    /**
     * Edit task not happening when changes are not saved
     */

    @TestFactory
    Collection<DynamicTest> editingTaskWithoutSavingIsNotPossible() {
        String title = "Edited title";
        String description = "Edited description";
        String date = generateDate();
        WebElement priority = uniqueProjectpage.getEditThisTaskChooseThreeOption(); // 3
        WebElement owner = uniqueProjectpage.getEditThisTaskChooseOwnerFromList(); // zsana6
        uniqueProjectpage.editTask(title, description, date, priority, owner, false);
        uniqueProjectpage.refreshPage();

        // Open edit task window again
        uniqueProjectpage.clickOnElement(uniqueProjectpage.getEditThisTaskEditButton());

        // Get all data
        String editedTitle = uniqueProjectpage.getTitleAfterEditTask();
        String editedDescription = uniqueProjectpage.getDescriptionAfterEditTask();
        int editedPriority = uniqueProjectpage.getPriorityAfterEditTask();
        String editedOwner = uniqueProjectpage.getOwnerAfterEditTask();
        String editedDate = uniqueProjectpage.getDeadlineAfterEditTask(date);

        // Close edit task window
        uniqueProjectpage.clickOnElement(uniqueProjectpage.getEditThisTaskCloseWindowButton());

        return Arrays.asList(DynamicTest.dynamicTest("Title check", () -> assertNotEquals(title, editedTitle)),
                DynamicTest.dynamicTest("Description check", () -> assertNotEquals(description, editedDescription)),
                DynamicTest.dynamicTest("Priority check", () -> assertNotEquals(3, editedPriority)),
                DynamicTest.dynamicTest("Owner check", () -> assertNotEquals("zsana6", editedOwner)),
                DynamicTest.dynamicTest("Date check", () -> assertNotEquals(date, editedDate)));
    }

    /**
     * Sprint progress by user story
     * All tasks are in To Do so the progress circle should be red az 100%
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