package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Projectspage extends Basepage {

    @FindBy(xpath = "//input[@class='sc-AxiKw hzGrch']")
    private WebElement createProjectInput;

    @FindBy(xpath = "//*[@id=\"root\"]//div[@class='project_page__create_project_container']//span")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='project_card']")
    private WebElement project1;

    public WebElement getCreateProjectInput() {
        getWait().until(ExpectedConditions.visibilityOf(createProjectInput));
        return createProjectInput;
    }

    public WebElement getSubmitButton() {
        getWait().until(ExpectedConditions.visibilityOf(submitButton));
        return submitButton;
    }

    public WebElement getProject1() {
        getWait().until(ExpectedConditions.visibilityOf(project1));
        return project1;
    }

    public void createNewProject(String projectName) {
        getWait().until(ExpectedConditions.visibilityOf(createProjectInput));
        writeIntoInputField(createProjectInput, projectName);
        getWait().until(ExpectedConditions.visibilityOf(submitButton));
        clickOnElement(submitButton);
    }

    public boolean isNewProjectDisplayed(String projectName) {
        return getWait().until(visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + projectName + "')]"))).isDisplayed();
    }

    public void deleteProject(String projectName) {
        WebElement textDemo = getDriver().findElement(By.xpath("//*[contains(text(),'" + projectName + "')]"));
        getWait().until(ExpectedConditions.visibilityOf(textDemo));
        WebElement grandParent = textDemo.findElement(By.xpath("./..")).findElement(By.xpath("./.."));
        WebElement bin = grandParent.findElement(By.className("status_tool_container")).findElement(By.xpath("./span"));
        getWait().until(ExpectedConditions.visibilityOf(bin));
        bin.click();
    }
}
