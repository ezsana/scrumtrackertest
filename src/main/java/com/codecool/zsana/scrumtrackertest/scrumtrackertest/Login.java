package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends Basepage {

    @FindBy(xpath = "")
    private WebElement usernameInputField;

    @FindBy(xpath = "")
    private WebElement passwordInputField;

    @FindBy(xpath = "")
    private WebElement submitButton;

    Login(WebDriver driver) {
        super(driver);
    }

    public WebElement getUsernameInputField() {
        return usernameInputField;
    }

    public WebElement getPasswordInputField() {
        return passwordInputField;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

}
