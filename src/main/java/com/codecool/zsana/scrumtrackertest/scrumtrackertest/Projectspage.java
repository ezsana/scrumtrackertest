package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Projectspage extends Basepage {

    @FindBy(xpath = "//input[@class='sc-AxiKw hzGrch']")
    private WebElement createProjectInput;

    @FindBy(xpath = "")
    private WebElement submitButton;

    @FindBy(xpath = "")
    private WebElement projectnamesContainer;

    Projectspage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCreateProjectInput() {
        return createProjectInput;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getProjectnamesContainer() {
        return projectnamesContainer;
    }
}
