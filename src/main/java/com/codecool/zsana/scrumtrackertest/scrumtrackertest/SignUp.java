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

    // After successful registration window message
    @FindBy(xpath = "//div[@class='ant-modal-content']//span[contains(text(),'registration success please Sign in')]")
    private WebElement successfulRegistrationWindowMessage;

    // After unsuccessful registration error window with error message
    @FindBy(xpath = "//div[@class='ant-modal-content']//span[contains(text(),'Error')]")
    private WebElement errorMessage;

    // Message to use at least five character
    @FindBy(xpath = "//div[@class='ant-modal-content']//span[contains(text(),'Please use at least five character to your username/password')]")
    private WebElement atLeastFiveCharMessage;

    // Message of invalid e-mail
    @FindBy(xpath = "//div[@class='ant-modal-content']//span[contains(text(),'Invalid E-mail adresse please use example@example.com form')]")
    private WebElement invalidEmailMessage;

    // Message of already existing user
    @FindBy(xpath = "//div[@class='ant-modal-content']//span[contains(text(),'Registration failed! This username is in use!')]")
    private WebElement userAlreadyExistsMessage;

    // Message with blank email
    @FindBy(xpath = "//div[@class='ant-modal-content']//span[contains(text(),'Username, password and email fields are required!')]")
    private WebElement blankEmailMessage;


    // X in the corner of the window to close it (both successful and unsuccessful)
    @FindBy(xpath = "//div[@class='ant-modal-content']//span[@aria-label='close']")
    private WebElement closeWindowButton;

    private String signUpName;

    private String signUpPassword;

    private String signUpEmail;

    public void setRegistrationNamePasswordAndEmail() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        String dateString = dateTime.format(formatter);
        signUpName = "scrumtracker" + dateString;
        signUpPassword = signUpName;
        signUpEmail = signUpName + "@" + signUpName + ".com";
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

    public WebElement getSuccessfulRegistrationWindowMessage() {
        return successfulRegistrationWindowMessage;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getAtLeastFiveCharMessage() {
        return atLeastFiveCharMessage;
    }

    public WebElement getInvalidEmailMessage() {
        return invalidEmailMessage;
    }

    public WebElement getUserAlreadyExistsMessage() {
        return userAlreadyExistsMessage;
    }

    public WebElement getCloseWindowButton() {
        return closeWindowButton;
    }

    public String getSignUpEmail() {
        return signUpEmail;
    }

    public WebElement getBlankEmailMessage() {
        return blankEmailMessage;
    }
}
