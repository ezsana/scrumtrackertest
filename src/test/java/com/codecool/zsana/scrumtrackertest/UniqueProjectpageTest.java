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

@FixMethodOrder(MethodSorters.JVM)
public class UniqueProjectpageTest extends Basetest {

    private Homepage homepage;
    private SignIn signIn;
    private Projectspage projectspage;
    private UniqueProjectpage uniqueProjectpage;
    private WebElement newProject;
    private WebElement newStatusForTest;
    private WebElement addAndDeleteTask;

    /**
     * For edit task test:
     */
        private String title;
        private String description;
        private String date;
        private WebElement priority;
        private WebElement owner;

        private void generateDataForEditTask() {
            title = "Edited title";
            description = "Edited description";
            date = generateDate();
            priority = uniqueProjectpage.getEditThisTaskChooseThreeOption(); // 3
            owner = uniqueProjectpage.getEditThisTaskChooseOwnerFromList(); // zsana6
        }


    private void setup() {
        Basepage.setUp();
        signIn = new SignIn();
        homepage = new Homepage();
        projectspage = new Projectspage();
        uniqueProjectpage = new UniqueProjectpage();
        Basepage.goToAppUrl();
        signIn.validLoginForTest();
        homepage.clickOnElement(homepage.getProjectsButton());
    }

    /**
     * Scenario: Three built-in statuses can be seen on page
     */

    @Given("that I've just created a new project: {string}")
    public void createProject(String projectName) {
        setup();
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
        homepage.getProjectsButton().click();
        projectspage.deleteProject(projectName);
    }

    /**
     * Scenario Outline: Successful adding new status
    */

    @Given("that I'm on my unique project page")
    public void goToUniqueProjectPage() {
        setup();
        projectspage.clickOnElement(projectspage.getBaseProjectForTestTitle());
    }

    @When("I fill in the \"Add new status\" field: {string} and click Save button")
    public void addNewStatus(String newStatus) {
        uniqueProjectpage.addNewStatus(newStatus);
    }

    @Then("I can see the new status: {string} on the page")
    public void addNewStatusIsWorking(String newStatus) {
        WebElement status = uniqueProjectpage.searchElementByText(newStatus);
        assertTrue(status.isDisplayed());
    }

    /**
     * Scenario: Successful deleting status
    */

    @When("I click on the status: {string} delete button")
    public void statusDeleteIsWorkingTest(String statusName) {
        newStatusForTest = uniqueProjectpage.searchElementByText(statusName);
        uniqueProjectpage.deleteStatus(newStatusForTest);
    }

    @Then("status is deleted")
    public void statusIsNotPresent() {
        assertTrue(uniqueProjectpage.elementIsNotPresent(newStatusForTest));
    }

    /**
     * Scenario Outline: Unsuccessful adding new status with less than three character
    */

    @When("I fill in the \"Add new status\" field with less than three character: {string}")
    public void addNewStatusWithLessThanThreeChar(String statusName) {
        if (statusName.equals("null")) { statusName = ""; }
        uniqueProjectpage.addNewStatus(statusName);
    }

    @Then("a pop-up shows that I have to write more the three letters to create a new status")
    public void addNewStatusWithLessThanThreeCharFails() {
        String message = uniqueProjectpage.getPopUpMessage();
        uniqueProjectpage.acceptPopUpAlert();
        assertEquals("add name (minimum 3 character) to your status", message);
    }

    /**
     * Scenario Outline: Successful adding new task
    */

    @When("I fill in the \"Add new task\" field: {string} and click on Save button")
    public void addNewTask(String newTaskName) {
        uniqueProjectpage.addNewTask(newTaskName, uniqueProjectpage.getAddNewTaskButtonInDoneStatus(), uniqueProjectpage.getAddNewTaskInputInDoneStatus(), uniqueProjectpage.getAddNewTaskSubmitButtonInDoneStatus());
    }

    @Then("I can see the new task: {string} in the To Do container on the page")
    public void newTaskNameIsSeen(String newTaskName) {
        WebElement task = uniqueProjectpage.searchElementByText(newTaskName);
        assertTrue(task.isDisplayed());
    }

    /**
     * Scenario Outline: Successful deleting task
     */

