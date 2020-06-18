package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Projectspage extends Basepage {

    @FindBy(xpath = "//*[@id='root']//div[@class='project_text']")
    private WebElement yourProjectsHeading;

    @FindBy(xpath = "//*[@id='root']//div[@class='project_card']/div[contains(text(),'BaseProjectForTest')]")
    private WebElement baseProjectForTestTitle;

    @FindBy(xpath = "//*[@id='root']//div[@class='project_card']/div[contains(text(),'ShareThisProject')]")
    private WebElement shareThisProjectTitle;

    @FindBy(xpath = "//*[@id='root']//div[@class='project_card']/div[contains(text(),'ArchiveThisProject')]")
    private WebElement archiveThisProjectTitle;

    // Archive project sign before AND after archiving:
    @FindBy(xpath = "//*[@id='root']//div[@class='project_card'][3]//span[@aria-label='api']")
    private WebElement getShareThisProjectSign;

    @FindBy(xpath = "//*[@id='root']//div[@class='project_page__create_project_container']//input[@placeholder='Project Name']")
    private WebElement createProjectInput;

    @FindBy(xpath = "//*[@id='root']//div[@class='project_page__create_project_container']//span[@aria-label='plus-circle']")
    private WebElement createProjectSubmitButton;

    @FindBy(xpath = "//*[@id='root']//div[@class='project_text archive']")
    private WebElement showAndHideArchiveProjects;


    public WebElement getCreateProjectInput() {
        getWait().until(ExpectedConditions.visibilityOf(createProjectInput));
        return createProjectInput;
    }

    public WebElement getCreateProjectSubmitButton() {
        getWait().until(ExpectedConditions.visibilityOf(createProjectSubmitButton));
        return createProjectSubmitButton;
    }

    public WebElement createNewProject(String projectName) {
        getWait().until(ExpectedConditions.visibilityOf(createProjectInput));
        writeIntoInputField(createProjectInput, projectName);
        getWait().until(ExpectedConditions.visibilityOf(createProjectInput));
        clickOnElement(createProjectInput);
        return getWait().until(visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + projectName + "')]")));
    }

    public boolean isNewProjectDisplayed(String projectName) {
        return getWait().until(visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + projectName + "')]"))).isDisplayed();
    }

    public void deleteProject(String projectName) {
        WebElement projectCardTitle = searchElementByText(projectName);
        getWait().until(ExpectedConditions.visibilityOf(projectCardTitle));
        WebElement parent = projectCardTitle.findElement(By.xpath("./.."));
        WebElement bin = parent.findElement(By.className("project_tool_container")).findElement(By.xpath("./span[@aria-label='delete']"));
        getWait().until(ExpectedConditions.visibilityOf(bin));
        bin.click();
    }

    public WebElement getYourProjectsHeading() {
        return yourProjectsHeading;
    }

    public WebElement getBaseProjectForTestTitle() {
        return baseProjectForTestTitle;
    }

    public WebElement getShareThisProjectTitle() {
        return shareThisProjectTitle;
    }

    public WebElement getArchiveThisProjectTitle() {
        return archiveThisProjectTitle;
    }

    public WebElement getGetShareThisProjectSign() {
        return getShareThisProjectSign;
    }

    public WebElement getShowAndHideArchiveProjects() {
        return showAndHideArchiveProjects;
    }
}
