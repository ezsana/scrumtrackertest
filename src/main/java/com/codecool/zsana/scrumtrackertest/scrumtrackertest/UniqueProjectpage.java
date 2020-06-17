package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UniqueProjectpage extends Basepage {

    // Statuses for the freshly created project

    @FindBy(xpath = "//*[contains(text(),'To Do')]")
    private WebElement todoContainer;

    @FindBy(xpath = "//*[contains(text(),'In Progress')]")
    private WebElement inProgressContainer;

    @FindBy(xpath = "//*[contains(text(),'Done')]")
    private WebElement doneContainer;

    @FindBy(xpath = "//div[@class='sc-AxirZ jqONUp add_new_status adder_component']/input[@class='sc-AxiKw hzGrch']")
    private WebElement addNewStatusInput;

    @FindBy(xpath = "//div[@class='sc-AxirZ jqONUp add_new_task adder_component']/input[@class='sc-AxiKw hzGrch']")
    private WebElement addNewTaskInput;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[3]/div[1]/span")
    private WebElement addNewStatusSubmitButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[3]/div[2]/span")
    private WebElement addNewTaskSubmitButton;

    @FindBy(xpath = "")
    private WebElement todoTaskDescription;


    public WebElement getTodoContainer() {
        return todoContainer;
    }

    public WebElement getInProgressContainer() {
        return inProgressContainer;
    }

    public WebElement getDoneContainer() {
        return doneContainer;
    }

    public WebElement getAddNewStatusInput() {
        return addNewStatusInput;
    }

    public WebElement getAddNewTaskInput() {
        return addNewTaskInput;
    }

    public WebElement getAddNewStatusSubmitButton() {
        return addNewStatusSubmitButton;
    }

    public WebElement getAddNewTaskSubmitButton() {
        return addNewTaskSubmitButton;
    }

    public void addNewStatus(String statusName) {
        writeIntoInputField(addNewStatusInput, statusName);
        clickOnElement(addNewStatusSubmitButton);
    }

    public void addNewTask(String taskName) {
        writeIntoInputField(addNewTaskInput, taskName);
        clickOnElement(addNewTaskSubmitButton);
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