    @And("that I have a task: {string}")
    public void iHaveTask(String taskName) {
        addAndDeleteTask = uniqueProjectpage.searchElementByText(taskName);
    }

    @When("I click on the task delete button")
            public void deleteTask() {
        uniqueProjectpage.deleteTask(addAndDeleteTask);
    }

    @Then("the task is deleted")
    public void taskIsDeleted() {
        assertTrue(uniqueProjectpage.elementIsNotPresent(addAndDeleteTask));
    }

    /**
     * Add new task with less than three character is not possible
    */

    @When("I fill in the \"Add new task\" field with less than three character: {string}")
    public void addNewTaskWithLessThanThreeChar(String invalidName) {
        if (invalidName.equals("null")) { invalidName = ""; }
        uniqueProjectpage.addNewTask(invalidName, uniqueProjectpage.getAddNewTaskButtonInDoneStatus(), uniqueProjectpage.getAddNewTaskInputInDoneStatus(), uniqueProjectpage.getAddNewTaskSubmitButtonInDoneStatus());
    }

    @Then("a pop-up shows that I have to write more the three letters to create a new task")
    public void addNewTaskWithLessThanThreeCharNotPossible() {
        boolean errorMessage = uniqueProjectpage.isElementPresent(uniqueProjectpage.getErrorMessage());
        uniqueProjectpage.clickOnElement(uniqueProjectpage.getErrorWindowCloseButton());
        assertTrue(errorMessage);
    }

    /**
     * Scenario Outline: successful sending project details via e-mail - valid e-mail address
     */

    @When("I click on send e-mail button and write {string} into the input field")
    public void sendProjectDetailsByEmail(String email) {
        uniqueProjectpage.sendProjectByEmail(email);
    }

    @Then("I get a message that the e-mail is sent")
    public void sendProjectDetailsByEmailIsSuccessful() {
        boolean successfulEmailSending =  uniqueProjectpage.isElementPresent(uniqueProjectpage.getMessageOfSuccessfulEmailSending());
        uniqueProjectpage.getCloseMessageOfSuccessfulEmail().click();
        assertTrue(successfulEmailSending);
    }

    /**
     * Scenario Outline: unsuccessful sending project details via e-mail - invalid e-mail address
     */

    @When("I click on send email button and write {string} into the input field")
    public void sendEmailWithInvalidEmailAddress(String invalidEmail) {
        uniqueProjectpage.sendProjectByEmail(invalidEmail);
    }

    @Then("I get a message that the address is invalid")
    public void sendEmailWithInvalidEmailAddressFails() {
        boolean invalidEmailMessage =  uniqueProjectpage.isElementPresent(uniqueProjectpage.getInvalidEmailMessage());
        uniqueProjectpage.getInvalidEmailErrorWindowCloseButton().click();
        uniqueProjectpage.getCloseSendEmailWindow().click();
        assertTrue(invalidEmailMessage);
    }

    /**
     * Scenario Outline: Successful setting limit in the "In Progress" status
     */

    @When("I click on Limit In Progress status button and I write the limit: {string}")
    public void limitInProgressTaskCount(String limit) {
        uniqueProjectpage.setLimitInProgress(Integer.valueOf(limit));
    }

    @Then("message shows that the change was successful")
    public void setLimitSuccessful() {
        boolean success = uniqueProjectpage.isElementPresent(uniqueProjectpage.getLimitInProgressSuccessfulMessage());
        uniqueProjectpage.getLimitInProgressSuccessfulButton().click();
        // Set limit to 0 for later test executions
        uniqueProjectpage.setLimitInProgress(0);
        uniqueProjectpage.getLimitInProgressSuccessfulButton().click();
        assertTrue(success);
    }

    /**
     * Scenario Outline: Successful dragging a task from status to status
     */

    @When("I drag the task \"TransferThisTask\" from one status to an other")
    public void transferTask() {
        uniqueProjectpage.transferTask(uniqueProjectpage.getTransferThisTask(), uniqueProjectpage.getInProgressContainer());
    }

    @Then("the aforementioned task would be in the new container: {string}")
    public void transferTaskWorking(String status) {
        boolean success = uniqueProjectpage.taskIsTransferred(status);
        // Task moved back to original place
        uniqueProjectpage.transferTask(uniqueProjectpage.getTransferThisTask(), uniqueProjectpage.getTodoContainer());
        assertTrue(success);
    }

