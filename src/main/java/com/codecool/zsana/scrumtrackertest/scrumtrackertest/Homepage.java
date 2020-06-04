package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Homepage extends Basepage {

    @FindBy(xpath = "//a[.='Sign in / up']")
    private WebElement signInUpButton;

    @FindBy(xpath = "//a[.='Logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/h1")
    private WebElement heading;

    @FindBy(xpath = "//*[@id=\"root\"]/div/nav/ul")
    private WebElement navbar;

    @FindBy(xpath = "//a[contains(.,'Home')]")
    private WebElement homeButton;

    @FindBy(xpath = "//*[@id=\"root\"]//a[@href=\"/projects\"]")
    private WebElement projectsButton;

    public WebElement getSignInUpButton() {
        getWait().until(ExpectedConditions.visibilityOf(signInUpButton));
        return signInUpButton;
    }

    public WebElement getLogoutButton() {
        getWait().until(ExpectedConditions.visibilityOf(logoutButton));
        return logoutButton;
    }

    public WebElement getProjectsButton() {
        getWait().until(ExpectedConditions.visibilityOf(projectsButton));
        return projectsButton;
    }

    public WebElement getHeading() {
        getWait().until(ExpectedConditions.visibilityOf(heading));
        return heading;
    }

    public WebElement getNavbar() {
        getWait().until(ExpectedConditions.visibilityOf(navbar));
        return navbar;
    }

    public WebElement getHomeButton() {
        getWait().until(ExpectedConditions.visibilityOf(homeButton));
        return homeButton;
    }
}
