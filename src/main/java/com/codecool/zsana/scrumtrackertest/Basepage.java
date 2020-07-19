package com.codecool.zsana.scrumtrackertest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Basepage {

    private static WebDriver driver;
    private  static WebDriverWait wait;
    private static String homepage = "http://192.168.1.105:3000";

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

    public static void goToAppUrl() {
        driver.navigate().to(homepage);
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

    public void refreshPage() {
        driver.navigate().refresh();
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

    public WebElement searchElementByText(String elementText) {
        return getWait().until(visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + elementText + "')]")));
    }

    public boolean elementIsNotPresent(WebElement element) {
        return getWait().until(ExpectedConditions.invisibilityOf(element));
    }

    public void clearInputField(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element)).clear();
    }

    public void dragElement(WebElement elementToDrag, WebElement to) {
        Actions actions = new Actions(driver);
        //actions.dragAndDrop(elementToDrag, to).build().perform();
        //actions.clickAndHold(elementToDrag).pause(2000).moveToElement(to).release().build().perform();

        actions.keyDown(Keys.CONTROL)
                .click(elementToDrag)
                .dragAndDrop(elementToDrag, to)
                .keyUp(Keys.CONTROL);

        Action selected = actions.build();
        selected.perform();
        /*
        Actions action = new Actions(driver);
        Action dragDrop = action.dragAndDrop(elementToDrag, to).build();
        dragDrop.perform();
        */
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
