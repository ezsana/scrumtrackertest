package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends Basepage {

    @FindBy(xpath = "/html/body/div/div/div/div/div[1]/div/button[1]")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='login_form']/div[1]/input[1]")
    private WebElement usernameInputField;

    @FindBy(xpath = "//div[@class='login_form']/div[2]/input[1]")
    private WebElement passwordInputField;

    @FindBy(xpath = "//button[@class='auth_btn']")
    private WebElement submitButton;

    void validLogin(Homepage homepage) {
        clickOnElement(homepage.getSignInUpButton());
        clickOnElement(signInButton);
        writeIntoInputField(usernameInputField, "zsana");
        writeIntoInputField(passwordInputField, "zsana");
        clickOnElement(submitButton);
    }

    void logout(Homepage homepage) {
        getWait().until(ExpectedConditions.visibilityOf(homepage.getLogoutButton()));
        clickOnElement(homepage.getLogoutButton());
        acceptPopUpAlert();
    }

    public WebElement getUsernameInputField() {
        getWait().until(ExpectedConditions.visibilityOf(usernameInputField));
        return usernameInputField;
    }

    public WebElement getPasswordInputField() {
        getWait().until(ExpectedConditions.visibilityOf(passwordInputField));
        return passwordInputField;
    }

    public WebElement getSubmitButton() {
        getWait().until(ExpectedConditions.visibilityOf(submitButton));
        return submitButton;
    }

    public WebElement getSignInButton() {
        getWait().until(ExpectedConditions.visibilityOf(signInButton));
        return signInButton;
    }
}
