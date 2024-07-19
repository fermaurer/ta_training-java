package com.epam.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Represents Google Open Summary page and provides methods to interact with its elements
 * Extends the {@link BasePage} class that initializes the WebDriver and the WebElements
 */
public class OpenSummaryPage extends BasePage {

    @FindBy(xpath = "//a[@class = 'tltOzc MExMre rP2xkc jl2ntd']")
    private WebElement openSummary;

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
        wait.until(ExpectedConditions.visibilityOf(openSummary)).click();}
}
