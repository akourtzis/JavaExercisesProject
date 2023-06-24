package com.kourtzis.mystore;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignInTest {
    private WebDriver webDriver;

    // Setup
    @BeforeAll
    public static void globalSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup() {
        webDriver = new ChromeDriver();
    }

    @AfterEach
    public void close() {
        if(webDriver != null) {
            webDriver.quit();
        }
    }

    // Action
    @Test
    public void signInTest() {
        // Arrange
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        // Act
        webDriver.get("https://the-internet.herokuapp.com/login");
        WebElement usernameInput = webDriver.findElement(By.id("username"));
        WebElement passwordInput = webDriver.findElement(By.id("password"));
        WebElement loginButton = webDriver.findElement(By.className("radius"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        loginButton.click();

        String expectedResult = "You logged into a secure area!\n" + "×";
        String actualResult = webDriver.findElement(By.id("flash")).getText();

        Assertions.assertEquals(expectedResult, actualResult);
    } 
}