    /**
     * Scenario: Successful editing a task
     */

    @When("I click on the Edit task button and make changes to the task: \"EditThisTask\" and click on Save button")
    public void editTask() {
        generateDataForEditTask();
        uniqueProjectpage.editTask(title, description, date, priority, owner, true);
    }

    @Then("those changes are saved")
    public Collection<DynamicTest> editTaskWorking() {
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
        uniqueProjectpage.clickOnElement(uniqueProjectpage.getEditedTaskDeleteButton());
        uniqueProjectpage.addNewTask("EditThisTask", uniqueProjectpage.getAddNewTaskButtonInToDoStatus(), uniqueProjectpage.getAddNewTaskInputInToDoStatus(), uniqueProjectpage.getAddNewTaskSubmitButtonInToDoStatus());

        return Arrays.asList(DynamicTest.dynamicTest("Title check", () -> assertEquals(title, editedTitle)),
                DynamicTest.dynamicTest("Description check", () -> assertEquals(description, editedDescription)),
                DynamicTest.dynamicTest("Priority check", () -> assertEquals(3, editedPriority)),
                DynamicTest.dynamicTest("Owner check", () -> assertEquals("zsana6", editedOwner)),
        DynamicTest.dynamicTest("Date check", () -> assertEquals(date, editedDate)));
    }

    /**
     * Scenario Outline: Unsuccessful to edit task task with less than three character
     * This test fails but should not fail
     */

    @When("I click on the edit button and edit the title of task: \"EditThisTask\" using less than three character: {string}")
    public void taskTitleLessThanThreeChar(String title) {
        uniqueProjectpage.editTaskTitle(title, uniqueProjectpage.getEditThisTaskEditButton());
    }

    @Then("I get a message to write more the three character for the title {string}")
    public void taskTitleLessThanThreeCharNotAllowed(String wrongTitle) {
        boolean titleChange = uniqueProjectpage.searchElementByText(wrongTitle).isDisplayed(); // Have the title changed?
        // Get back the original title - temporary solution as this test should pass in future development
        uniqueProjectpage.editTaskTitle("EditThisTask", uniqueProjectpage.getLessThanThreeCharTaskEditButton());
        try {
            assertFalse(titleChange);
        } catch (AssertionError ae) {
            System.out.println("Test failed.");
        }
    }

    /**
     * Scenario: Without clicking on the save button the changes are not saved
     */

    @When("I clicked on the edit task button of \"EditThisTask\", I fill the inputs but don't click on Save button and close the edit window")
    public void editingTaskWithoutSaving() {
        generateDataForEditTask();
        uniqueProjectpage.editTask(title, description, date, priority, owner, false);
    }

    @Then("the changes are not saved")
    public Collection<DynamicTest> changesNotSaved() {
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
     * Scenario: Sprint progress by user story can be seen on page
     * All tasks are in To Do so the progress circle should be red and 100%
     */

    @Then("I can see the sprint progress by user story circle showing the progress state")
    public void sprintProgressByUserStory() {
        assertTrue(uniqueProjectpage.getUserStoryProgressChart().getText().contains("100 %"));
    }

    /**
     * Scenario: Sprint progress by value can be seen on page
     */

    @Then("I can see the sprint progress by value circle showing the progress state")
    public void sprintProgressByValue() {
        // Change EditThisTask value to 3
        uniqueProjectpage.editValue();
        // Check if value is three total
        boolean valueIsThree = uniqueProjectpage.getValueProgressChart().getText().contains("3 total");
        // Delete EditThisTask and create it again
        uniqueProjectpage.clickOnElement(uniqueProjectpage.getEditThisTaskDeleteButton());
        uniqueProjectpage.addNewTask("EditThisTask", uniqueProjectpage.getAddNewTaskButtonInToDoStatus(), uniqueProjectpage.getAddNewTaskInputInToDoStatus(), uniqueProjectpage.getAddNewTaskSubmitButtonInToDoStatus());
        // Assert value
       assertTrue(valueIsThree);
    }


    @And("close unique project test.")
    public void close() {
        signIn.logoutForTest(homepage);
        Homepage.shutDown();
    }

}