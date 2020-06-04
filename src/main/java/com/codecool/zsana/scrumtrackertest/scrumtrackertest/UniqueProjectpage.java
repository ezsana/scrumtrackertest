package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UniqueProjectpage extends Basepage {

    @FindBy(xpath = "")
    private WebElement todoContainer;

    @FindBy(xpath = "")
    private WebElement inProgressContainer;

    @FindBy(xpath = "")
    private WebElement doneContainer;

    @FindBy(xpath = "")
    private WebElement toDodeleteButton;

    @FindBy(xpath = "")
    private WebElement addNewStatusInput;

    @FindBy(xpath = "")
    private WebElement addNewTaskInput;

    @FindBy(xpath = "")
    private WebElement addNewStatusSubmitButton;

    @FindBy(xpath = "")
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

    public WebElement getTodoDeleteButton() {
        return toDodeleteButton;
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
}
