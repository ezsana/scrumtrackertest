package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.Alert;
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
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getHomepage() {
        return homepage;
    }
}
