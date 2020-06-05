package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Registration extends Basepage {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/div/button[2]")
    private WebElement registrationButton;

    @FindBy(xpath = "//div[@class='registration_form']/div[1]/input[1]")
    private WebElement usernameInputField;

    @FindBy(xpath = "//div[@class='registration_form']/div[2]/input[1]")
    private WebElement passwordInputField;

    @FindBy(xpath = "//button[@class='auth_btn']")
    private WebElement submitButton;

    private String registrationName;

    private String registrationPassword;

    public void setRegistrationNameAndPassword() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm:ss");
        String dateString = dateTime.format(formatter);
        registrationName = "scrumtracker" + dateString;
        registrationPassword = registrationName;
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

    public String getRegistrationName() {
        return registrationName;
    }

    public WebElement getRegistrationButton() {
        return registrationButton;
    }

    public String getRegistrationPassword() {
        return registrationPassword;
    }
}
