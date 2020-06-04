package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registration extends Basepage {

    @FindBy(xpath = "/html/body/div/div/div/div/div[2]/div/div/div[1]/input")
    private WebElement usernameInputField;

    @FindBy(xpath = "/html/body/div/div/div/div/div[2]/div/div/div[2]/input")
    private WebElement passwordInputField;

    @FindBy(xpath = "//button[@class='auth_btn']")
    private WebElement submitButton;

    Registration(WebDriver driver) {
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
