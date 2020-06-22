package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UniqueProjectpage extends Basepage {

    // Statuses in BaseProjectForTest:

    // First column / container: To Do
    @FindBy(xpath = "//*[@id='root']//div[@class='scrum_table']/div[@class='project_column'][1]")
    private WebElement todoContainer;

    // Second column / container: In Progress
    @FindBy(xpath = "//*[@id='root']//div[@class='scrum_table']/div[@class='project_column'][2]")
    private WebElement inProgressContainer;

    // Third column / container: Done
    @FindBy(xpath = "//*[@id='root']//div[@class='scrum_table']/div[@class='project_column'][3]")
    private WebElement doneContainer;

    @FindBy(xpath = "//*[@id='root']//div[@class='scrum_table']/div[@class='project_column'][1]//div[@class='task_card']/div[contains(text(),'TransferThisTask')]")
    private WebElement transferThisTaskTitle;

    @FindBy(xpath = "//*[@id='root']//div[@class='scrum_table']/div[@class='project_column'][1]//div[@class='task_card']/div[contains(text(),'EditThisTask')]")
    private WebElement editThisTaskTitle;

    @FindBy(xpath = "//*[@id='root']//div[@class='scrum_table']/div[@class='project_column'][3]//div[@class='add_new_task']")
    private WebElement addNewTaskButtonInDoneStatus;

    @FindBy(xpath = "//*[@id='root']//div[@class='scrum_table']/div[@class='project_column'][3]//div[@class='add_new_task_container']/input")
    private WebElement addNewTaskInputInDoneStatus;

    @FindBy(xpath = "//*[@id='root']//div[@class='scrum_table']/div[@class='project_column'][3]//div[@class='add_new_task_btn']")
    private WebElement addNewTaskSubmitButtonInDoneStatus;

    // Error window message
    @FindBy(xpath = "//div[@class='ant-modal-content']//span[contains(text(),'please minimum 3 character!')]")
    private WebElement errorMessage;

    // Error window close button (X)
    @FindBy(xpath = "//div[@class='ant-modal-content']//span[@aria-label='close']")
    private WebElement errorWindowCloseButton;

    @FindBy(xpath = "//*[@id='add_status_icon']")
    private WebElement addNewStatusIcon;

    @FindBy(xpath = "//*[@id='root']//div[@class='scrum_table']/div[4]//input[@class='add_new_column_text']")
    private WebElement addNewStatusInputField;

    @FindBy(xpath = "//*[@id='root']//div[@class='scrum_table']/div[4]//div[@class='add_new_column_btn']")
    private WebElement addNewStatusSubmitButton;

    @FindBy(xpath = "//*[@id='root']//span[@aria-label='usergroup-add']")
    private WebElement addNewParticipantButton;

    // Pop-up window: add new participant
    @FindBy(xpath = "//input[@role='combobox']")
    private WebElement getAddNewParticipantInputField;

    // Pop-up window: add new participant
    @FindBy(xpath = "//span[@aria-label='user-add']")
    private WebElement getAddNewParticipantGreenManButton;

    // Pop-up window: add new participant - look for this name after added new participant:
    @FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='participant_users']//h3[contains(text(),'zsana')]")
    private WebElement getNewParticipantName;

    // Pop-up window: add new participant
    @FindBy(xpath = "//div[@class='ant-modal-content']/button[@aria-label='Close']")
    private WebElement closeAddNewParticipantWindow;

    // Send project by e-mail icon
    @FindBy(xpath = "//*[@id='root']//span[@aria-label='mail']")
    private  WebElement sendEmailButton;

    // Pop-up window: send email
    @FindBy(xpath = "//div[@class='ant-modal-content']/button[@aria-label='Close']")
    private WebElement closeSendEmailWindow;

    // Pop-up window: send email
    @FindBy(xpath = "//div[@class='ant-modal-content']//input[@placeholder='e-mail']")
    private WebElement sendEmailInputField;

    // Pop-up window: send email
    @FindBy(xpath = "//div[@class='ant-modal-content']//button[@class='ant-btn']")
    private WebElement sendEmailPopUpWindowButton;

    // Pop-up window after sending the email
    @FindBy(xpath = "//span[contains(text(),'Successful e-mail sending')]")
    private WebElement messageOfSuccessfulEmailSending;

    // Close button of pop-up window after sending the email
    @FindBy(xpath = "//div[@class='ant-modal-content'][3]//span[@class='ant-modal-close-x']")
    private WebElement closeMessageOfSuccessfulEmail;

    // Limit In Progress task count icon
    @FindBy(xpath = "//*[@id='root']//span[@aria-label='file-excel']")
    private WebElement limitInProgressTaskCount;

    // Div container to transfer task - grab the title to identify the task container
    @FindBy(xpath = "//*[@id='root']//div[@class='task_card']//div[contains(text(),'TransferThisTask')]")
    private WebElement transferThisTask;

    // Edit task button - EditThisTask
    @FindBy(xpath = "//*[@id='root']//div[contains(text(),'EditThisTask')]/preceding-sibling::div[1]//span[@aria-label='form']")
    private WebElement editThisTaskEditButton;

    @FindBy(xpath = "//div[@class='ant-modal-content']//input[@class='text_input title']")
    private WebElement editThisTaskTitleInput;

    // This button is the input-title button - following sibling
    @FindBy(xpath = "//div[@class='ant-modal-content']//input[@class='text_input title']/following-sibling::*[1]")
    private WebElement editThisTaskTitleSaveButton;

    @FindBy(xpath = "//div[@class='ant-modal-content']//textarea[@class='text_input userStory']")
    private WebElement editThisTaskDescriptionInput;

    // This button is the save button of description- following sibling
    @FindBy(xpath = "//div[@class='ant-modal-content']//textarea[@class='text_input userStory']/following-sibling::*[1]")
    private WebElement editThisTaskDescriptionSaveButton;

    @FindBy(xpath = "//div[@class='task_data_selector']/label[contains(text(),'Priority: ')]/following-sibling::*[1]")
    private WebElement editThisTaskPriorityInput;

    // This button is the save button of priority - following sibling
    @FindBy(xpath = "//div[@class='task_data_selector']/label[contains(text(),'Priority: ')]/following-sibling::*[2]")
    private WebElement editThisTaskPrioritySaveButton;

    @FindBy(xpath = "//div[@class='task_data_selector']/label[contains(text(),'Owner: ')]/following-sibling::*[1]")
    private WebElement editThisTaskOwnerInput;

    // This button is the save button for owner - following sibling
    @FindBy(xpath = "//div[@class='task_data_selector']/label[contains(text(),'Owner: ')]/following-sibling::*[2]")
    private WebElement editThisTaskOwnerSaveButton;

    @FindBy(xpath = "//div[@class='task_data_selector']/label[contains(text(),'Deadline: ')]/following-sibling::*[1]")
    private WebElement editThisTaskDeadlineInput;

    // This button is the save button for deadline - following sibling
    @FindBy(xpath = "//div[@class='task_data_selector']/label[contains(text(),'Deadline: ')]/following-sibling::*[2]")
    private WebElement editThisTaskDeadlineSaveButton;

    // X in the corner to close edit window:
    @FindBy(xpath = "//div[@class='ant-modal-content']//span[@aria-label='close']")
    private WebElement editThisTaskCloseWindowButton;

    // Sprint progress by user story
    @FindBy(xpath = "//*[id='root']//div[@class='chart_box'][1]/svg")
    private WebElement userStoryProgressChart;

    // Sprint progress by value
    @FindBy(xpath = "//*[id='root']//div[@class='chart_box'][2]/svg")
    private WebElement valueProgressChart;

    // Task distribution container / need owner
    @FindBy(xpath = "//div[@class='task_distribution_container']/div[contains(text(),'need owner')]")
    private WebElement needOwnerTask;

    // Edit this task owner: zsana 6 - after editing the task, check the distribution:
    @FindBy (xpath = "//div[@class='task_distribution_container']/div[contains(text(),'zsana6')]")
    private WebElement zsana6Task;


    void addNewStatus(String statusName) {
        addNewStatusIcon.click();
        addNewStatusInputField.sendKeys(statusName);
        addNewStatusSubmitButton.click();
    }

    void addNewTask(String taskName) {
        addNewTaskButtonInDoneStatus.click();
        for (int i = 0; i < 10; i++) {
            try {
                getWait().until(ExpectedConditions.visibilityOf(addNewTaskInputInDoneStatus));
            } catch (NoSuchElementException nse) {}
        }
        addNewTaskInputInDoneStatus.click();
        writeIntoInputField(addNewTaskInputInDoneStatus, taskName);
        for (int i = 0; i < 10; i++) {
            try {
                getWait().until(ExpectedConditions.visibilityOf(addNewTaskSubmitButtonInDoneStatus));
            } catch (NoSuchElementException nse) {}
        }
        clickOnElement(addNewTaskSubmitButtonInDoneStatus);
    }

    void deleteTask(WebElement task) {
        WebElement parent = task.findElement(By.xpath("./.."));
        WebElement bin = parent.findElement(By.className("status_tool_container")).findElement(By.xpath(".//span[@aria-label='delete']"));
        getWait().until(ExpectedConditions.visibilityOf(bin));
        bin.click();
        getWait().until(ExpectedConditions.invisibilityOf(task));
    }

    void deleteStatus(WebElement status) {
        WebElement grandParent = status.findElement(By.xpath("./..")).findElement(By.xpath("./.."));
        WebElement bin = grandParent.findElement(By.className("status_tool_container")).findElement(By.xpath("./span"));
        getWait().until(ExpectedConditions.visibilityOf(bin));
        bin.click();
        getWait().until(ExpectedConditions.invisibilityOf(status));
    }

    WebElement getTodoContainer() {
        return todoContainer;
    }

    WebElement getInProgressContainer() {
        return inProgressContainer;
    }

    WebElement getDoneContainer() {
        return doneContainer;
    }

    public WebElement getTransferThisTaskTitle() {
        return transferThisTaskTitle;
    }

    public WebElement getEditThisTaskTitle() {
        return editThisTaskTitle;
    }

    public WebElement getAddNewTaskButtonInDoneStatus() {
        return addNewTaskButtonInDoneStatus;
    }

    public WebElement getAddNewTaskInputInDoneStatus() {
        return addNewTaskInputInDoneStatus;
    }

    public WebElement getAddNewTaskSubmitButtonInDoneStatus() {
        return addNewTaskSubmitButtonInDoneStatus;
    }

    public WebElement getAddNewStatusIcon() {
        return addNewStatusIcon;
    }

    public WebElement getAddNewStatusInputField() {
        return addNewStatusInputField;
    }

    public WebElement getAddNewStatusSubmitButton() {
        return addNewStatusSubmitButton;
    }

    public WebElement getAddNewParticipantButton() {
        return addNewParticipantButton;
    }

    public WebElement getGetAddNewParticipantInputField() {
        return getAddNewParticipantInputField;
    }

    public WebElement getGetAddNewParticipantGreenManButton() {
        return getAddNewParticipantGreenManButton;
    }

    public WebElement getGetNewParticipantName() {
        return getNewParticipantName;
    }

    public WebElement getCloseAddNewParticipantWindow() {
        return closeAddNewParticipantWindow;
    }

    public WebElement getSendEmailButton() {
        return sendEmailButton;
    }

    public WebElement getCloseSendEmailWindow() {
        return closeSendEmailWindow;
    }

    public WebElement getSendEmailInputField() {
        return sendEmailInputField;
    }

    public WebElement getSendEmailPopUpWindowButton() {
        return sendEmailPopUpWindowButton;
    }

    public WebElement getMessageOfSuccessfulEmailSending() {
        return messageOfSuccessfulEmailSending;
    }

    public WebElement getCloseMessageOfSuccessfulEmail() {
        return closeMessageOfSuccessfulEmail;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getErrorWindowCloseButton() {
        return errorWindowCloseButton;
    }

    public WebElement getLimitInProgressTaskCount() {
        return limitInProgressTaskCount;
    }

    public WebElement getTransferThisTask() {
        return transferThisTask;
    }

    public WebElement getEditThisTaskEditButton() {
        return editThisTaskEditButton;
    }

    public WebElement getEditThisTaskTitleInput() {
        return editThisTaskTitleInput;
    }

    public WebElement getEditThisTaskTitleSaveButton() {
        return editThisTaskTitleSaveButton;
    }

    public WebElement getEditThisTaskDescriptionInput() {
        return editThisTaskDescriptionInput;
    }

    public WebElement getEditThisTaskDescriptionSaveButton() {
        return editThisTaskDescriptionSaveButton;
    }

    public WebElement getEditThisTaskPriorityInput() {
        return editThisTaskPriorityInput;
    }

    public WebElement getEditThisTaskPrioritySaveButton() {
        return editThisTaskPrioritySaveButton;
    }

    public WebElement getEditThisTaskOwnerInput() {
        return editThisTaskOwnerInput;
    }

    public WebElement getEditThisTaskOwnerSaveButton() {
        return editThisTaskOwnerSaveButton;
    }

    public WebElement getEditThisTaskDeadlineInput() {
        return editThisTaskDeadlineInput;
    }

    public WebElement getEditThisTaskDeadlineSaveButton() {
        return editThisTaskDeadlineSaveButton;
    }

    public WebElement getEditThisTaskCloseWindowButton() {
        return editThisTaskCloseWindowButton;
    }

    public WebElement getUserStoryProgressChart() {
        return userStoryProgressChart;
    }

    public WebElement getValueProgressChart() {
        return valueProgressChart;
    }

    public WebElement getNeedOwnerTask() {
        return needOwnerTask;
    }

    public WebElement getZsana6Task() {
        return zsana6Task;
    }
}
