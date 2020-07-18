package com.codecool.zsana.scrumtrackertest;

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

    // Pop-up window message about invalid login
    @FindBy(xpath = "//div[@class='ant-modal-content']//span[contains(text(),'Login failed! Invalid username or password')]")
    private WebElement invalidLoginMessage;

    // Button to close window
    @FindBy(xpath = "//div[@class='ant-modal-content']//span[@aria-label='close']")
    private WebElement closeInvalidLoginWindowButton;

    private String username;

    private String password;

    void validLoginForTest() {
        clickOnElement(signInButton);
        username = "zsana6";
        password = "zsana6";
        writeIntoInputField(signInUsernameInputField, username);
        writeIntoInputField(signInPasswordInputField, password);
        clickOnElement(signInSubmitButton);
    }

    void logoutForTest(Homepage homepage) {
        getWait().until(ExpectedConditions.visibilityOf(homepage.getLogoutButton()));
        clickOnElement(homepage.getLogoutButton());
        getWait().until(ExpectedConditions.visibilityOf(homepage.getLogoutMessage()));
        clickOnElement(homepage.getCloseLogoutWindowButton());
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

    public WebElement getInvalidLoginMessage() {
        return invalidLoginMessage;
    }

    public WebElement getCloseInvalidLoginWindowButton() {
        return closeInvalidLoginWindowButton;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
