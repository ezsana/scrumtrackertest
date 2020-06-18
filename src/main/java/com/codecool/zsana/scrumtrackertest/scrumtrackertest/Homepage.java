package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Homepage extends Basepage {

    @FindBy(xpath = "//*[@id='root']//li[@class='nav-item']/a[contains(text(),'Logout')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id='root']//h1[contains(text(), 'WELCOME ')]")
    private WebElement heading;

    @FindBy(xpath = "//*[@id='root']//ul[@class='nav-items']")
    private WebElement navbar;

    @FindBy(xpath = "//*[@id='root']//li[@class='nav-item']/a[contains(text(),' Home')]")
    private WebElement homeButton;

    @FindBy(xpath = "//*[@id='root']//li[@class='nav-item']/a[contains(text(),' Projects')]")
    private WebElement projectsButton;

    @FindBy(xpath = "//*[@id='root']//div[@class='homepage_data_container']/a[@href='/projects']")
    private WebElement checkProjectsLink;

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

    public WebElement getCheckProjectsLink() {
        return checkProjectsLink;
    }
}
