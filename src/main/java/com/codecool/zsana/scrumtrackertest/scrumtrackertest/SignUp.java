package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SignUp extends Basepage {

    @FindBy(xpath = "//*[@id='root']//div[@class='authpage_select_btn_container']/div[contains(text(),'Sign up')]")
    private WebElement signUpButton;

    @FindBy(xpath = "//*[@id='root']//div[@class='registration_form']//input[@placeholder='username']")
    private WebElement signUpUsernameInputField;

    @FindBy(xpath = "//*[@id='root']//div[@class='registration_form']//input[@placeholder='password']")
    private WebElement signUpPasswordInputField;

    @FindBy(xpath = "//*[@id='root']//div[@class='registration_form']//input[@placeholder='e-mail']")
    private WebElement signUpEmailField;

    @FindBy(xpath = "//*[@id='root']//div[@class='registration_form']/div[@class='auth_submit_btn']/div[contains(text(),'Sign up')]")
    private WebElement signUpSubmitButton;

    private String signUpName;

    private String signUpPassword;

    public void setRegistrationNameAndPassword() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm:ss");
        String dateString = dateTime.format(formatter);
        signUpName = "scrumtracker" + dateString;
        signUpPassword = signUpName;
    }

    public WebElement getSignUpUsernameInputField() {
        return signUpUsernameInputField;
    }

    public WebElement getSignUpPasswordInputField() {
        return signUpPasswordInputField;
    }

    public WebElement getSignUpSubmitButton() {
        return signUpSubmitButton;
    }

    public String getSignUpName() {
        return signUpName;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public String getSignUpPassword() {
        return signUpPassword;
    }

    public WebElement getSignUpEmailField() {
        return signUpEmailField;
    }
}
