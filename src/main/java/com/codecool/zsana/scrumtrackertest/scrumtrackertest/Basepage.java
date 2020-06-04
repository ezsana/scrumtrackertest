package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basepage {

    private static WebDriver driver;
    private  static WebDriverWait wait;
    private String homepage = "http://192.168.1.105:3000";

    Basepage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/zsana/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
    }

    public static void shutDown() {
        if (null != driver) {
            driver.close();
            driver.quit();
        }
    }

    public boolean isElementPresent(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }


    public void writeIntoInputField(WebElement element, String input) {
        element.sendKeys(input);
    }

    public void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).click();
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

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }
}
