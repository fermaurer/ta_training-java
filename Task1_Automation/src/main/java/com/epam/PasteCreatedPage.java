package com.epam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object class representing the page displayed after creating a paste.
 * Extends {@link BasePage} to inherit WebDriver initialization
 */
public class PasteCreatedPage extends BasePage{

    @FindBy(xpath = "//*[contains(@class,'notice -success -post-view')]")
    private WebElement successMessage;

    /**
     *Constructor to initialize the Paste Created page with WebDriver.
     * @param driver Instance of WebDriver to be used for interacting with the page.
     */
    public PasteCreatedPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Gets the success message displayed after creating a new paste.
     * @return Returns the success message.
     */
    public String getSuccessMessage() {
        String messageText = successMessage.getText();
        return messageText;
    }
}
