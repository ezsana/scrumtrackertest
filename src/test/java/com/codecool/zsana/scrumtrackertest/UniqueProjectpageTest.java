package com.codecool.zsana.scrumtrackertest;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.Collection;

@FixMethodOrder(MethodSorters.JVM)
class UniqueProjectpageTest extends Basetest {

    private Homepage homepage;
    private SignIn signIn;
    private Projectspage projectspage;
    private UniqueProjectpage uniqueProjectpage;
    private WebElement newProject;

    /**
     * Scenario: Three built-in statuses can be seen on page
     */


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

    @Given("that I've just created a new project: {string}")
    public void createProject(String projectName) {
        Basepage.setUp();
        signIn = new SignIn();
        homepage = new Homepage();
        projectspage = new Projectspage();
        uniqueProjectpage = new UniqueProjectpage();
        Basepage.goToAppUrl();
        signIn.validLoginForTest();
        homepage.clickOnElement(homepage.getProjectsButton());
        newProject = projectspage.createNewProject(projectName);
    }

    @When("I click on the newly created project")
    public void openProject() {
        newProject.click();
    }

    @Then("the page of this project shows up with three statuses: To Do; In Progress; Done")
    @TestFactory
    public Collection<DynamicTest> freshlyCreatedProjectPageTest() {
        return Arrays.asList(DynamicTest.dynamicTest("To Do", () -> assertTrue(uniqueProjectpage.isElementPresent(uniqueProjectpage.getTodoContainer()))),
                DynamicTest.dynamicTest("In Progress", () -> assertTrue(uniqueProjectpage.isElementPresent(uniqueProjectpage.getInProgressContainer()))),
                DynamicTest.dynamicTest("Done", () -> assertTrue(uniqueProjectpage.isElementPresent(uniqueProjectpage.getDoneContainer()))));
    }

    @Then("I delete the project created for the test: {string}")
    public void deleteProject(String projectName) {
        projectspage.deleteProject(projectName);
    }

    @And("close unique project test.")
    public void close() {
        signIn.logoutForTest(homepage);
        Homepage.shutDown();
    }




    /**
     * Add new status is working
     *  New status: On Hold
    */


    void addNewStatusIsWorkingTest() {
        uniqueProjectpage.addNewStatus("On Hold");
        WebElement status = uniqueProjectpage.searchElementByText("On Hold");
        assertTrue(status.isDisplayed());
    }

    /**
     * Delete status is working
     *  Deleted status: On Hold
    */

    void statusDeleteIsWorkingTest() {
        WebElement status = uniqueProjectpage.searchElementByText("On Hold");
        uniqueProjectpage.deleteStatus(status);
        assertTrue(uniqueProjectpage.elementIsNotPresent(status));
    }

    /**
     * Add new status with less than three character is not possible
    */


    void addNewStatusWithLessThanThreeChar() {
        uniqueProjectpage.addNewStatus("ne");
        String message = uniqueProjectpage.getPopUpMessage();
        uniqueProjectpage.acceptPopUpAlert();
        assertEquals("add name (minimum 3 character) to your status", message);
    }

    /**
     * Add new task in To Do container
     *  Task name: AddAndDeleteThisTask
    */


    void addNewTaskIsWorkingTest() {
        uniqueProjectpage.addNewTask("AddAndDeleteThisTask", uniqueProjectpage.getAddNewTaskButtonInDoneStatus(), uniqueProjectpage.getAddNewTaskInputInDoneStatus(), uniqueProjectpage.getAddNewTaskSubmitButtonInDoneStatus());
        WebElement task = uniqueProjectpage.searchElementByText("AddAndDeleteThisTask");
        assertTrue(task.isDisplayed());
    }

    /**
     * Delete task is working
     *  task to delete: AddAndDeleteThisTask
     */


    void deleteTaskIsWorkingTest() {
        WebElement task = uniqueProjectpage.searchElementByText("AddAndDeleteThisTask");
        uniqueProjectpage.deleteTask(task);
        assertTrue(uniqueProjectpage.elementIsNotPresent(task));
    }

    /**
     * Add new task with less than three character is not possible
    */


