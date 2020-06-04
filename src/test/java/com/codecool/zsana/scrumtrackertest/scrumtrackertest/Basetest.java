package com.codecool.zsana.scrumtrackertest.scrumtrackertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basetest {

    private WebDriver driver;
    private String username = "username";
    private String password = "password";
    private String invalidUsername = "u";
    private String invalidPassword = "p";

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/zsana/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void shutDown() {
        if (null != driver) {
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getInvalidUsername() {
        return invalidUsername;
    }

    public String getInvalidPassword() {
        return invalidPassword;
    }
}
