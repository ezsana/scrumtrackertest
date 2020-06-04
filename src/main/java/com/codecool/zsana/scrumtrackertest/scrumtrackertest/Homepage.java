package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {

    @FindBy(xpath = "//a[.='Sign in / up']")
    private WebElement signInUpButton;

    @FindBy(xpath = "//div[@class='text-link']")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/h1")
    private WebElement heading;

    @FindBy(xpath = "//*[@id=\"root\"]/div/nav/ul")
    private WebElement navbar;

    @FindBy(xpath = "//a[contains(.,'Home')]")
    private WebElement homeButton;

    @FindBy(xpath = "//a[contains(.,'Projects')]")
    private WebElement projectsButton;

   Homepage(WebDriver driver) {
       super(driver);
   }

    public WebElement getSignInUpButton() {
       return signInUpButton;
    }

    public WebElement getLogoutButton() {
       return getLogoutButton();
    }

    public WebElement getProjectsButton() {
       return projectsButton;
    }

    public WebElement getHeading() {
        return heading;
    }

    public WebElement getNavbar() {
        return navbar;
    }

    public WebElement getHomeButton() {
        return homeButton;
    }
}
