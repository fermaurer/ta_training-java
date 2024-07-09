package com.epam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Represents Google Cloud Welcome page, and provides the methods to interact with its elements
 * Extends the {@link BasePage} class initializes the WebDriver and the WebElements
 */
public class GoogleCloudWelcome extends BasePage{

    @FindBy(xpath = "//span[@class='UywwFc-vQzf8d']")
    private WebElement toEstimate;

    @FindBy(xpath = "//div[@data-idx='0']")
    private WebElement computeEngine;

    /**
     * Constructor to initialize GoogleCloudWelcome with the WebDriver.
     * @param driver WebDriver instance to be used for interacting with the web elements.
     */
    public GoogleCloudWelcome(WebDriver driver) {
        super(driver);
    }

    /**
     * This method waits until the "Add Estimate" button is clickable and then clicks it.
     */
    public void addToEstimate(){
        wait.until(ExpectedConditions.elementToBeClickable(toEstimate));
        toEstimate.click();
    }

    /**
     * Selects the Compute Engine option, by waiting until the compute Engine element is clickable
     * and clicking on it.
     */
    public void selectComputeEngine(){
        wait.until(ExpectedConditions.elementToBeClickable(computeEngine)).click();
    }
}
