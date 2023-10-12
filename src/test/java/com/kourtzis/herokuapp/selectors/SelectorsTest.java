package com.kourtzis.herokuapp.selectors;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectorsTest {
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

    @ParameterizedTest
    @CsvSource(
        // Arrange
        {
            "table#customers tr:nth-child(2) td:nth-child(1) > span, Google",
            ".tsc_table_s13 tr:nth-child(2) th:nth-child(1) span, Clock Tower Hotel"
        }
    )
    public void tableCSSTest(final String cssSelector, final String expectedResult) {
        final String url = "https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html";

        // Act
        webDriver.get(url);
        final String actualResult = webDriver.findElement(By.cssSelector(cssSelector)).getText();

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("cssSelectors")
    public void inputFieldsCSSTest(Map<String, String> map) throws Exception {
        final String url = "https://selectorshub.com/xpath-practice-page/";
        
        // Act
        webDriver.get(url);
        map.entrySet().forEach(entry -> {
            WebElement inputField = webDriver.findElement(By.cssSelector(entry.getKey()));
            inputField.click();
            inputField.sendKeys(entry.getValue());

            final String actualResult = inputField.getAttribute("value");

            // Assert
            Assertions.assertEquals(entry.getValue(), actualResult);
        });
        
    }

    @ParameterizedTest
    @CsvSource(
        // Arrange
        {
            "//*[@id='userId'],test@mail.com",
            "//*[@title='Password'],secret_password_!!!",
            "/html/body/div[1]/main/div/div[1]/section[2]/div/div[1]/div/div[1]/div/form/div/div[1]/div/div/div/input[1],MyGoogle",
            "/html/body/div[1]/main/div/div[1]/section[2]/div/div[1]/div/div[1]/div/form/div/div[1]/div/div/div/input[2],0123456789",
            "//input[@id='inp_val'],lilie"
        }
    )
    public void inputFieldsXPathTest(final String xpath, final String dummyText) {
        final String url = "https://selectorshub.com/xpath-practice-page/";

        // Act
        webDriver.get(url);
        
        WebElement inputField = webDriver.findElement(By.xpath(xpath));
        inputField.click();
        inputField.sendKeys(dummyText);

        final String actualResult = inputField.getAttribute("value");

        // Assert
        Assertions.assertEquals(dummyText, actualResult);
    }

    // Arrange
    private static Stream<Arguments> cssSelectors() {
    return Stream.of(
      Arguments.of(Map.of("#userId", "test@mail.com", 
                          "#pass", "secret_password_!!!",
                          ".element-companyId input[name=company]", "MyGoogle",
                          ".element-companyId input[name='mobile number']", "0123456789",
                          "#inp_val", "lilie")) 
    );
}

}
