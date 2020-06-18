package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignIn extends Basepage {

    @FindBy(xpath = "//*[@id='root']//div[@class='authpage_select_btn_container']/div[contains(text(),'Sign in')]")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id='root']//div[@class='authpage_content']//div[@class='login_input']/input[@type='text']") // !! Type should be username!!
    private WebElement signInUsernameInputField;

    @FindBy(xpath = "//*[@id='root']//div[@class='authpage_content']//div[@class='login_input']/input[@type='password']")
    private WebElement signInPasswordInputField;

    @FindBy(xpath = "//*[@id='root']//div[@class='authpage_content']//div[@class='login_form']//div[contains(text(),'Sign in')]")
    private WebElement signInSubmitButton;

    private String username;

    private String password;

    void validLogin(Homepage homepage) {
        clickOnElement(homepage.getSignInUpButton());
        clickOnElement(signInButton);
        username = "zsana6";
        password = "zsana6";
        writeIntoInputField(signInUsernameInputField, username);
        writeIntoInputField(signInPasswordInputField, password);
        clickOnElement(signInSubmitButton);
    }

    void logout(Homepage homepage) {
        getWait().until(ExpectedConditions.visibilityOf(homepage.getLogoutButton()));
        clickOnElement(homepage.getLogoutButton());
        acceptPopUpAlert();
    }

    public WebElement getSignInUsernameInputField() {
        return signInUsernameInputField;
    }

    public WebElement getSignInPasswordInputField() {
        return signInPasswordInputField;
    }

    public WebElement getSignInSubmitButton() {
        return signInSubmitButton;
    }

    public WebElement getSignInButton() {
        getWait().until(ExpectedConditions.visibilityOf(signInButton));
        return signInButton;
    }
}
