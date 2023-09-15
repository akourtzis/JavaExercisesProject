package com.kourtzis.herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    // Action
    @Test
    public void validUserCanLogInTest() {
        // Arrange
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        // Act
        webDriver.get("https://the-internet.herokuapp.com/login");
        webDriver.findElement(By.id("username")).sendKeys(username);
        webDriver.findElement(By.id("password")).sendKeys(password);
        webDriver.findElement(By.className("radius")).click();

        String expectedResult = "Welcome to the Secure Area. When you are done click logout below.";
        String actualResult = webDriver.findElement(By.className("subheader")).getText();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    // Action
    @Test
    public void invalidUsernameLoginMessageTest() {
        // Arrange
        String invalidUsername = "asdd";
        String password = "SuperSecretPassword!";

        // Act 
        webDriver.get("https://the-internet.herokuapp.com/login");
        webDriver.findElement(By.id("username")).sendKeys(invalidUsername);
        webDriver.findElement(By.id("password")).sendKeys(password);
        webDriver.findElement(By.className("radius")).click();

        String expectedResult = "Your username is invalid!\n" + "×";
        String actualResult = webDriver.findElement(By.className("error")).getText();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    // Action
    @Test
    public void invalidPasswordLoginMessageTest() {
        // Arrange
        String username = "tomsmith";
        String invalidPassword = "aa";

        // Act
        webDriver.get("https://the-internet.herokuapp.com/login");
        webDriver.findElement(By.id("username")).sendKeys(username);
        webDriver.findElement(By.id("password")).sendKeys(invalidPassword);
        webDriver.findElement(By.className("radius")).click();

        String expectedResult = "Your password is invalid!\n" + "×";
        String actualResult = webDriver.findElement(By.className("error")).getText();

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
