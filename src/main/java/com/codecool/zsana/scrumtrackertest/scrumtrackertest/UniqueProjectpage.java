package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//*[@id='root']//div[@class='scrum_table']/div[@class='project_column'][1]//div[@class='task_card']/div[contains(text(),'ShareThisTask')]")
    private WebElement shareThisTaskTitle;

    @FindBy(xpath = "//*[@id='root']//div[@class='scrum_table']/div[@class='project_column'][1]//div[@class='task_card']/div[contains(text(),'SendThisTaskByEmail')]")
    private WebElement sendThisTaskByEmailTitle;

    @FindBy(xpath = "//*[@id='root']//div[@class='scrum_table']/div[@class='project_column'][3]//div[@class='add_new_task']")
    private WebElement addNewTaskButtonInDoneStatus;

    @FindBy(xpath = "//*[@id='root']//div[@class='scrum_table']/div[@class='project_column'][3]//input[class='add_new_task_text']")
    private WebElement addNewTaskInputInDoneStatus;

    @FindBy(xpath = "//*[@id='root']//div[@class='scrum_table']/div[@class='project_column'][3]//input[class='add_new_task_btn']")
    private WebElement addNewTaskSubmitButtonInDoneStatus;

    @FindBy(xpath = "//*[@id='add_status_icon']")
    private WebElement addNewStatusIcon;

    @FindBy(xpath = "//*[@id='root']//div[@class='scrum_table']/div[4]//input[@class='add_new_column_text']")
    private WebElement addNewStatusInputField;

    @FindBy(xpath = "//*[@id='root']//div[@class='scrum_table']/div[4]//input[@class='add_new_column_btn']")
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

    // Pop-up window after sending the email
    @FindBy(xpath = "//div[@class='ant-modal-content'][3]//span[@class='ant-modal-close-x']")
    private WebElement closeMessageOfSuccessfulEmail;

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


    public WebElement getTodoContainer() {
        return todoContainer;
    }

    public WebElement getInProgressContainer() {
        return inProgressContainer;
    }

    public WebElement getDoneContainer() {
        return doneContainer;
    }

    public WebElement getTransferThisTaskTitle() {
        return transferThisTaskTitle;
    }

    public WebElement getEditThisTaskTitle() {
        return editThisTaskTitle;
    }

    public WebElement getShareThisTaskTitle() {
        return shareThisTaskTitle;
    }

    public WebElement getSendThisTaskByEmailTitle() {
        return sendThisTaskByEmailTitle;
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

    public void addNewStatus(String statusName) {
        writeIntoInputField(addNewStatusIcon, statusName);
        clickOnElement(addNewStatusSubmitButton);
    }

    public void addNewTask(String taskName) {
        writeIntoInputField(addNewTaskButtonInDoneStatus, taskName);
        clickOnElement(addNewTaskSubmitButtonInDoneStatus);
    }

    public void deleteTask(WebElement task) {
        WebElement grandParent = task.findElement(By.xpath("./..")).findElement(By.xpath("./.."));
        WebElement bin = grandParent.findElement(By.className("status_tool_container")).findElement(By.xpath("./span"));
        getWait().until(ExpectedConditions.visibilityOf(bin));
        bin.click();
        getWait().until(ExpectedConditions.invisibilityOf(task));
    }

    public void deleteStatus(WebElement status) {
        WebElement grandParent = status.findElement(By.xpath("./..")).findElement(By.xpath("./.."));
        WebElement bin = grandParent.findElement(By.className("status_tool_container")).findElement(By.xpath("./span"));
        getWait().until(ExpectedConditions.visibilityOf(bin));
        bin.click();
        getWait().until(ExpectedConditions.invisibilityOf(status));
    }
}
