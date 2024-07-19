package com.epam.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Represents Google Cloud Plattform page and provides methods to interact with its elements
 * Extends the {@link BasePage} class that initializes the WebDriver and the WebElements
 */
public class GoogleCloudPlattform extends BasePage{

    @FindBy(xpath = "//b[text()='Google Cloud Pricing Calculator']")
    private WebElement cloudPlattform;

    /**
     * Constructor to initialize GoogleCloudPlattform with the WebDriver.
     * @param driver WebDriver instance to be used for interacting with the web elements.
     */
    public GoogleCloudPlattform(WebDriver driver) {
        super(driver);
    }

    /**
     * Locates the text "Google Cloud Pricing Calculator" and clicks on it.
     */
    public void clickCloudPlattform(){
        cloudPlattform.click();
    }
}
