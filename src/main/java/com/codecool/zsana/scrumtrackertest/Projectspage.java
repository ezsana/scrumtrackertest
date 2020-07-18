package com.codecool.zsana.scrumtrackertest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
    @FindBy(xpath = "//*[@id='root']//div[@class='project_card']/div[contains(text(),'ArchiveThisProject')]/preceding-sibling::div[@class='project_tool_container']/span[@aria-label='api']")
    private WebElement archiveThisProjectSign;

    @FindBy(xpath = "//*[@id='root']//div[@class='project_page__create_project_container']//input[@placeholder='Project Name']")
    private WebElement createProjectInput;

    @FindBy(xpath = "//*[@id='root']//div[@class='project_page__create_project_container']//span[@aria-label='plus-circle']")
    private WebElement createProjectSubmitButton;

    @FindBy(xpath = "//*[@id='root']//div[@class='project_text archive']")
    private WebElement showAndHideArchiveProjects;

    // Error message if project title is less than 3 char
    @FindBy(xpath = "//div[@class='ant-modal-body']//span[contains(text(),'Project title must be minimum 3 character')]")
    private WebElement titleLessThanThreeCharErrorMessage;

    // X to close error window
    @FindBy(xpath = "//div[@class='ant-modal-content']//span[@aria-label='close']")
    private WebElement closeErrorWindow;

    // Container where all the shared projects are
    @FindBy(xpath = "//*[@id='root']//div[contains(text(),'Projects I participated in')]/parent::div/following-sibling::div[1]/div")
    private WebElement sharedProjectsContainer;

    // Shared project delete button
    @FindBy(xpath = "//*[@id='root']//div[contains(text(),'Projects I participated in')]/parent::div/following-sibling::div[1]/div/div[@class='project_tool_container']/span[@aria-label='delete']")
    private WebElement deleteSharedProjectButton;

    // Error message after trying to delete the shared project with different user (zsana)
    @FindBy(xpath = "//span[contains(text(),'You are not the project owner')]")
    private WebElement sharedProjectDeleteErrorMessage;

    // Button to close error message - shared project deletion
    @FindBy(xpath = "//span[contains(text(),'You are not the project owner')]/parent::div/parent::div/preceding-sibling::button")
    private WebElement sharedProjectDeleteErrorMessageCloseButton;


    public WebElement createNewProject(String projectName) {
        getWait().until(ExpectedConditions.visibilityOf(createProjectInput));
        writeIntoInputField(createProjectInput, projectName);
        getWait().until(ExpectedConditions.visibilityOf(createProjectSubmitButton));
        clickOnElement(createProjectSubmitButton);
        return getWait().until(visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + projectName + "')]")));
    }

    public void createNewProjectWithInvalidName(String invalidProjectName) {
        getWait().until(ExpectedConditions.visibilityOf(createProjectInput));
        writeIntoInputField(createProjectInput, invalidProjectName);
        getWait().until(ExpectedConditions.visibilityOf(createProjectSubmitButton));
        clickOnElement(createProjectSubmitButton);
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

    public void archiveAndUnarchiveProject() {
        getWait().until(ExpectedConditions.visibilityOf(archiveThisProjectSign));
        archiveThisProjectSign.click();
    }

    boolean projectIsInArchivedProjectsContainer() {
        //archiveAndUnarchiveProject();
        //showAndHideArchiveProjects.click();
        WebElement project = getDriver().findElement(By.xpath("//div[@class='project_page']/div[@class='sc-AxhCb ixaEwJ'][4]//div[contains(text(),'ArchiveThisProject')]"));
        return project.isDisplayed();
    }

    boolean projectIsUnarchived() {
        showAndHideArchiveProjects.click();
        archiveAndUnarchiveProject();
        for (int i = 0; i < 100; i++) {
            try {
                getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//*[@id='root']//div[@class='sc-AxhCb ixaEwJ project_page__project_list_container'][1]//div[contains(text(),'ArchiveThisProject')]"))));

            } catch (NoSuchElementException nsee) {}
        }
        WebElement project = getDriver().findElement(By.xpath("//*[@id='root']//div[@class='sc-AxhCb ixaEwJ project_page__project_list_container'][1]//div[contains(text(),'ArchiveThisProject')]"));
        return project.isDisplayed();
    }

    void deleteArchivedProject() {

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

    public WebElement getArchiveThisProjectSign() {
        return archiveThisProjectSign;
    }

    public WebElement getShowAndHideArchiveProjects() {
        return showAndHideArchiveProjects;
    }

    public WebElement getTitleLessThanThreeCharErrorMessage() {
        return titleLessThanThreeCharErrorMessage;
    }

    public WebElement getCloseErrorWindow() {
        return closeErrorWindow;
    }

    public WebElement getCreateProjectInput() {
        getWait().until(ExpectedConditions.visibilityOf(createProjectInput));
        return createProjectInput;
    }

    public WebElement getCreateProjectSubmitButton() {
        getWait().until(ExpectedConditions.visibilityOf(createProjectSubmitButton));
        return createProjectSubmitButton;
    }

    public WebElement getSharedProjectsContainer() {
        return sharedProjectsContainer;
    }

    public WebElement getDeletesharedProjectButton() {
        return deleteSharedProjectButton;
    }

    public WebElement getDeleteSharedProjectButton() {
        return deleteSharedProjectButton;
    }

    public WebElement getSharedProjectDeleteErrorMessage() {
        return sharedProjectDeleteErrorMessage;
    }

    public WebElement getSharedProjectDeleteErrorMessageCloseButton() {
        return sharedProjectDeleteErrorMessageCloseButton;
    }
}
