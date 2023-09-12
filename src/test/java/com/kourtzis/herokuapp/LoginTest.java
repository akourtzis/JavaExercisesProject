package com.kourtzis.herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
    private WebDriver webDriver;

    // Setup
    @BeforeAll
    public static void globalSetup() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setup() {
        webDriver = new FirefoxDriver();
    }

    @AfterEach
    public void close() {
        if(webDriver != null) {
            webDriver.quit();
        }
    }
}
