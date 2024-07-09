package com.epam;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

/**
 * Represents Google Open Summary page and provides methods to interact with its elements
 * Extends the {@link BasePage} class that initializes the WebDriver and the WebElements
 */
public class OpenSummaryPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class, 'rP2xkc')]")
    private WebElement opensummary;

    /**
     * Constructor to initialize OpenSummaryPage with the WebDriver.
     * @param driver WebDriver instance to be used for interacting with the web elements.
     */
    public OpenSummaryPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Opens the summary page
     */
    public void openSummary() {
        wait.until(ExpectedConditions.visibilityOf(opensummary)).click();}
}
