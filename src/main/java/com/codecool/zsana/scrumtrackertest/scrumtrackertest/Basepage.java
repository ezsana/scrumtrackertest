package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Basepage {

    private WebDriver driver;
    private String homepage = "http://192.168.1.105:3000";

    Basepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public boolean isElementPresent(WebElement element) {
        return element.isDisplayed();
    }

    public void writeIntoInputField(WebElement element, String input) {
        element.sendKeys(input);
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void navigateToPage(String url) {
        driver.navigate().to(url);
    }

    public void acceptPopUpAlert() {
        for (int i = 0; i < 100; i++) {
            try {
                Alert alert = driver.switchTo().alert();
                alert.accept();
                break;
            } catch (NoAlertPresentException nap) {}
        }
    }

    public void dismissPopUpAlert() {
        for (int i = 0; i < 100; i++) {
            try {
                driver.switchTo().alert().dismiss();
                break;
            } catch (NoAlertPresentException nap) {}
        }
    }

    public String getPopUpMessage() {
        String message = null;
        for (int i = 0; i < 100; i++) {
            try {
                message = driver.switchTo().alert().getText();
            } catch (NoAlertPresentException nap) {}
            if (message != null) {
                break;
            }
        }
        return message;
    }

    public void sendTextToPopUp(String text) {
        for (int i = 0; i < 100; i++) {
            try {
                driver.switchTo().alert().sendKeys(text);
                break;
            } catch (NoAlertPresentException nap) {}
        }
    }

    public String getHomepage() {
        return homepage;
    }


}