    void addNewTaskWithLessThanThreeChar() {
        uniqueProjectpage.addNewTask("ne", uniqueProjectpage.getAddNewTaskButtonInDoneStatus(), uniqueProjectpage.getAddNewTaskInputInDoneStatus(), uniqueProjectpage.getAddNewTaskSubmitButtonInDoneStatus());
        boolean errorMessage = uniqueProjectpage.isElementPresent(uniqueProjectpage.getErrorMessage());
        uniqueProjectpage.clickOnElement(uniqueProjectpage.getErrorWindowCloseButton());
        assertTrue(errorMessage);
    }

    /**
     * Send the project details by e-mail is working
     */


    void sendProjectDetailsByEmail() {
        uniqueProjectpage.sendProjectByEmail("zsana6@zsana6.com");
        boolean successfulEmailSending =  uniqueProjectpage.isElementPresent(uniqueProjectpage.getMessageOfSuccessfulEmailSending());
        uniqueProjectpage.getCloseMessageOfSuccessfulEmail().click();
        assertTrue(successfulEmailSending);
    }

    /**
     * Send project by e-mail is not possible with invalid e-mail address
     */


    void sendEmailWithInvalidEmailAddress() {
        uniqueProjectpage.sendProjectByEmail("invalid address");
        boolean invalidEmail =  uniqueProjectpage.isElementPresent(uniqueProjectpage.getInvalidEmailMessage());
        uniqueProjectpage.getInvalidEmailErrorWindowCloseButton().click();
        uniqueProjectpage.getCloseSendEmailWindow().click();
        assertTrue(invalidEmail);
    }

    /**
     * Limit the In Progress task count is working
     */


    void limitInProgressTaskCount() {
        uniqueProjectpage.setLimitInProgress(2);
        boolean success = uniqueProjectpage.isElementPresent(uniqueProjectpage.getLimitInProgressSuccessfulMessage());
        uniqueProjectpage.getLimitInProgressSuccessfulButton().click();
        // Set limit to 0 for later test executions
        uniqueProjectpage.setLimitInProgress(0);
        uniqueProjectpage.getLimitInProgressSuccessfulButton().click();
        assertTrue(success);
    }

    /**
     * Dragging task from one status to an other is working
     *  Task: TransferThisTask from To Do to In Progress (and back)
     */


    void transferTaskWorking() {
        uniqueProjectpage.transferTask(uniqueProjectpage.getTransferThisTask(), uniqueProjectpage.getInProgressContainer());
        boolean success = uniqueProjectpage.taskIsTransferred("In Progress");
        // Task moved back to original place
        uniqueProjectpage.transferTask(uniqueProjectpage.getTransferThisTask(), uniqueProjectpage.getTodoContainer());
        assertTrue(success);
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


    void taskTitleMinimumThreeChar() {
        String title = "uu";
        uniqueProjectpage.editTaskTitle(title, uniqueProjectpage.getEditThisTaskEditButton());
        boolean titleChange = uniqueProjectpage.searchElementByText(title).isDisplayed(); // Have the title changed?
        // Get back the original title - temporary solution as this test should pass in future development
        uniqueProjectpage.editTaskTitle("EditThisTask", uniqueProjectpage.getLessThanThreeCharTaskEditButton());
        assertFalse(titleChange);
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
     * All tasks are in To Do so the progress circle should be red and 100%
     */


    void sprintProgressByUserStory() {
        assertTrue(uniqueProjectpage.getUserStoryProgressChart().getText().contains("100 %"));
    }

    /**
     * Sprint progress by value distribution
     */


    void sprintProgressByValue() {
        // Change EditThisTask value to 3
        uniqueProjectpage.editValue();
        // Check if value is three total
        boolean valueIsThree = uniqueProjectpage.getValueProgressChart().getText().contains("3 total");
        // Delete EditThisTask and create it again
        uniqueProjectpage.clickOnElement(uniqueProjectpage.getEditThisTaskDeletebutton());
        uniqueProjectpage.addNewTask("EditThisTask", uniqueProjectpage.getAddNewTaskButtonInToDoStatus(), uniqueProjectpage.getAddNewTaskInputInToDoStatus(), uniqueProjectpage.getAddNewTaskSubmitButtonInToDoStatus());
        // Assert value
       assertTrue(valueIsThree);
    }
}